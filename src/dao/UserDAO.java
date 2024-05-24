package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO extends DAO{
	private static final String SELECT_USER = "select * from tblUser where username = ? and password = ?";

	public UserDAO() {
		super();
	}
	
	public boolean checkLogin(User user) {
		boolean result = false;
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_USER);){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setFullname(rs.getString("fullname"));
				user.setPosition(rs.getString("position"));
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
