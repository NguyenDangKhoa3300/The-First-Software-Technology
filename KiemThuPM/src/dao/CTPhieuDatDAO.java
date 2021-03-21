package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.ChiTietPhieuDat;

public class CTPhieuDatDAO {
	public ArrayList<ChiTietPhieuDat> doctubangPhieuDat(String mapPD) {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<ChiTietPhieuDat> dsCTPD = new ArrayList<ChiTietPhieuDat>();
		String sql = "select * from ChiTietPhieuDat where mapd = '"+mapPD+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maPD = rs.getString(1);
				String maNXB = rs.getString(2);
				String tenSach = rs.getString(3);
				String soLuong = rs.getString(4);
				String donGia = rs.getString(5);
				ChiTietPhieuDat ctPD = new ChiTietPhieuDat(maPD, maNXB, tenSach, soLuong, donGia);
				dsCTPD.add(ctPD);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCTPD;
	}
	public ArrayList<String> JComBoBoxNXB() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<String> listNXB = new ArrayList<String>();
		String sql = "SELECT * FROM NhaXuatBan";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tenNV = rs.getString("tennxb");
				listNXB.add(tenNV);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNXB;
	}
	public void themPhieuDat(String maPD,String tenNXB, String tenSach, String soLuong, String donGia) {
		
		String maNXB = getMaNXB(tenNXB);
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Insert into ChiTietPhieuDat values('"+maPD+"','"+maNXB+"','"+tenSach+"',"+soLuong+","+donGia+");";
			System.out.print(querry);
			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Added");
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
public String getMaNXB(String tenNXB) {
		
		String maNXB = "";
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Select manxb from NhaXuatBan where tenNXB = N'"+tenNXB+"'";
			System.out.println(querry);
			PreparedStatement ps = con.prepareStatement(querry);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				maNXB = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maNXB;
	}
public void xoaCTPD(String idTenSach) {
	
	
	try {
		Connection con = DataBase.getInstance().getConnection();
		String querry = "delete from ChiTietPhieuDat where TenSach = N'"+idTenSach+"'";
		System.out.println(querry);
		PreparedStatement ps = con.prepareStatement(querry);
		
		ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
	

