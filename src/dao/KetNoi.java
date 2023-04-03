package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public static Connection cn;
	public void ketnoi() throws Exception{
		//B1: xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		String url="jdbc:sqlserver://DESKTOP-VPF0AQ3\\MSSQLSERVER1:1433;databaseName=QlSach; user=sa; password=123;";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi den csdl QLNV");
	}
	public void ketnoi(String sever, String database, String username, String password) throws Exception{
		//B1: xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		String url="jdbc:sqlserver://"+sever+":1433;databaseName="+database+"; user="+username+"; password="+password+";";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi den csdl QLNV");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
