package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.Bill;
import model.Client;

public class BillDAO extends DAO{
	private static final String SELECT_BILL = "select tblclient.name, count(tblticket.id) as totalTicket, sum(tblticket.price)-sum(distinct tblbill.saleOff) as totalAmount, tblbill.paymentDate\r\n"
			+ "from cnpm.tblshowtime, tblticket, tblbill, tblclient\r\n"
			+ "where tblshowtime.id = ? and tblticket.tblShowtimeID = ? and tblbill.id = tblticket.tblBillID and tblbill.tblClientID = tblclient.id\r\n"
			+ "group by tblbill.id\r\n"
			+ "order by tblbill.paymentDate;";

	public BillDAO() {
		super();
	}
	
	public List<Bill> getBillofShowtime(Date st, Date et, String dayname, int idS){
		List<Bill> bills = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_BILL);){
			ps.setInt(1, idS);
			ps.setInt(2, idS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bill bill = new Bill();
				bill.setTotalTicket(rs.getInt("totalTicket"));
				bill.setTotalAmount(rs.getFloat("totalAmount"));
				bill.setPaymentDate(rs.getDate("paymentDate"));
				Client client = new Client();
				client.setName(rs.getString("name"));
				bill.setClient(client);
				bills.add(bill);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bills;
	}
}
