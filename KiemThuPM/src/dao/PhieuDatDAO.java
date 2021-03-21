package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.PhieuDat;
import entities.PhieuMuon;

public class PhieuDatDAO {
	private static int tienToPD = 4;
	public PhieuDatDAO() {

	}

	public ArrayList<PhieuDat> doctubangPhieuDat() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuDat> dsPD = new ArrayList<PhieuDat>();
		String sql = "Select PD.MAPD,NV.TenNV,PD.NGAYNHAP from PhieuDat PD, NHANVIEN NV  " + "WHERE PD.MANV = NV.MANV";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maPD = rs.getString(1);
				String tenNV = rs.getString(2);
				String ngayDat = rs.getString(3);

				PhieuDat pd = new PhieuDat(maPD, tenNV, ngayDat);
				dsPD.add(pd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPD;
	}

	public ArrayList<PhieuDat> TimPhieuDatBangMa(String ma) {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuDat> list = new ArrayList<>();
		String sql = "Select PD.MAPD,NV.TenNV,PD.NGAYNHAP from PhieuDat PD, NHANVIEN NV  "
				+ "WHERE MAPD = ? AND PD.MANV = NV.MANV" + " group by PD.MaPD, NV.TenNV, PD.NgayNhap";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maPD = rs.getString(1);
				String tenNV = rs.getString(2);
				String ngayDat = rs.getString(3);
				PhieuDat pd = new PhieuDat(maPD, tenNV, ngayDat);
				list.add(pd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void themPhieuDat(String tenNV, String timeDat) {
		String maPD = "PD"+ tienToPD; 
		String manv = getMaNV(tenNV);
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Insert into PhieuDat values('"+maPD+"','"+manv+"','"+timeDat+"');";
			
			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Added");
			tienToPD++;
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public String getMaNV(String tenNV) {
		
		String maNV = "";
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Select manv from nhanvien where tenNV = N'"+tenNV+"'";
			System.out.println(querry);
			PreparedStatement ps = con.prepareStatement(querry);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 maNV = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maNV;
	}

	public ArrayList<String> JComBoBoxNV() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<String> listNV = new ArrayList<String>();
		String sql = "SELECT * FROM NHANVIEN";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tenNV = rs.getString("tennv");
				listNV.add(tenNV);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNV;
	}
}
