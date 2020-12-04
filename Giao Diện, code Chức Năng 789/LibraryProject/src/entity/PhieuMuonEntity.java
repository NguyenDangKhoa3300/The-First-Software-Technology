package entity;

public class PhieuMuonEntity {
	String idPM,idDG,ngaymuon,ngaytra,sotien,soluong;

	public String getIdPM() {
		return idPM;
	}

	public void setIdPM(String idPM) {
		this.idPM = idPM;
	}

	public String getIdDG() {
		return idDG;
	}

	public void setIdDG(String idDG) {
		this.idDG = idDG;
	}

	public String getNgaymuon() {
		return ngaymuon;
	}

	public void setNgaymuon(String ngaymuon) {
		this.ngaymuon = ngaymuon;
	}

	public String getNgaytra() {
		return ngaytra;
	}

	public void setNgaytra(String ngaytra) {
		this.ngaytra = ngaytra;
	}

	public String getSotien() {
		return sotien;
	}

	public void setSotien(String sotien) {
		this.sotien = sotien;
	}

	public String getSoluong() {
		return soluong;
	}

	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}

	public PhieuMuonEntity(String idPM, String idDG, String ngaymuon, String ngaytra, String sotien, String soluong) {
		super();
		this.idPM = idPM;
		this.idDG = idDG;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
		this.sotien = sotien;
		this.soluong = soluong;
	}

	public PhieuMuonEntity() {
		super();
	}

	@Override
	public String toString() {
		return "PhieuMuonEntity [idPM=" + idPM + ", idDG=" + idDG + ", ngaymuon=" + ngaymuon + ", ngaytra=" + ngaytra
				+ ", sotien=" + sotien + ", soluong=" + soluong + "]";
	}
	
}
