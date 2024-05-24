package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import model.WeekdayTicketStat;

public class WeekdayTicketStatDAO extends DAO{
	private static final String SELECT_WEEKDAYTICKETSTAT = "SELECT dayname_table.dayname, IFNULL(COUNT(tblticket.id), 0) as totalTicket, IFNULL(SUM(tblticket.price)-SUM(DISTINCT tblbill.saleOff), 0) as revenue, count(DISTINCT tblshowtime.id) as nshowtime\r\n"
			+ "FROM (\r\n"
			+ "    SELECT 'Monday' AS dayname UNION ALL \r\n"
			+ "    SELECT 'Tuesday' AS dayname UNION ALL \r\n"
			+ "    SELECT 'Wednesday' AS dayname UNION ALL \r\n"
			+ "    SELECT 'Thursday' AS dayname UNION ALL \r\n"
			+ "    SELECT 'Friday' AS dayname UNION ALL \r\n"
			+ "    SELECT 'Saturday' AS dayname UNION ALL \r\n"
			+ "    SELECT 'Sunday' AS dayname\r\n"
			+ ") dayname_table\r\n"
			+ "LEFT JOIN tblshowtime ON dayname_table.dayname = DAYNAME(tblshowtime.day) AND (tblshowtime.day >= ? AND tblshowtime.day <= ?)\r\n"
			+ "LEFT JOIN tblticket ON tblticket.tblShowtimeID = tblshowtime.id\r\n"
			+ "LEFT JOIN cnpm.tblbill ON cnpm.tblbill.id = cnpm.tblticket.tblBillID\r\n"
			+ "GROUP BY dayname_table.dayname\r\n"
			+ "ORDER BY FIELD(dayname_table.dayname, 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday');\r\n";

	public WeekdayTicketStatDAO() {
		super();
	}
	public List<WeekdayTicketStat> getWeekdayTicketStat(Date st, Date et){
		List<WeekdayTicketStat> weekdayTicketStats = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_WEEKDAYTICKETSTAT);){
			ps.setDate(1, st);
			ps.setDate(2, et);
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while(rs.next()) {
				WeekdayTicketStat weekdayTicketStat = new WeekdayTicketStat();
				weekdayTicketStat.setId(i);;
				weekdayTicketStat.setDayname(rs.getString("dayname"));
				weekdayTicketStat.setTotalTicket(rs.getInt("totalTicket"));
				weekdayTicketStat.setRevenue(rs.getFloat("revenue"));
				weekdayTicketStat.setnShowtime(rs.getInt("nshowtime"));
				weekdayTicketStats.add(weekdayTicketStat);
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return weekdayTicketStats;
	}
}
