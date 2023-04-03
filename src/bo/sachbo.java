package bo;

import java.util.ArrayList;

import bean.loaibean;
import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao = new sachdao();
	ArrayList<sachbean> ds;
	public ArrayList<sachbean> getsach() throws Exception{
		ds = sdao.getsach();
		return ds;
}
	public ArrayList<sachbean> Tim(String key) throws Exception{
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean sach : ds) {
			if (sach.getMasach().toLowerCase().trim().equals(key.toLowerCase().trim())) {
				tam.add(sach);
			}
		}
		return tam;
	}
	public ArrayList<sachbean> Ban(int slmua, String masach) throws Exception {
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			sachbean nv = ds.get(i);
			if(ds.get(i).getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				nv.setSoluong(ds.get(i).getSoluong()-slmua);
				ds.set(i, nv);
				sdao.Ban(slmua,masach);
			}
		}
		return ds;
	}
	public ArrayList<sachbean> LietKeMaSach(loaibean maloai) throws Exception{
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean sach : ds) {
			if (sach.getMaloai().equals(maloai.getMaloai())) {
				tam.add(sach);
			}
		}
		return tam;
	}
}
