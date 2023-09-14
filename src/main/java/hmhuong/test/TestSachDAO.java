package hmhuong.test;

import hmhuong.dao.SachDAO;
import hmhuong.model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
		Sach s1 = new Sach(1, "Sach 1", 10000, 2010);
		Sach s2 = new Sach(2, "Sach 2", 22000, 2011);

		// SachDAO.getInstance().insert(s2);
		// SachDAO.getInstance().update(s2);
		SachDAO.getInstance().delete(s1);
	}
}
