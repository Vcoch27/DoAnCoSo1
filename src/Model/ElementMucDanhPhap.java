package Model;

public class ElementMucDanhPhap {
	private String idMucDanhPhap;
	private String mota;
	private String link;
	private byte[] img;
	public String getIdMucDanhPhap() {
		return idMucDanhPhap;
	}
	public void setIdMucDanhPhap(String idMucDanhPhap) {
		this.idMucDanhPhap = idMucDanhPhap;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public ElementMucDanhPhap(String idMucDanhPhap, String mota, String link, byte[] img) {
		this.idMucDanhPhap = idMucDanhPhap;
		this.mota = mota;
		this.link = link;
		this.img = img;
	}
	
}
