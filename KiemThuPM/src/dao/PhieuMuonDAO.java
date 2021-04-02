package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.DocGia;
import entities.PhieuMuon;

public class PhieuMuonDAO {
	public PhieuMuonDAO() {
		
	}
	public ArrayList<PhieuMuon> doctubangPhieuMuon() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuMuon> dsPM = new ArrayList<PhieuMuon>();
		String sql = "select MaPM, Madocgia,HoTen , Ngaymuon, Ngaytra from DocGia, PhieuMuon where MaSV = Madocgia";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPM = rs.getString(1);
				String maDG = rs.getString(2);
				String tenDG = rs.getString(3);
				String ngayMuon = rs.getString(4);
				String ngayTra = rs.getString(5);
				
				PhieuMuon pm = new PhieuMuon(maPM, maDG, tenDG, ngayMuon, ngayTra);
				dsPM.add(pm);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPM;
	}
	public ArrayList<PhieuMuon> TimPhieuMuonBangMa(String ma) {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuMuon> list = new ArrayList<>();
		String sql = "select MaPM, Madocgia,HoTen , Ngaymuon, Ngaytra from DocGia, PhieuMuon where MaPM = ? AND MaSV = Madocgia";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPM = rs.getString(1);
				String maDG = rs.getString(2);
				String tenDG = rs.getString(3);
				String ngayMuon = rs.getString(4);
				String ngayTra = rs.getString(5);
				
				PhieuMuon pm = new PhieuMuon(maPM, maDG, tenDG, ngayMuon, ngayTra);
				list.add(pm);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
