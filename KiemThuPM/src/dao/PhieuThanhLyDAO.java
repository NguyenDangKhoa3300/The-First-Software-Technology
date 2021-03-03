package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.PhieuDat;
import entities.PhieuThanhLy;

public class PhieuThanhLyDAO {
	public PhieuThanhLyDAO() {
		
	}
	public ArrayList<PhieuThanhLy> doctubangPhieuThanhLy() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuThanhLy> dsPTL = new ArrayList<PhieuThanhLy>();
		String sql = "select PTL.MaPTL, NV.TenNV, PTL.NgayThanhLy, Count(CTPTL.MaSach) as \"Số Lượng Sách\" , SUM(CTPTL.DonGia) as \"Tổng Tiền\"\r\n"
				+ "from PhieuThanhLy PTL, NhanVien NV, ChiTietPhieuThanhLy CTPTL\r\n"
				+ "where PTL.MaPTL = CTPTL.MaPTL AND NV.MaNV = PTL.MaNV\r\n"
				+ "group by PTL.MaPTL, NV.TenNV, PTL.NgayThanhLy";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPTL = rs.getString(1);
				String tenNV = rs.getString(2);
				String ngayTL = rs.getString(3);
				String soLuongSach = rs.getString(4);
				String tongTien = rs.getString(5);
				PhieuThanhLy ptl = new PhieuThanhLy(maPTL, tenNV, ngayTL, soLuongSach, tongTien);
				dsPTL.add(ptl);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPTL;
	}
	public ArrayList<PhieuThanhLy> TimPhieuThanhLyBangMa(String ma) {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuThanhLy> list = new ArrayList<>();
		String sql = "select PTL.MaPTL, NV.TenNV, PTL.NgayThanhLy, Count(CTPTL.MaSach) as \"Số Lượng Sách\" , SUM(CTPTL.DonGia) as \"Tổng Tiền\"\r\n"
				+ "from PhieuThanhLy PTL, NhanVien NV, ChiTietPhieuThanhLy CTPTL\r\n"
				+ "where PTL.MaPTL = ? AND PTL.MaPTL = CTPTL.MaPTL AND NV.MaNV = PTL.MaNV\r\n"
				+ "group by PTL.MaPTL, NV.TenNV, PTL.NgayThanhLy";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPTL = rs.getString(1);
				String tenNV = rs.getString(2);
				String ngayTL = rs.getString(3);
				String soLuongSach = rs.getString(4);
				String tongTien = rs.getString(5);
				PhieuThanhLy ptl = new PhieuThanhLy(maPTL, tenNV, ngayTL, soLuongSach, tongTien);
				list.add(ptl);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
