package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String id = "hr";
		String pass = "hr";

		Connection conn = DriverManager.getConnection(url, id, pass);

		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
	}
}
