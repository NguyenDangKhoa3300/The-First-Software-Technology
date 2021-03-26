package entities;

public class PhieuMuon {
	private String maPM, maDG, tenDG, ngayMuon, ngayTra, soSachMuon;

	public String getMaPM() {
		return maPM;
	}

	public void setMaPM(String maPM) {
		this.maPM = maPM;
	}

	public String getMaDG() {
		return maDG;
	}

	public void setMaDG(String maDG) {
		this.maDG = maDG;
	}

	public String getTenDG() {
		return tenDG;
	}

	public void setTenDG(String tenDG) {
		this.tenDG = tenDG;
	}

	public String getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(String ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getSoSachMuon() {
		return soSachMuon;
	}

	public void setSoSachMuon(String soSachMuon) {
		this.soSachMuon = soSachMuon;
	}

	public PhieuMuon(String maPM, String maDG, String tenDG, String ngayMuon, String ngayTra, String soSachMuon) {
		super();
		this.maPM = maPM;
		this.maDG = maDG;
		this.tenDG = tenDG;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.soSachMuon = soSachMuon;
	}

	public PhieuMuon() {
		super();
	}

	@Override
	public String toString() {
		return "PhieuMuon [maPM=" + maPM + ", maDG=" + maDG + ", tenDG=" + tenDG + ", ngayMuon=" + ngayMuon
				+ ", ngayTra=" + ngayTra + ", soSachMuon=" + soSachMuon + "]";
	}
}
