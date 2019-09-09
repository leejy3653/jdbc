package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.1.116:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 생성 (받아오기)
			stmt = connection.createStatement();

			// 4. SQL문 실행
			String sql = "Select no, name from department"; // sql 문의 세미콜론은 제거
			stmt.executeQuery(sql);
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while (rs.next() == true) {
				Long no = rs.getLong(1); // = rs.getInt(1);
				String name = rs.getString(2);

				System.out.println(no + ":" + name);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
	}
}
