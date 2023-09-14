package hmhuong.test;

import java.text.SimpleDateFormat;

import hmhuong.dao.KhachHangDAO;
import hmhuong.model.KhachHang;

public class testKhachHangDAO {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			KhachHang c1 = new KhachHang(1, "KhachHang 1", sdf.parse("20/06/2002"), "Ha Noi");
			KhachHang c2 = new KhachHang(2, "KhachHang 2", sdf.parse("20/06/2002"), "Ha Noi");
			// KhachHangDAO.getInstance().insert(c1);
			// KhachHangDAO.getInstance().insert(c2);
			KhachHangDAO.getInstance().delete(c1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
