package Controller.ControlDanhPhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Controller.Database.Connection.ConnectJDBC;
import GUI.ElementPublic.ElementDanhPhap;
import Model.ElementDanhPhapHoaHoc;
import Model.ElementMucDanhPhap;

public class ControllerMucDanhPhap {
	public static ElementMucDanhPhap getMucDanhPhap(String nhomid) {

		ElementMucDanhPhap e = null;
		try (Connection con = ConnectJDBC.getConnection();
				PreparedStatement pre = con.prepareStatement(
						"SELECT nhomid, img, mota, link from easychemistry.nhomdanhphap where nhomid=?")) {
			pre.setString(1, nhomid);
			try (ResultSet r = pre.executeQuery()) {
				if (r.next()) {
					String id = r.getString("nhomid");
					byte[] img = r.getBytes("img");
					String mota = r.getString("mota");
					String link = r.getString("link");
					e = new ElementMucDanhPhap(id, mota, link, img);
				}
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return e;
	}

	public static ArrayList<ElementDanhPhapHoaHoc> getListDanhPhap(String nhomid) {
		ArrayList<ElementDanhPhapHoaHoc> list = new ArrayList<ElementDanhPhapHoaHoc>();
		try (Connection con = ConnectJDBC.getConnection();
				PreparedStatement pre = con.prepareStatement(
						"SELECT IDDanhPhap, DanhPhapCu, IPAUS, AudioUS, IPAUK, AudioUK, KiHieuHoaHoc from easychemistry.danhphap where nhomid=?")) {
			pre.setString(1, nhomid);
			try (ResultSet r = pre.executeQuery()) {
				while(r.next()) {
					String idDanhPhap = r.getString("IDDanhPhap");
					String danhPhapCu = r.getString("DanhPhapCu");
					String ipaUS = r.getString("IPAUS");
					byte[] audioUS = r.getBytes("AudioUS");
					String ipaUK = r.getString("IPAUK");
					byte[] audioUK = r.getBytes("AudioUK");
					String kiHieu = r.getString("KiHieuHoaHoc");

					ElementDanhPhapHoaHoc element = new ElementDanhPhapHoaHoc(idDanhPhap, danhPhapCu, kiHieu, audioUS,
							audioUK, ipaUS, ipaUK);

					list.add(element);
					
				}
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return list;
	}
}
