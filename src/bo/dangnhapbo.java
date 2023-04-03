package bo;

import java.util.ArrayList;

import bean.dangnhapbean;
import bean.sachbean;
import dao.dangnhapdao;

public class dangnhapbo {
	dangnhapdao dndao = new dangnhapdao();
	public dangnhapbean ktdn (String tenDangNhap, String matKhau) throws Exception{
		return dndao.ktdn(tenDangNhap, matKhau);
	}
}
