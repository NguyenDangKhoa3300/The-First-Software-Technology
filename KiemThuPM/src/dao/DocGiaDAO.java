package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.DocGia;

public class DocGiaDAO {
	//ArrayList<DocGia> dsMHP =  new ArrayList<DocGia>();
	public DocGiaDAO() {

	}
	public ArrayList<DocGia> doctubang() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<DocGia> dsDG = new ArrayList<DocGia>();
		String sql = "select * from DocGia";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDG = rs.getString(1);
				String tenDG = rs.getString(2);
				String namSinh = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				DocGia dg = new DocGia(maDG, tenDG, namSinh, cmnd, sdt);
				dsDG.add(dg);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDG;
	}

	public ArrayList<DocGia> TimDocGiaBangMa(String ma) {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<DocGia> list = new ArrayList<>();
		String sql = "select * from DocGia where MaSV = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDG = rs.getString(1);
				String tenDG = rs.getString(2);
				String namSinh = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				DocGia dg = new DocGia(maDG, tenDG, namSinh, cmnd, sdt);
				list.add(dg);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
