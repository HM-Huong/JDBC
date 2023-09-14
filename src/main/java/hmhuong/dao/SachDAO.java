package hmhuong.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Statement;

import hmhuong.database.JDBCUtil;
import hmhuong.model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int delete(Sach t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement statement = connection.createStatement();
			String sql = "delete from sach where id = " + t.getId();
			System.out.println("Thực thi câu lệnh SQL: " + sql);
			result = statement.executeUpdate(sql);
			System.out.println("Có " + result + " bị thay đổi");

			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int insert(Sach t) {
		int result = 0;
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "insert into sach(id, tenSach, gia, namXuatBan) "
					+ "values(" + t.getId() + ", N'" + t.getTenSach() + "', "
					+ t.getGia() + ", " + t.getNamXuatBan() + ")";
			System.out.println("Thực thi câu lệnh SQL: " + sql);
			result = statement.executeUpdate(sql);
			System.out.println("Có " + result + " bị thay đổi");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.closeConnection(connection);
		return result;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> result = new ArrayList<Sach>();
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from sach";
			System.out.println("Thực thi câu lệnh SQL: " + sql);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String tenSach = rs.getString("tenSach");
				int gia = rs.getInt("gia");
				int namXuatBan = rs.getInt("namXuatBan");
				result.add(new Sach(id, tenSach, gia, namXuatBan));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.closeConnection(connection);
		return result;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> result = new ArrayList<Sach>();
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from sach where " + condition;
			System.out.println("Thực thi câu lệnh SQL: " + sql);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String tenSach = rs.getString("tenSach");
				int gia = rs.getInt("gia");
				int namXuatBan = rs.getInt("namXuatBan");
				result.add(new Sach(id, tenSach, gia, namXuatBan));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.closeConnection(connection);
		return result;
	}

	@Override
	public Sach selectById(Sach t) {
		Sach result = null;
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from sach where id = " + t.getId();
			System.out.println("Thực thi câu lệnh SQL: " + sql);
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String tenSach = rs.getString("tenSach");
				int gia = rs.getInt("gia");
				int namXuatBan = rs.getInt("namXuatBan");
				result = new Sach(id, tenSach, gia, namXuatBan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.closeConnection(connection);
		return result;
	}

	@Override
	public int update(Sach t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();

			Statement statement = connection.createStatement();
			String sql = "update sach set tenSach = N'" + t.getTenSach()
					+ "', gia = " + t.getGia() + ", namXuatBan = "
					+ t.getNamXuatBan() + " where id = " + t.getId();
			System.out.println("Thực thi câu lệnh SQL: " + sql);
			result = statement.executeUpdate(sql);
			System.out.println("Có " + result + " bị thay đổi");

			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
