package entities;

public class PhieuThanhLy {
	private String maPTL, tenNV, ngayTL, soLuongSach, tongTien;

	public String getMaPTL() {
		return maPTL;
	}

	public void setMaPTL(String maPTL) {
		this.maPTL = maPTL;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getNgayTL() {
		return ngayTL;
	}

	public void setNgayTL(String ngayTL) {
		this.ngayTL = ngayTL;
	}

	public String getSoLuongSach() {
		return soLuongSach;
	}

	public void setSoLuongSach(String soLuongSach) {
		this.soLuongSach = soLuongSach;
	}

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "PhieuThanhLy [maPTL=" + maPTL + ", tenNV=" + tenNV + ", ngayTL=" + ngayTL + ", soLuongSach="
				+ soLuongSach + ", tongTien=" + tongTien + "]";
	}

	public PhieuThanhLy(String maPTL, String tenNV, String ngayTL, String soLuongSach, String tongTien) {
		super();
		this.maPTL = maPTL;
		this.tenNV = tenNV;
		this.ngayTL = ngayTL;
		this.soLuongSach = soLuongSach;
		this.tongTien = tongTien;
	}

	public PhieuThanhLy() {
		super();
	}
	
}
