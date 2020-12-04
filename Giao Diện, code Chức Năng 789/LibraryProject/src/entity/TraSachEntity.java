package entity;

public class TraSachEntity {
	String idPM, idSach, tenSach, solangiahan, tienphat, sotientralai, tinhtrangsach;

	public String getIdPM() {
		return idPM;
	}

	public void setIdPM(String idPM) {
		this.idPM = idPM;
	}

	public String getIdSach() {
		return idSach;
	}

	public void setIdSach(String idSach) {
		this.idSach = idSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getSolangiahan() {
		return solangiahan;
	}

	public void setSolangiahan(String solangiahan) {
		this.solangiahan = solangiahan;
	}

	public String getTienphat() {
		return tienphat;
	}

	public void setTienphat(String tienphat) {
		this.tienphat = tienphat;
	}

	public String getSotientralai() {
		return sotientralai;
	}

	public void setSotientralai(String sotientralai) {
		this.sotientralai = sotientralai;
	}

	public String getTinhtrangsach() {
		return tinhtrangsach;
	}

	public void setTinhtrangsach(String tinhtrangsach) {
		this.tinhtrangsach = tinhtrangsach;
	}

	public TraSachEntity(String idPM, String idSach, String tenSach, String solangiahan, String tienphat,
			String sotientralai, String tinhtrangsach) {
		super();
		this.idPM = idPM;
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.solangiahan = solangiahan;
		this.tienphat = tienphat;
		this.sotientralai = sotientralai;
		this.tinhtrangsach = tinhtrangsach;
	}

	public TraSachEntity() {
		super();
	}

	@Override
	public String toString() {
		return "TraSachEntity [idPM=" + idPM + ", idSach=" + idSach + ", tenSach=" + tenSach + ", solangiahan="
				+ solangiahan + ", tienphat=" + tienphat + ", sotientralai=" + sotientralai + ", tinhtrangsach="
				+ tinhtrangsach + "]";
	}
	
}
