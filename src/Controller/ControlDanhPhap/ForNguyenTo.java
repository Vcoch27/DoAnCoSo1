package Controller.ControlDanhPhap;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Controller.Database.Connection.ConnectJDBC;
import Model.ElementDanhPhapHoaHoc;
import Model.ElementNguyenTo;

public class ForNguyenTo {
	public static void playAudio(byte[] audioBytes) {
		try {
			File tempFile = File.createTempFile("audio", ".wav");
			try (FileOutputStream fos = new FileOutputStream(tempFile)) {
				fos.write(audioBytes);
			}

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(tempFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			while (!clip.isRunning())
				Thread.sleep(10);
			while (clip.isRunning())
				Thread.sleep(10);
			clip.close();
			tempFile.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ElementNguyenTo getNguyenTo(int sohieuNT) {
		ElementNguyenTo rs = null;

		try (Connection con = ConnectJDBC.getConnection();
				PreparedStatement pre = con.prepareStatement("SELECT " + "    e.IDDanhPhap, " + "    e.sohieunguyentu, "
						+ "    dp.DanhPhapCu, " + "    dp.IPAUS, " + "    dp.AudioUS, " + "    dp.IPAUK, "
						+ "    dp.AudioUK, " + "    dp.KiHieuHoaHoc, " + "    e.dang, "
						+ "    e.nguyentukhoi, " + "    e.matdo, " + "    e.nhietdonongchay, " + "    e.nhietdosoi, "
						+ "    e.nhietluongnongchay, " + "    e.nhietbayhoi, " + "    e.nhietdung, " + "    e.mota, "
						+ "    e.hinhminhhoa " + "FROM " + "    easychemistry.element e " + "JOIN "
						+ "    easychemistry.danhphap dp ON e.IDDanhPhap = dp.IDDanhPhap " + "WHERE "
						+ "    e.sohieunguyentu = ?")) {

			// Set the parameter for the prepared statement
			pre.setInt(1, sohieuNT);

			// Execute the query
			try (ResultSet resultSet = pre.executeQuery()) {
				// Check if the result set has at least one row
				if (resultSet.next()) {
					// Retrieve data from the result set
					int soHieuNT = resultSet.getInt("sohieunguyentu");
					String dang = resultSet.getString("dang");
					double nguyenTuKhoi = resultSet.getDouble("nguyentukhoi");
					double matDo = resultSet.getDouble("matdo");
					double nhietDoNongChay = resultSet.getDouble("nhietdonongchay");
					double nhietBayHoi = resultSet.getDouble("nhietbayhoi");
					double nhietDung = resultSet.getDouble("nhietdung");
					String moTa = resultSet.getString("mota");
					byte[] hinhMinhHoa = resultSet.getBytes("hinhminhhoa");
					String nhietDoSoi = resultSet.getString("nhietdosoi");
					double nhietLuongNongChay = resultSet.getDouble("nhietluongnongchay");

					String idDanhPhap = resultSet.getString("IDDanhPhap");
					String danhPhapCu = resultSet.getString("DanhPhapCu");
					byte[] audioUS = resultSet.getBytes("AudioUS");
					byte[] audioUK = resultSet.getBytes("AudioUK");
					String ipaUS = resultSet.getString("IPAUS");
					String ipaUK = resultSet.getString("IPAUK");
					String kiHieu = resultSet.getString("KiHieuHoaHoc");
					// Create an instance of ElementNguyenTo with retrieved data
					rs = new ElementNguyenTo(soHieuNT, dang, nguyenTuKhoi, matDo, nhietDoNongChay, nhietDoNongChay,
							nhietLuongNongChay, nhietBayHoi, nhietDung, moTa, hinhMinhHoa,
							new ElementDanhPhapHoaHoc(idDanhPhap, danhPhapCu, kiHieu, audioUS, audioUK, ipaUS, ipaUK));
					System.out.println(rs.toString());
				}
			}
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

		return rs;
	}
//    public static void main(String[] args) {
//    	ForNguyenTo.getNguyenTo(1);
//	}
}
