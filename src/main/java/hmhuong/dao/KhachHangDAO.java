package hmhuong.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hmhuong.database.JDBCUtil;
import hmhuong.model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {
	static private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int delete(KhachHang t) {
		int result = 0;
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "delete from khachHang where id = " + t.getId();
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
	public int insert(KhachHang t) {
		int result = 0;
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "insert into khachHang(id, hoVaTen, diaChi, ngaySinh) "
					+ "values(" + t.getId() + ", N'" + t.getHoVaTen() + "', '" + t.getDiaChi() + "', '"
					+ sdf.format(t.getNgaySinh()) + "')";
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
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(KhachHang t) {
		int result = 0;
		Connection connection = JDBCUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "update khachHang set hoVaTen = N'" + t.getHoVaTen() + "', diaChi = '" + t.getDiaChi()
					+ "', ngaySinh = '" + sdf.format(t.getNgaySinh()) + "' where id = " + t.getId();
			System.out.println("Thực thi câu lệnh SQL: " + sql);
			result = statement.executeUpdate(sql);
			System.out.println("Có " + result + " bị thay đổi");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeConnection(connection);
		return result;
	}

}
