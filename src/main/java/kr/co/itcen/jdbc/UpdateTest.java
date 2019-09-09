package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		update(1L, "총무1팀");
		update(2L, "영업1팀");
		update(3L, "인사1팀");
	}

	public static Boolean update2(Long no, String name) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.1.116:3306/webdb?characterEncoding=utf8";
			// 눈에 잘보이고 + 연산을 안해줘도 된다
			// 보안에 좋다.
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 시키기
			String sql = "update department set name = ? where no = ?";
			connection.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, name);
			pstmt.setLong(2, no);

			// 5. SQL문 실행
			int count = pstmt.executeUpdate(); // ()안에 sql을 넣게 된다면 에러가 날 수도 있다.
			result = (count == 1);

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
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

	public static Boolean update(Long no, String name) {

		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.1.116:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statment 객체 생성(받아오기)
			stmt = connection.createStatement();

			// 4. SQL문 실행
			String sql = "update department set name='" + name + "' where no = " + no;
			int count = stmt.executeUpdate(sql);
			result = (count == 1);

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

}
