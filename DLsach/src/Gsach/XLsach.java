package Gsach;

import java.awt.dnd.DropTargetContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class XLsach {
	private Connection cn;
	public static Connection getCon() {
		Connection cn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/dlsach","root","0123456789");
		} catch (ClassNotFoundException|SQLException e) {
			// TODO: handle exception
			
		}
		return cn;
	}
	//in ds ra
	public ArrayList<Sach>getSA(){
		Connection cn=getCon();
		String sql = "select * from tbsach ";
		//chua ds khi ket noi csdl them vao
		ArrayList<Sach> lsSach = new ArrayList<>();
		try {
			//tạo truy vấn 
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			//khong nho
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				// tạo đối tượng sách
				Sach s = new Sach();
				//tham chứa đến csdl gán gtri vao bang
				s.setMaS(rs.getString("MaS"));
				s.setTenS(rs.getString("TenS"));
				s.setNamXB(rs.getInt("NamXB"));
				s.setGiaB(rs.getDouble("GiaB"));
				lsSach.add(s);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println();
		}
		return lsSach;
	}
	//xoa
	public boolean deleteSA(int NamXB) {
		Connection cn = getCon();
		String sql = "delete from tbsach where NamXB=? ";
		//chua ds khi ket noi csdl them vao
		try {
			//tạo truy vấn 
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setInt(1,NamXB);
			ps.executeUpdate();
			cn.close();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(getCon());
	}
}
