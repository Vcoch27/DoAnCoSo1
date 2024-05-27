package Model;

import java.io.Serializable;

public class ElementDanhPhapHoaHoc implements Serializable {
	private String idDanhPhap;
	private String danhPhapCu;
	private String kiHieu;
	private byte[] audioUS;
	private byte[] audioUK;
	private String ipaUS;
	private String ipaUK;

	public String getKiHieu() {
		return kiHieu;
	}

	public void setKiHieu(String kiHieu) {
		this.kiHieu = kiHieu;
	}

	public ElementDanhPhapHoaHoc(String idDanhPhap, String danhPhapCu, String kiHieu, byte[] audioUS, byte[] audioUK,
			String ipaUS, String ipaUK) {
		this.idDanhPhap = idDanhPhap;
		this.danhPhapCu = danhPhapCu;
		this.kiHieu = kiHieu;
		this.audioUS = audioUS;
		this.audioUK = audioUK;
		this.ipaUS = ipaUS;
		this.ipaUK = ipaUK;
	}

	public String getIdDanhPhap() {
		return idDanhPhap;
	}

	public void setIdDanhPhap(String idDanhPhap) {
		this.idDanhPhap = idDanhPhap;
	}

	public String getDanhPhapCu() {
		return danhPhapCu;
	}

	@Override
	public String toString() {
		return "ElementDanhPhapHoaHoc [idDanhPhap=" + idDanhPhap + ", danhPhapCu=" + danhPhapCu + ", ipaUS=" + ipaUS
				+ ", ipaUK=" + ipaUK + "]";
	}

	public void setDanhPhapCu(String danhPhapCu) {
		this.danhPhapCu = danhPhapCu;
	}

	public byte[] getAudioUS() {
		return audioUS;
	}

	public void setAudioUS(byte[] audioUS) {
		this.audioUS = audioUS;
	}

	public byte[] getAudioUK() {
		return audioUK;
	}

	public void setAudioUK(byte[] audioUK) {
		this.audioUK = audioUK;
	}

	public String getIpaUS() {
		return ipaUS;
	}

	public void setIpaUS(String ipaUS) {
		this.ipaUS = ipaUS;
	}

	public String getIpaUK() {
		return ipaUK;
	}

	public void setIpaUK(String ipaUK) {
		this.ipaUK = ipaUK;
	}
}
