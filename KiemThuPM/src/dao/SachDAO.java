package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Sach;

public class SachDAO {
	public SachDAO() {

	}
	public ArrayList<Sach> doctubangSach() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		String sql = "SELECT [MaSach]\r\n"
				+ "      ,[TenSach]\r\n"
				+ "      ,[TheLoai]\r\n"
				+ "      ,[NamXB]\r\n"
				+ "      ,[TenNXB]\r\n"
				+ "      ,[Tinhtrangsach]\r\n"
				+ "  FROM Sach, NhaXuatBan\r\n"
				+ "  WHERE Sach.MaNXB = NhaXuatBan.MaNXB";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString(1);
				String tenSach = rs.getString(2);
				String theLoai = rs.getString(3);
				String namXB = rs.getString(4);
				String tenNXB = rs.getString(5);
				String tinhTrangSach = rs.getString(6);
				Sach s = new Sach(maSach, tenSach, theLoai, namXB, tenNXB, tinhTrangSach);
				dsSach.add(s);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSach;
	}

	public ArrayList<Sach> TimSachBangMa(String ma) {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<Sach> list = new ArrayList<>();
		String sql = "SELECT [MaSach]\r\n"
				+ "      ,[TenSach]\r\n"
				+ "      ,[TheLoai]\r\n"
				+ "      ,[NamXB]\r\n"
				+ "      ,[TenNXB]\r\n"
				+ "      ,[Tinhtrangsach]\r\n"
				+ "  FROM Sach, NhaXuatBan\r\n"
				+ "  WHERE Sach.MaSach = ? AND Sach.MaNXB = NhaXuatBan.MaNXB";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString(1);
				String tenSach = rs.getString(2);
				String theLoai = rs.getString(3);
				String namXB = rs.getString(4);
				String tenNXB = rs.getString(5);
				String tinhTrangSach = rs.getString(6);
				Sach s = new Sach(maSach, tenSach, theLoai, namXB, tenNXB, tinhTrangSach);
				list.add(s);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
