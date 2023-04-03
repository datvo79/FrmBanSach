package bo;

import dao.KetNoi;

public class KetNoiBo {
	KetNoi kn = new KetNoi();
	public void ketnoi(String sever, String database, String username, String password) throws Exception{
		kn.ketnoi(sever, database, username, password);
	}
}
