package GUI.ForBangTuanHoan.KhungHienThiBangTuanHoan;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DoiTuong.ForGUI.ONguyenTo;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelBangTuanHoan extends JPanel {
	private final int ROWS = 7;
	private final int COLS = 18;
	private FrameHienThiChiTietNguyenTo chiTietNT;
	
	int soHieuNT = 1;
	String bg;
	Color bgPanel;
	

	public PanelBangTuanHoan() throws IOException {
		setBounds(0, 0, 1285, 635);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("IA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(45, 0, 28, 14);
		add(lblNewLabel);

		JLabel lblIia = new JLabel("IIA");
		lblIia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia.setBounds(113, 67, 28, 14);
		add(lblIia);

		JLabel lblIiia = new JLabel("IIIA");
		lblIiia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIiia.setBounds(885, 67, 40, 14);
		add(lblIiia);

		JLabel lblIia_1_1 = new JLabel("IVA");
		lblIia_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1.setBounds(956, 67, 28, 14);
		add(lblIia_1_1);

		JLabel lblIia_1_1_1 = new JLabel("VA");
		lblIia_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1.setBounds(1025, 67, 28, 14);
		add(lblIia_1_1_1);

		JLabel lblIia_1_1_1_1 = new JLabel("VIA");
		lblIia_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1_1.setBounds(1096, 67, 28, 14);
		add(lblIia_1_1_1_1);

		JLabel lblIia_1_1_1_1_1 = new JLabel("VIIA");
		lblIia_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1_1_1.setBounds(1162, 67, 40, 14);
		add(lblIia_1_1_1_1_1);

		JLabel lblIia_1_1_1_1_1_1 = new JLabel("VIIIA");
		lblIia_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1_1_1_1.setBounds(1224, 0, 54, 14);
		add(lblIia_1_1_1_1_1_1);

		JLabel lblIiib = new JLabel("IIIB");
		lblIiib.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIiib.setBounds(181, 202, 40, 14);
		add(lblIiib);

		JLabel lblIia_1_1_2 = new JLabel("IVB");
		lblIia_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_2.setBounds(255, 202, 28, 14);
		add(lblIia_1_1_2);

		JLabel lblIia_1_1_1_2 = new JLabel("VB");
		lblIia_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1_2.setBounds(327, 202, 28, 14);
		add(lblIia_1_1_1_2);

		JLabel lblIia_1_1_1_1_2 = new JLabel("VIB");
		lblIia_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1_1_2.setBounds(394, 202, 28, 14);
		add(lblIia_1_1_1_1_2);

		JLabel lblIia_1_1_1_1_1_2 = new JLabel("VIIB");
		lblIia_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1_1_1_2.setBounds(465, 202, 40, 14);
		add(lblIia_1_1_1_1_1_2);

		JLabel lblIia_1_1_1_1_1_1_1 = new JLabel("------------VIIIB--------------");
		lblIia_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1_1_1_1_1_1_1.setBounds(521, 202, 221, 14);
		add(lblIia_1_1_1_1_1_1_1);

		JLabel lblIb = new JLabel("IB");
		lblIb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIb.setBounds(745, 202, 28, 14);
		add(lblIb);

		JLabel lblIia_1 = new JLabel("IIA");
		lblIia_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIia_1.setBounds(809, 202, 28, 14);
		add(lblIia_1);

		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(5, 38, 22, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("2");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(5, 115, 28, 14);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("3");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(5, 184, 28, 14);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("4");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(5, 254, 28, 14);
		add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("5");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(5, 328, 28, 14);
		add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("6");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(5, 391, 28, 14);
		add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("7");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(5, 456, 22, 14);
		add(lblNewLabel_1_6);

		JLabel lblHLantan = new JLabel("Họ Lantan");
		lblHLantan.setFont(new Font("Arial", Font.BOLD, 15));
		lblHLantan.setBounds(76, 528, 87, 14);
		add(lblHLantan);

		JLabel lblHActini = new JLabel("Họ Actini");
		lblHActini.setFont(new Font("Arial", Font.BOLD, 15));
		lblHActini.setBounds(76, 593, 79, 14);
		add(lblHActini);

		JLabel lblNewLabel_2 = new JLabel("BẢNG TUẦN HOÀN HÓA HỌC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(504, 0, 294, 42);
		add(lblNewLabel_2);

		BufferedImage chuThich2 = ImageIO.read(new File("asset//img//chuThichBTH3.png"));
		Image imgChuThich2 = chuThich2.getScaledInstance(383, 153, Image.SCALE_SMOOTH);
		ImageIcon scalehuThich2 = new ImageIcon(imgChuThich2);
		JLabel lblNewLabel_3 = new JLabel(scalehuThich2);
		lblNewLabel_3.setBounds(418, 38, 383, 153);
		add(lblNewLabel_3);

		BufferedImage chuThich1 = ImageIO.read(new File("asset//img//chuThichBTH2.png"));
		Image imgChuThich1 = chuThich1.getScaledInstance(215, 153, Image.SCALE_SMOOTH);
		ImageIcon scalehuThich1 = new ImageIcon(imgChuThich1);
		JLabel lblNewLabel_4 = new JLabel(scalehuThich1);
		lblNewLabel_4.setBounds(193, 38, 215, 153);
		add(lblNewLabel_4);
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (row == 0 && (col >= 1 && col <= 16)) {
					continue;
				}
				if ((row == 1 || row == 2) && (col >= 2 && col <= 11)) {
					continue;
				}

				JPanel oNT = new JPanel();
				JEditorPane content = new JEditorPane();
				content.setContentType("text/html");
				if (soHieuNT == 57 || soHieuNT == 89) {
					if (soHieuNT == 57) {
						soHieuNT = 72;
					} else if (soHieuNT == 89) {
						soHieuNT = 104;
					}
					bgPanel = new Color(60, 179, 113);
					oNT.setBackground(bgPanel);
					content.setBackground(bgPanel);
					content.setText(
							"<html><body> <p style=\"font-size: 15px;line-height: 15px; margin: 0;padding: 0;\">"
									+ (soHieuNT - 15) + "-" + (soHieuNT - 1) + "</p></body></html>");
					oNT.putClientProperty("soHieu", 0);
				} else {
					if (col == 17) {
						bgPanel = new Color(255, 79, 47);
					} else if (row == 0 || (row == 1 && col > 10 && col < 17) || (row == 2 && col > 11 && col < 17)
							|| (row == 3 && col > 12 && col < 17) || (row == 4 && col > 13 && col < 17)
							|| (row == 5 && col > 14 && col < 17)) {

						bgPanel = new Color(233, 172, 236);
					} else {
						bgPanel = new Color(60, 179, 113);

					}
					content.setText(
							"<html><body> <p style=\"font-size: 10px;line-height: 10px; margin: 0;padding: 0;\">"
									+ soHieuNT
									+ "</p><p style=\"font-size: 10px;line-height: 10px;margin: 0;padding: 0;\"><b>H</b></p><p style=\"font-size: 10px;line-height: 10px;margin: 0;padding: 0;\">Hidro</p>\r\n"
									+ "</body></html>");
					oNT.setBackground(bgPanel);
					content.setBackground(bgPanel);
					oNT.putClientProperty("soHieu", soHieuNT);
					soHieuNT++;
				}

				oNT.add(content);

				oNT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				oNT.setBounds(22 + col * 70, 15 + row * 68, 70, 68);
				content.setEditable(false);
				content.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int soHieu = (int) oNT.getClientProperty("soHieu");
						try {
							chiTietNT = new FrameHienThiChiTietNguyenTo(soHieu);
							chiTietNT.setVisible(true);
							chiTietNT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


						} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				add(oNT);
			}
		}
		soHieuNT = 57;
		bgPanel = new Color(60, 179, 113);
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 15; col++) {
				JPanel oNT = new JPanel();
				JEditorPane content = new JEditorPane();
				content.setContentType("text/html");
				content.setText("<html><body> <p style=\"font-size: 10px;line-height: 10px; margin: 0;padding: 0;\">"
						+ soHieuNT
						+ "</p><p style=\"font-size: 10px;line-height: 10px;margin: 0;padding: 0;\"><b>H</b></p><p style=\"font-size: 10px;line-height: 10px;margin: 0;padding: 0;\">Hidro</p>\r\n"
						+ "</body></body></html>");
				content.setBackground(bgPanel);
				oNT.setBackground(bgPanel);
				oNT.add(content);
				oNT.putClientProperty("soHieu", soHieuNT);
				if (soHieuNT != 71) {
					soHieuNT++;
				} else {
					soHieuNT = 89;
				}
				oNT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				oNT.setBounds(162 + col * 70, 497 + row * 68, 70, 68);
				content.setEditable(false);
				content.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int soHieu = (int) oNT.getClientProperty("soHieu");
						try {
							chiTietNT = new FrameHienThiChiTietNguyenTo(soHieu);
							chiTietNT.setVisible(true);
							chiTietNT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


						} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				add(oNT);
			}
		}
	}
}
