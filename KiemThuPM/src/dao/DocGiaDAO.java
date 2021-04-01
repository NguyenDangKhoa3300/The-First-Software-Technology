package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.DocGia;

public class DocGiaDAO {
	// ArrayList<DocGia> dsMHP = new ArrayList<DocGia>();
	public DocGiaDAO() {

	}

	public ArrayList<DocGia> doctubang() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<DocGia> dsDG = new ArrayList<DocGia>();
		String sql = "select * from DocGia";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
			while (rs.next()) {
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

	public void themDG(String hoTen, String namSinh, String soCMND, String soDT) {

		String maDG = getLastMaDG();

		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Insert into DocGia values('" + maDG + "','" + hoTen + "','" + namSinh + "'," + soCMND + ","
					+ soDT + ");";

			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Added");

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getLastMaDG() {
		String tienTo = "maDG_";
		String toanMa = "";
		String maDG = "";
		int max = 1;
		int hauTo;
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Select maSV from DocGia";

			PreparedStatement ps = con.prepareStatement(querry);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				toanMa = rs.getString(1);
				String[] part = toanMa.split("_");
				hauTo = Integer.parseInt(part[1].trim());
				if (max < hauTo) {
					max = hauTo;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		max++;

		maDG = tienTo + max;

		return maDG;
	}

	public void xoaDG(String maDG) {

		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "delete from DocGia where maSV = '" + maDG + "'";

			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
