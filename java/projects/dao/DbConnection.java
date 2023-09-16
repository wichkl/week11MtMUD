package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

//built in the DAO layer

public class DbConnection {
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;
	
	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		
		//call to DriverManager
		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Connection established to " + SCHEMA + "!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection failed at" + uri);
			throw new DbException(e);
		}
	}
}
