package hmhuong.test;

import java.util.ArrayList;

import hmhuong.dao.SachDAO;
import hmhuong.model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
		Sach s1 = new Sach(1, "Sach 1", 10000, 2010);
		Sach s2 = new Sach(2, "Sach 2", 22000, 2011);

		// SachDAO.getInstance().insert(s1);
		// SachDAO.getInstance().insert(s2);
		// SachDAO.getInstance().delete(s1);
		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
		for (Sach sach : list) {
			System.out.println(sach);
		}
		System.out.println("................................");
		System.out.println(SachDAO.getInstance().selectById(s2));

		System.out.println("................................");
		System.out.println(SachDAO.getInstance().selectByCondition("gia <= 100000"));
	}
}
