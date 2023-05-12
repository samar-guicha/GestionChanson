package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.entities.User;

public class GestionUserImp implements IGestionUser{
	Connection cnx = SingletonConnection.getInstance();
	@Override
	public String getUsername(String login, String password) {

		try {
			PreparedStatement ps = cnx.prepareStatement("select username from user where login=? and password=?");
			ps.setString(1,login);
			ps.setString(2,password);
			ResultSet rs =ps.executeQuery();
			if(rs.next())
				return rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	
	
}
