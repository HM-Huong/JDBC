package hmhuong.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import hmhuong.database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		try {
			// Tạo kết nối
			Connection connection = JDBCUtil.getConnection();

			JDBCUtil.printInfo(connection);

			/* Tạo ra đối tượng statement:
				+ Statement: thực thi câu lệnh SQL không có tham số
				+ PreparedStatement: thực thi câu lệnh SQL có tham số
				+ CallableStatement: thực thi các câu lệnh SQL gọi các hàm, thủ tục trong CSDL
			*/
			Statement statement = connection.createStatement();

			/* thực thi câu lệnh SQL
					+ ResultSet executeQuery(String sql): thực thi câu lệnh SELECT
					+ int executeUpdate(String sql): thực thi các câu lệnh INSERT, UPDATE, ... Trả về số dòng thay đổi
					+ boolean execute(String sql): thực thi mọi câu lệnh SQL
			*/
			String sql = "INSERT INTO people(last_name, first_name, gender, dob, income) VALUES\n" +
					"    ('1111', '2222', 'F', '2002-02-20', 50000);";
			int check = statement.executeUpdate(sql);

			// hiển thị kết quả
			System.out.println("Số dòng thay đổi: " + check);
			if (check > 0) {
				System.out.println("Thêm thành công");
			} else {
				System.out.println("Thêm thất bại");
			}

			// đóng kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
