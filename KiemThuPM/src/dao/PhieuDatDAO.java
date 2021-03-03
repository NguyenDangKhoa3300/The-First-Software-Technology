package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.PhieuDat;
import entities.PhieuMuon;

public class PhieuDatDAO {
	public PhieuDatDAO() {
		
	}
	public ArrayList<PhieuDat> doctubangPhieuDat() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuDat> dsPD = new ArrayList<PhieuDat>();
		String sql = "select PD.MaPD, NV.TenNV, PD.NgayNhap, SUM(CTPD.Soluong) as \"Số Lượng Sách\" , SUM(CTPD.DonGia * CTPD.Soluong) as \"Tổng Tiền\"\r\n"
				+ "from PhieuDat PD, NhanVien NV, ChiTietPhieuDat CTPD\r\n"
				+ "where PD.MaPD = CTPD.MaPD AND NV.MaNV = PD.MaNV\r\n"
				+ "group by PD.MaPD, NV.TenNV, PD.NgayNhap";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPD = rs.getString(1);
				String tenNV = rs.getString(2);
				String ngayDat = rs.getString(3);
				String soLuongSach = rs.getString(4);
				String tongTien = rs.getString(5);
				PhieuDat pd = new PhieuDat(maPD, tenNV, ngayDat, soLuongSach, tongTien);
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
		String sql = "select PD.MaPD, NV.TenNV, PD.NgayNhap, SUM(CTPD.Soluong) as \"Số Lượng Sách\" , SUM(CTPD.DonGia * CTPD.Soluong) as \"Tổng Tiền\"\r\n"
				+ "from PhieuDat PD, NhanVien NV, ChiTietPhieuDat CTPD\r\n"
				+ "where PD.MaPD = ? AND PD.MaPD = CTPD.MaPD AND NV.MaNV = PD.MaNV\r\n"
				+ "group by PD.MaPD, NV.TenNV, PD.NgayNhap";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPD = rs.getString(1);
				String tenNV = rs.getString(2);
				String ngayDat = rs.getString(3);
				String soLuongSach = rs.getString(4);
				String tongTien = rs.getString(5);
				PhieuDat pd = new PhieuDat(maPD, tenNV, ngayDat, soLuongSach, tongTien);
				list.add(pd);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
