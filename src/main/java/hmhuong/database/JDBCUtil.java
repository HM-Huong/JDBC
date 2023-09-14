package hmhuong.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		// Đăng ký JDBC với driver managermanager
		Driver driver;
		try {
			driver = new Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mySQL://localhost:3301/nhasach";
			String username = "root";
			String password = "HMHuong1408";

			// Tạo kết nối
			c = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName() + " " + mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
