package entities;

public class PhieuDat {
	private String maPD, tenNV, ngayDat, soLuongSach, tongTien;

	public String getMaPD() {
		return maPD;
	}

	public void setMaPD(String maPD) {
		this.maPD = maPD;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
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
		return "PhieuDat [maPD=" + maPD + ", tenNV=" + tenNV + ", ngayDat=" + ngayDat + ", soLuongSach=" + soLuongSach
				+ ", tongTien=" + tongTien + "]";
	}

	public PhieuDat(String maPD, String tenNV, String ngayDat, String soLuongSach, String tongTien) {
		super();
		this.maPD = maPD;
		this.tenNV = tenNV;
		this.ngayDat = ngayDat;
		this.soLuongSach = soLuongSach;
		this.tongTien = tongTien;
	}

	public PhieuDat() {
		super();
	}
	
}
