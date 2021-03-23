package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.ChitietPhieuThanhLy;

public class CTPhieuThanhLyDAO {
	public ArrayList<ChitietPhieuThanhLy> doctubangPhieuDat(String mapPTL) {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<ChitietPhieuThanhLy> dsCTPTL = new ArrayList<ChitietPhieuThanhLy>();
		String sql = "select ctptl.maPTL , s.TenSach , ctptl.dongia , ctptl.maCTPTL  from ChiTietPhieuThanhLy ctptl, sach s where MaPTL = '"
				+ mapPTL + "' and ctptl.MaSach = s.MaSach";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maPTL = rs.getString(1);
				String tenSach = rs.getString(2);
				String donGia = rs.getString(3);
				String maCTPTL = rs.getString(4);
				ChitietPhieuThanhLy ctptl = new ChitietPhieuThanhLy(maPTL, tenSach, donGia, maCTPTL);
				dsCTPTL.add(ctptl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCTPTL;
	}

	public String getLastMaCTPTL() {
		String tienTo = "maCTPTL_";
		String toanMa = "";
		String maCTPTL = "";
		int max = 1;
		int hauTo;
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Select maCTPTL from ChitietPhieuThanhLy";

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

		maCTPTL = tienTo + max;

		return maCTPTL;
	}

	public void themPhieuThanhLy(String maPTL, String maSach, String donGia) {

		String maCTPTL = getLastMaCTPTL();

		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "insert into ChiTietPhieuThanhLy values ('" + maPTL + "','" + maSach + "'," + donGia + ",'"
					+ maCTPTL + "');";

			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Added");

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void xoaCTPTL(String maCTPTL) {

		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "delete from ChiTietPhieuThanhLy where MACTPTL = '" + maCTPTL + "'";

			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public String getMaSach(String tenSach) {		
		String maSach = "";
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Select maSach from sach where tensach = N'"+tenSach+"'";
			
			PreparedStatement ps = con.prepareStatement(querry);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				maSach = rs.getString(1);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maSach;
	}

}
