package GUI.ForBangTuanHoan.KhungHienThiBangTuanHoan;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Controller.ControlDanhPhap.ForNguyenTo;
import GUI.ElementPublic.ElementDanhPhap;
import Model.ElementNguyenTo;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class FrameHienThiChiTietNguyenTo extends JFrame {

	private JPanel contentPane;
	private ElementNguyenTo eNT;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameHienThiChiTietNguyenTo frame = new FrameHienThiChiTietNguyenTo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 */
	public FrameHienThiChiTietNguyenTo(int idNT) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		setResizable(false);
		eNT = ForNguyenTo.getNguyenTo(idNT);
		System.out.println(idNT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 819);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 234, 223));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Color bgONT = new Color(213, 115, 115);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		JEditorPane content = new JEditorPane();
		content.setEditable(false);
		content.setBounds(26, 4, 98, 126);
		DecimalFormat decimalFormat = new DecimalFormat("#.########"); 
		content.setContentType("text/html");
		content.setText("<html><body> <p style=\"font-size: 25px;line-height: 10px; margin: 0;padding: 0;\">" + decimalFormat.format(eNT.getSoHieuNT())
				+ "</p><p style=\"font-size: 25px;line-height: 10px;margin: 0;padding: 0;\"><btnDK>"+eNT.getHoaHoc().getKiHieu()+"</btnDK></p><p style=\"font-size: 18px;line-height: 10px;margin: 0;padding: 0;\">"+decimalFormat.format(eNT.getNguyenTuKhoi())+"</p>\r\n"
				+ "</body></html>");
		content.setBackground(new Color(202, 202, 202));
		panel.add(content);
		panel.setBackground(new Color(202, 202, 202));
		panel.setBounds(328, 16, 141, 135);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 64, 128));
		panel_1.setBounds(10, 160, 650, 70);
		ElementDanhPhap dp = new ElementDanhPhap(eNT.getHoaHoc());
		dp.setBounds(0, 0, 650, 70);
		panel_1.add(dp);
		contentPane.add(panel_1);

		// Chuyển đổi mảng byte thành BufferedImage
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(eNT.getHinhMinhHoa()));

        // Tạo một hình ảnh có kích thước mới (ví dụ: 200x200) từ BufferedImage
        Image scaledImage = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        // Tạo một ImageIcon từ hình ảnh đã được chia tỷ lệ
        ImageIcon imageIcon = new ImageIcon(scaledImage);
		JLabel lblNewLabel_1 = new JLabel(imageIcon);
		lblNewLabel_1.setBackground(new Color(0, 255, 64));
		lblNewLabel_1.setBounds(10, 262, 200, 200);
		contentPane.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(252, 222, 167));
		panel_3.setBounds(153, 489, 384, 280);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("<html><body>" + "<table>" + "  <tr>"
				+ "    <th><font size=\"5\">Thuộc tính</font></th>" + "    <th><font size=\"5\">Giá trị</font></th>"
				+ "  </tr>" + "  <tr>" + "    <td><font size=\"4\">Loại</font></td>"
				+ "    <td><font size=\"4\">"+eNT.getDang()+"</font></td>" + "  </tr>" + "  <tr>"
				+ "    <td><font size=\"4\">Mật độ</font></td>"
				+ "    <td><font size=\"4\">"+eNT.getMatDo()+" g/cm<sup>3</sup></font></td>" + "  </tr>" + "  <tr>"
				+ "    <td><font size=\"4\">Nhiệt độ nóng chảy</font></td>"
				+ "    <td><font size=\"4\">"+eNT.getNhietDoNongChay()+"°K | "+kelvinToCelsius(eNT.getNhietDoNongChay())+"°C | "+decimalFormat.format(kelvinToFahrenheit(eNT.getNhietDoNongChay()))+" °F</font></td>" + "  </tr>" + "  <tr>"
				+ "    <td><font size=\"4\">Nhiệt độ sôi</font></td>"
				+ "    <td><font size=\"4\"> "+eNT.getNhietDoSoi()+" °K | "+kelvinToCelsius(eNT.getNhietDoSoi())+" °C | "+decimalFormat.format(kelvinToFahrenheit(eNT.getNhietDoSoi()))+" °F</font></td>" + "  </tr>" + "  <tr>"
				+ "    <td><font size=\"4\">Nhiệt lượng nóng chảy</font></td>"
				+ "    <td><font size=\"4\">"+eNT.getNhietLuongNongChay()+" kJ/mol</font></td>" + "  </tr>" + "  <tr>"
				+ "    <td><font size=\"4\">Nhiệt bay hơi</font></td>"
				+ "    <td><font size=\"4\">"+eNT.getNhietBayHoi()+" kJ/mol</font></td>" + "  </tr>" + "  <tr>"
				+ "    <td><font size=\"4\">Nhiệt dung</font></td>"
				+ "    <td><font size=\"4\">"+eNT.getNhietDung()+" J/g·K</font></td>" + "  </tr>" + "</table>" + "</body></html>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(0, 35, 384, 245);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("THÔNG TIN");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(133, 11, 117, 29);
		panel_3.add(lblNewLabel_4);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(151, 255, 151));
		panel_4.setBounds(13, 49, 305, 73);
		contentPane.add(panel_4);

		JLabel lbNameHoaHoc = new JLabel(eNT.getHoaHoc().getDanhPhapCu());
		panel_4.add(lbNameHoaHoc);
		lbNameHoaHoc.setFont(new Font("Tahoma", Font.PLAIN, 50));

		JLabel lblNewLabel = new JLabel(
				"<html><p style='margin-bottom: 10px;'>Số hiệu nguyên tử</p><p style='margin-bottom: 10px;'>Kí hiệu</p><p>Số khối</p></html>");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));

		lblNewLabel.setBounds(479, 16, 186, 135);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(220, 262, 452, 216);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		textPane.setText(eNT.getMoTa());
	}

	public static double kelvinToCelsius(double kelvin) {
	        if (kelvin < 0) {
	            throw new IllegalArgumentException("Nhiệt độ Kelvin không thể nhỏ hơn 0");
	        }
	        return kelvin - 273.15;
	    }
	public static double kelvinToFahrenheit(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Nhiệt độ Kelvin không thể nhỏ hơn 0");
        }
        return (kelvin - 273.15) * 9/5 + 32;
    }
}
