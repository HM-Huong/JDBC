package hmhuong.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				+ PreparedStatement: thực thi câu lệnh SQL có tham số (nên sử dụng thay cho Statement vì Statement có thể bị lỗi SQL Injection)
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

			// ----------- Chống SQL Injection -----------
			String psSQL = "INSERT INTO people(last_name, first_name, gender, dob, income) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(psSQL);
			preparedStatement.setString(1, "3333");
			preparedStatement.setString(2, "4444");
			preparedStatement.setString(3, "M");
			preparedStatement.setString(4, "2004-04-04");
			preparedStatement.setDouble(5, 40000);
			check = preparedStatement.executeUpdate();

			// đóng kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
