package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static DBConnect instance = new DBConnect();
	private static Connection con = null;
	private static String DB_URL = "jdbc:mysql://localhost:3306/qlthuvien";
    private static String USER_NAME = "root";
    private static String PASSWORD = "0909272491";
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	public static DBConnect getInstance() {
		return instance;
	}
}
