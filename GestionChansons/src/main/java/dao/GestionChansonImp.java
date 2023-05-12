package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.entities.Chanson;

public class GestionChansonImp implements IGestionChanson {

	Connection cnx = SingletonConnection.getInstance();

	@Override
	public void ajouterChanson(Chanson c) {
		try {
			PreparedStatement ps = cnx.prepareStatement("insert into chanson(title,duree) values(?,?)");
			ps.setString(1, c.getTitle());
			ps.setDouble(2, c.getDuree());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerChanson(int id) {
		try {
			PreparedStatement ps = cnx.prepareStatement("delete from chanson where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mettreAJourChanson(Chanson c) {
		try {
			PreparedStatement ps = cnx.prepareStatement("update chanson set title=?,duree=? where id=?");
			ps.setString(1, c.getTitle());
			ps.setDouble(2, c.getDuree());
			ps.setInt(3, c.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Chanson> getAllChansons() {
		List<Chanson> liste = new ArrayList<Chanson>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from chanson");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(new Chanson(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Chanson> getChansonBMC(String motcle) {
		List<Chanson> liste = new ArrayList<Chanson>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from chanson where title like ?");
			ps.setString(1, "%" + motcle + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(new Chanson(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public Chanson getChanson(int id) {
		Chanson v = new Chanson();
		try {
			PreparedStatement ps = cnx.prepareStatement("select title,duree from chanson where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Chanson(id, rs.getString(1), rs.getDouble(2));
			}
		} catch (SQLException e) {

		}
		return v;
	}

	@Override
	public List<Chanson> getChansonsByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
