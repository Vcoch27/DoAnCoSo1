package GUI.ForTraCuuDanhPhap.KhungHienThiTCDP;

import javax.swing.JPanel;
import GUI.ForTraCuuDanhPhap.MucDanhPhapHienThi.PaneMenuLuaChonMucDanhPhap;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class PaneTraCuuDanhPhap extends JPanel {
	public PaneMenuLuaChonMucDanhPhap menuDP;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 */
	public PaneTraCuuDanhPhap() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		setBackground(new Color(64, 0, 128));
		setLayout(null);
		setBounds(0, 0, 1285, 635);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1285, 49);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("TRA C\u1EE8U DANH PH\u00C1P H\u00D3A H\u1ECCC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(471, -3, 343, 51);
		panel.add(lblNewLabel);

		BufferedImage myIconBack = ImageIO.read(new File("asset//img//back.png"));
		Image imgIconBack = myIconBack.getScaledInstance(40, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesBack = new ImageIcon(imgIconBack);
		JLabel lbBack = new JLabel(scalesBack);
		lbBack.setVisible(false);

		JPanel paneMainTraCuu = new JPanel();
		paneMainTraCuu.setBounds(0, 57, 1285, 578);
		paneMainTraCuu.setLayout(null);

		menuDP = new PaneMenuLuaChonMucDanhPhap();
//		PanelChiTietMucDanhPhap menuDP = new PanelChiTietMucDanhPhap();
		menuDP.setBounds(0, 0, 1285, 578);
		paneMainTraCuu.add(menuDP);

//		PanelBangTuanHoan menuDP = new PanelBangTuanHoan();
//		menuDP.setBounds(0, 0, 1285, 578);
//		paneMainTraCuu.add(menuDP);
		add(paneMainTraCuu);
	}

	public JPanel getSwitch() {
		return menuDP.getSwitch();
	}
}
