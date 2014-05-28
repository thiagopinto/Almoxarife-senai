package senai.almoxarife.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL_MYSQL = "jdbc:mysql://localhost/almoxarifado";
	private static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
	private static final String USER = "ClesyoServer";
	private static final String PASS = "72409159";

	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER_CLASS_MYSQL);
			
			return DriverManager.getConnection(URL_MYSQL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	public static void close(Connection conn, PreparedStatement stmt,
			ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
