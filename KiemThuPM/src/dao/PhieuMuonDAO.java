package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.DocGia;
import entities.PhieuMuon;
import entities.DocGia_PM;
public class PhieuMuonDAO {
	public PhieuMuonDAO() {
		
	}
	public ArrayList<PhieuMuon> doctubangPhieuMuon() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<PhieuMuon> dsPM = new ArrayList<PhieuMuon>();
		String sql = "select pm.MaPM ,dg.HoTen, nv.TenNV , pm.Ngaymuon, pm.Ngaytra from DocGia dg, PhieuMuon pm, NhanVien nv where dg.MaSV = pm.Madocgia and nv.MaNV = pm.MaNV";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPM = rs.getString(1);
				String tenDG = rs.getString(2);
				String tenNV = rs.getString(3);
				String ngayMuon = rs.getString(4);
				String ngayTra = rs.getString(5);
				
				PhieuMuon pm = new PhieuMuon(maPM, tenDG, tenNV, ngayMuon, ngayTra);
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
	public ArrayList<DocGia_PM> doctubangThemPhieuMuon() {
		Connection con = DataBase.getInstance().getConnection();
		ArrayList<DocGia_PM> dsDG = new ArrayList<DocGia_PM>();
		String sql = "select MaSV,HoTen,CMND from DocGia ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDG = rs.getString(1);
				String tenDG = rs.getString(2);
				String cmnd = rs.getString(3);
				
				
				DocGia_PM dg = new DocGia_PM(maDG, tenDG, cmnd);
				dsDG.add(dg);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDG;
	}
	public void themPhieuMuon(String maDG, String ngayMuon,String ngayTra,String tenNV) {
		String maPM = getLastMaPM();
		String manv = getMaNV(tenNV);
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Insert into PhieuMuon values('"+maPM+"','"+maDG+"','"+ngayMuon+"','"+ngayTra+"','"+manv+"'"+");";
			
			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Added");
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
public void suaPhieuMuon(String maPM, String maDG, String ngayMuon, String ngayTra, String tenNV) {
		String manv = getMaNV(tenNV); 
		
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Update PhieuMuon set madocgia = '"+maDG+"',ngaymuon = '"+ngayMuon+"',ngaytra = '" +ngayTra+"',manv = '"+manv+"' where maPM = '"+ maPM+"'";
			
			PreparedStatement ps = con.prepareStatement(querry);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Updated");
			
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Du lieu nhap khong hop le!");
			e.printStackTrace();
		}

	}
	public String getLastMaPM() {
		String tienTo = "PM_";
		String toanMa = "";
		String maPD = "";
		int max = 1;
		int hauTo;
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Select maPM from PhieuMuon";
			
			PreparedStatement ps = con.prepareStatement(querry);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				toanMa = rs.getString(1);
				String[] part = toanMa.split("_");
				hauTo = Integer.parseInt(part[1].trim());
				if(max < hauTo) {
					max = hauTo;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		max++;
		
		maPD = tienTo + max;
		
		return maPD;
	}
public String getMaNV(String tenNV) {
		
		String maNV = "";
		try {
			Connection con = DataBase.getInstance().getConnection();
			String querry = "Select manv from nhanvien where tenNV = N'"+tenNV+"'";
			
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
public String getMaDG(String tenDG) {
	
	String maDG = "";
	try {
		Connection con = DataBase.getInstance().getConnection();
		String querry = "Select maSV from DocGia where HoTen = N'"+tenDG+"';";
		
		PreparedStatement ps = con.prepareStatement(querry);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			maDG = rs.getString(1);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return maDG;
}
public void xoaPM(String maPM) {

	try {
		Connection con = DataBase.getInstance().getConnection();
		String querry2 = "delete from PhieuMuon where maPM = '" + maPM + "'";
		String querry1 = "delete from ChiTietPhieuMuon where maPM = '"+maPM+"'";
		PreparedStatement ps = con.prepareStatement(querry1);

		ps.executeUpdate();
		ps = con.prepareStatement(querry2);

		ps.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
}
