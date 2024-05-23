
package GUI.ForBangTuanHoan.KhungHienThiBangTuanHoan;

public class ONguyenTo {
	private int soHieu;
	private String kiHieu;
	private String tenNguyenTo;
	private int khoiLuongNguyenTo;
	public int getSoHieu() {
		return soHieu;
	}
	public void setSoHieu(int soHieu) {
		this.soHieu = soHieu;
	}
	public String getKiHieu() {
		return kiHieu;
	}
	public void setKiHieu(String kiHieu) {
		this.kiHieu = kiHieu;
	}
	public String getTenNguyenTo() {
		return tenNguyenTo;
	}
	public void setTenNguyenTo(String tenNguyenTo) {
		this.tenNguyenTo = tenNguyenTo;
	}
	public int getKhoiLuongNguyenTo() {
		return khoiLuongNguyenTo;
	}
	public void setKhoiLuongNguyenTo(int khoiLuongNguyenTo) {
		this.khoiLuongNguyenTo = khoiLuongNguyenTo;
	}
	public ONguyenTo(int soHieu, String kiHieu, String tenNguyenTo, int khoiLuongNguyenTo) {
		this.soHieu = soHieu;
		this.kiHieu = kiHieu;
		this.tenNguyenTo = tenNguyenTo;
		this.khoiLuongNguyenTo = khoiLuongNguyenTo;
	}
	
}
