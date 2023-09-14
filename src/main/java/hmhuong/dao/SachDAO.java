package hmhuong.dao;

import java.sql.Connection;
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
		try {
			Connection connection = JDBCUtil.getConnection();

			Statement statement = connection.createStatement();
			String sql = "insert into sach(id, tenSach, gia, namXuatBan) "
					+ "values(" + t.getId() + ", N'" + t.getTenSach() + "', "
					+ t.getGia() + ", " + t.getNamXuatBan() + ")";
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
	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sach selectById(Sach t) {
		// TODO Auto-generated method stub
		return null;
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
