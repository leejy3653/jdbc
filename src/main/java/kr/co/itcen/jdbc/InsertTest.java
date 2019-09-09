package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) {
		insert("경영지원팀1");
		insert("경영지원팀2");
		insert("경영지원팀3");
	}

	public static Boolean insert(String name) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.1.116:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 생성 (받아오기)
			stmt = connection.createStatement();

			// 4. SQL문 실행
			String sql = "insert into department values(null, '" + name + "')"; // 비효율적
			int count = stmt.executeUpdate(sql); // 중요

			result = (count == 1);

			// 5. 결과 가져오기

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
} // 결과는 워크벤치로 가서 Select no, name from department; 실행
