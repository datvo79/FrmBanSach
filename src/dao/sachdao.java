package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getsach() throws Exception{
		try {
			ArrayList<sachbean> ds = new ArrayList<sachbean>();
			// b1: Ket noi vao csdl
//			KetNoi kn = new KetNoi();
//			kn.ketnoi();
			// B2: Tao cau lenh sql
			String sql = "select * from sach";
			// B3: tao cau lenh
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			// b4: Thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			// b5: Duyet qua rs
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String maloai = rs.getString("maloai");
				String sotap = rs.getString("sotap");
				String anh = rs.getString("anh");
				Date ngayNhap = rs.getDate("ngayNhap");
				String tacgia = rs.getString("tacgia");
				ds.add(new sachbean(masach,tensach,soluong,gia,maloai,sotap,anh,ngayNhap,tacgia));
			}
			rs.close();
			KetNoi.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int Ban(int slmua, String masach) {
		try {
			// b1: Ket noi vao csdl
//			KetNoi kn = new KetNoi();
//			kn.ketnoi();
			// B2: Tao cau lenh sql
			String sql = "update sach set soluong = soluong - ?  where masach=?";
			// B3: tao cau lenh
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			cmd.setLong(1, slmua);
			cmd.setString(2, masach);
			int kq = cmd.executeUpdate();
			KetNoi.cn.close();
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}
