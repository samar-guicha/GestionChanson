package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	
private static Connection connection;
	
	private SingletonConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//chargement du driver
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify1","root","");
			System.out.println("etablissement de la connexion...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		
		if(connection == null)
			new SingletonConnection();
		return connection;
	}
}
