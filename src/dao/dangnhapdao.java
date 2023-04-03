package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.dangnhapbean;
public class dangnhapdao {
	public dangnhapbean ktdn(String tendangnhap, String matkhau) throws Exception{
		try {
			String sql = "select * from DangNhap where TenDangNhap = ? and MatKhau = ?";
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			cmd.setString(1, tendangnhap);
			cmd.setString(2, matkhau);
			ResultSet rs = cmd.executeQuery();
			dangnhapbean dn = null;
			if (rs.next()) {
				Boolean quyen = rs.getBoolean("Quyen");
				dn = new dangnhapbean(tendangnhap, matkhau,quyen);
			} 
			rs.close();
			return dn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
