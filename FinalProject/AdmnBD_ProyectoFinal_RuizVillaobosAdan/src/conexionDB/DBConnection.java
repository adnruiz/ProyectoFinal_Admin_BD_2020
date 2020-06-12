package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
	private static DBConnection instance;
	public static Connection connection;
	public Connection getConnection() {
		try {
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/BD_InventarioBar?useTimezone=true&serverTimezone=UTC","adan", "12345");
			}
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Conexión fallida", e);
		}
	}
	
	public static Connection getConnection(String user, String password, String url) {
		try {
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
			}
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Conexión fallida", e);
		}
	}

	public static DBConnection getInstance() throws SQLException {
		// TODO Auto-generated method stub
		if(instance == null) {
			instance = new DBConnection();
		}else if(instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}	
}

