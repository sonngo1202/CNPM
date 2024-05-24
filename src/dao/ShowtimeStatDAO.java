package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cinema;
import model.Movie;
import model.Room;
import model.ShowtimeStat;
import model.WeekdayTicketStat;

public class ShowtimeStatDAO extends DAO{
	private static final String SELECT_SHOWTIMESTAT = "select showtime.id, showtime.startime, showtime.day, tblmovie.name as movie, tblroom.name as room, tblcinema.name as cinema, ifnull(count(tblticket.id), 0) as totalTicket, ifnull(sum(tblticket.price)-sum(distinct tblbill.saleOff), 0) as revenue\r\n"
			+ "from (select * from tblshowtime where dayname(tblshowtime.day) = ? and tblshowtime.day >= ? and tblshowtime.day <= ?) showtime\r\n"
			+ "left join tblticket on tblticket.tblShowtimeID = showtime.id\r\n"
			+ "join tblmovie on tblmovie.id = showtime.tblMovieID\r\n"
			+ "join tblroom on tblroom.id = showtime.tblRoomID\r\n"
			+"join cnpm.tblcinema on tblroom.tblCinemaID = tblcinema.id\r\n"
			+ "left join tblbill on tblbill.id = tblticket.tblBillID\r\n"
			+ "group by showtime.id;\r\n";

	public ShowtimeStatDAO() {
		super();
	}
	public List<ShowtimeStat> getShowtimeofWeekday(String dayname, Date st, Date et){
		List<ShowtimeStat> showtimeStats = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_SHOWTIMESTAT);){
			ps.setString(1, dayname);
			ps.setDate(2, st);
			ps.setDate(3, et);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ShowtimeStat showtimeStat = new ShowtimeStat();
				showtimeStat.setId(rs.getInt("id"));
				showtimeStat.setStarttime(rs.getString("startime"));
				showtimeStat.setDaty(rs.getDate("day"));
				Movie movie = new Movie();
			    movie.setName(rs.getString("movie"));
			    showtimeStat.setMovie(movie);
			    Room room = new Room();
			    room.setName(rs.getString("room"));
			    Cinema cinema = new Cinema();
			    cinema.setName(rs.getString("cinema"));
			    room.setCinema(cinema);
			    showtimeStat.setRoom(room);
			    showtimeStat.setTotalTicket(rs.getInt("totalTicket"));
			    showtimeStat.setRevenue(rs.getFloat("revenue"));
			    showtimeStats.add(showtimeStat);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return showtimeStats;
	}
}
