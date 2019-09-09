package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			//1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.1.116:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			
			System.out.println("연결성공!");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
