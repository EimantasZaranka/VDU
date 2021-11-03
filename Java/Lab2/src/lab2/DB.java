package lab2;

import java.sql.*;

public class DB {
	private static final String url = "jdbc:mysql://localhost:3306/java";
	private static final String username = "root";
	private static final String password = "123456789";

	DB(){
		
	}
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			throw new RuntimeException("Error connecting to the database", e);
		}
	}
}

