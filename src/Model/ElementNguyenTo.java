package Model;

import java.io.Serializable;

public class ElementNguyenTo  implements Serializable{
	private int soHieuNT;
	private String dang;
	private double nguyenTuKhoi;
	private double matDo;
	private double nhietDoNongChay;
	private double nhietDoSoi;
	private double nhietLuongNongChay;
	public double getNhietDoSoi() {
		return nhietDoSoi;
	}
	public void setNhietDoSoi(double nhietDoSoi) {
		this.nhietDoSoi = nhietDoSoi;
	}
	public double getNhietLuongNongChay() {
		return nhietLuongNongChay;
	}
	public void setNhietLuongNongChay(double nhietLuongNongChay) {
		this.nhietLuongNongChay = nhietLuongNongChay;
	}
	private double nhietBayHoi;
	private double nhietDung;	
	private String moTa;
	private byte[] hinhMinhHoa;
	private ElementDanhPhapHoaHoc hoaHoc;
	public ElementDanhPhapHoaHoc getHoaHoc() {
		return hoaHoc;
	}
	public void setHoaHoc(ElementDanhPhapHoaHoc hoaHoc) {
		this.hoaHoc = hoaHoc;
	}
	public int getSoHieuNT() {
		return soHieuNT;
	}
	public void setSoHieuNT(int soHieuNT) {
		this.soHieuNT = soHieuNT;
	}
	public String getDang() {
		return dang;
	}
	public void setDang(String dang) {
		this.dang = dang;
	}
	public double getNguyenTuKhoi() {
		return nguyenTuKhoi;
	}
	@Override
	public String toString() {
		return "ElementNguyenTo [soHieuNT=" + soHieuNT + ", dang=" + dang + ", nguyenTuKhoi=" + nguyenTuKhoi
				+ ", matDo=" + matDo + ", nhietDoNongChay=" + nhietDoNongChay + ", nhietBayHoi=" + nhietBayHoi
				+ ", nhietDung=" + nhietDung + ", moTa=" + moTa + ", hoaHoc=" + hoaHoc.toString() + "]";
	}
	public void setNguyenTuKhoi(double nguyenTuKhoi) {
		this.nguyenTuKhoi = nguyenTuKhoi;
	}
	public double getMatDo() {
		return matDo;
	}
	public void setMatDo(double matDo) {
		this.matDo = matDo;
	}
	public double getNhietDoNongChay() {
		return nhietDoNongChay;
	}
	public void setNhietDoNongChay(double nhietDoNongChay) {
		this.nhietDoNongChay = nhietDoNongChay;
	}
	public double getNhietBayHoi() {
		return nhietBayHoi;
	}
	public void setNhietBayHoi(double nhietBayHoi) {
		this.nhietBayHoi = nhietBayHoi;
	}
	public double getNhietDung() {
		return nhietDung;
	}
	public void setNhietDung(double nhietDung) {
		this.nhietDung = nhietDung;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public byte[] getHinhMinhHoa() {
		return hinhMinhHoa;
	}
	public void setHinhMinhHoa(byte[] hinhMinhHoa) {
		this.hinhMinhHoa = hinhMinhHoa;
	}
	public ElementNguyenTo(int soHieuNT, String dang, double nguyenTuKhoi, double matDo, double nhietDoNongChay,
			double nhietDoSoi, double nhietLuongNongChay, double nhietBayHoi, double nhietDung, String moTa,
			byte[] hinhMinhHoa, ElementDanhPhapHoaHoc hoaHoc) {
		this.soHieuNT = soHieuNT;
		this.dang = dang;
		this.nguyenTuKhoi = nguyenTuKhoi;
		this.matDo = matDo;
		this.nhietDoNongChay = nhietDoNongChay;
		this.nhietDoSoi = nhietDoSoi;
		this.nhietLuongNongChay = nhietLuongNongChay;
		this.nhietBayHoi = nhietBayHoi;
		this.nhietDung = nhietDung;
		this.moTa = moTa;
		this.hinhMinhHoa = hinhMinhHoa;
		this.hoaHoc = hoaHoc;
	}
	
	
	
	
}
