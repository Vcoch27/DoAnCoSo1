package GUI.ForTraCuuDanhPhap.MucDanhPhapHienThi;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaneMenuLuaChonMucDanhPhap extends JPanel {
	private Color mauChuDao = new Color(100, 149, 237);
	public JPanel donChat;
	public JPanel akan;
	public JPanel anken;
	public JPanel ankin;
	public JPanel hc;
	public JPanel ancol;
	public JPanel phenol;
	public JPanel andehit;
	public JPanel keton;
	public JPanel ion;
	public JPanel base;
	public JPanel acid;
	public JPanel ca;
	public JPanel salt;
	public JPanel halogen;
	public JPanel ocid;

	/**
	 * Create the panel.
	 */
	public PaneMenuLuaChonMucDanhPhap() {
		setBackground(mauChuDao);
		setBounds(0, 0, 1285, 588);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 215, 254));
		panel.setBounds(153, 0, 979, 605);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("1. V\u00F4 c\u01A1 - Inorganic ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(126, 125, 248, 46);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("2. H\u1EEFu c\u01A1 - Organic  ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2_1.setBounds(126, 319, 248, 46);
		panel.add(lblNewLabel_2_1);

		akan = new JPanel();
		akan.setBorder(UIManager.getBorder("DesktopIcon.border"));
		akan.setBackground(new Color(254, 215, 180));
		akan.setBounds(279, 367, 201, 30);
		panel.add(akan);

		JLabel lbakan = new JLabel("Alkane");
		akan.add(lbakan);
		lbakan.setFont(new Font("Tahoma", Font.PLAIN, 17));

		anken = new JPanel();
		anken.setBorder(UIManager.getBorder("DesktopIcon.border"));
		anken.setBackground(new Color(254, 215, 180));
		anken.setBounds(279, 408, 201, 30);
		panel.add(anken);

		JLabel lblNewLabel_3_1_2 = new JLabel("Alkene");
		anken.add(lblNewLabel_3_1_2);
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));

		ankin = new JPanel();
		ankin.setBorder(UIManager.getBorder("DesktopIcon.border"));
		ankin.setBackground(new Color(254, 215, 180));
		ankin.setBounds(279, 449, 201, 30);
		panel.add(ankin);

		JLabel lblNewLabel_3_2_2 = new JLabel("Alkyne");
		ankin.add(lblNewLabel_3_2_2);
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));

		hc = new JPanel();
		hc.setBorder(UIManager.getBorder("DesktopIcon.border"));
		hc.setBackground(new Color(254, 215, 180));
		hc.setBounds(279, 490, 201, 30);
		panel.add(hc);

		JLabel lbhc = new JLabel("Aromatic hydrocarbon");
		hc.add(lbhc);
		lbhc.setFont(new Font("Tahoma", Font.PLAIN, 17));

		halogen = new JPanel();
		halogen.setBorder(UIManager.getBorder("DesktopIcon.border"));
		halogen.setBackground(new Color(254, 215, 180));
		halogen.setBounds(279, 531, 201, 30);
		panel.add(halogen);

		JLabel lblNewLabel_3_2_2_1 = new JLabel("Halogen derivatives");
		halogen.add(lblNewLabel_3_2_2_1);
		lblNewLabel_3_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		ancol = new JPanel();
		ancol.setBorder(UIManager.getBorder("DesktopIcon.border"));
		ancol.setBackground(new Color(254, 215, 180));
		ancol.setBounds(490, 367, 201, 30);
		panel.add(ancol);

		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("Alcohol");
		ancol.add(lblNewLabel_3_1_1_1_2);
		lblNewLabel_3_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));

		phenol = new JPanel();
		phenol.setBorder(UIManager.getBorder("DesktopIcon.border"));
		phenol.setBackground(new Color(254, 215, 180));
		phenol.setBounds(490, 408, 201, 30);
		panel.add(phenol);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Phenol");
		phenol.add(lblNewLabel_3_1_1_1);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		andehit = new JPanel();
		andehit.setBorder(UIManager.getBorder("DesktopIcon.border"));
		andehit.setBackground(new Color(254, 215, 180));
		andehit.setBounds(490, 449, 201, 30);
		panel.add(andehit);

		JLabel lb = new JLabel("Aldehyde");
		andehit.add(lb);
		lb.setFont(new Font("Tahoma", Font.PLAIN, 17));

		keton = new JPanel();
		keton.setBorder(UIManager.getBorder("DesktopIcon.border"));
		keton.setBackground(new Color(254, 215, 180));
		keton.setBounds(490, 490, 201, 30);
		panel.add(keton);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Ketone");
		keton.add(lblNewLabel_3_1_1_1_1);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		ca = new JPanel();
		ca.setBorder(UIManager.getBorder("DesktopIcon.border"));
		ca.setBackground(new Color(254, 215, 180));
		ca.setBounds(490, 531, 201, 30);
		panel.add(ca);

		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Carboxylic acid");
		ca.add(lblNewLabel_3_2_1_1_1);
		lblNewLabel_3_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		ion = new JPanel();

		ion.setBorder(new LineBorder(Color.GRAY));
		ion.setForeground(new Color(0, 0, 0));
		ion.setBackground(new Color(254, 215, 180));
		ion.setBounds(279, 185, 201, 30);
		panel.add(ion);

		JLabel lblNewLabel_3 = new JLabel("Ion");
		ion.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));

		base = new JPanel();
		base.setBorder(UIManager.getBorder("DesktopIcon.border"));
		base.setForeground(new Color(0, 0, 0));
		base.setBackground(new Color(254, 215, 180));
		base.setBounds(279, 226, 201, 30);
		panel.add(base);

		JLabel lblNewLabel_3_1 = new JLabel("Base");
		base.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		acid = new JPanel();
		acid.setBorder(UIManager.getBorder("DesktopIcon.border"));
		acid.setForeground(new Color(0, 0, 0));
		acid.setBackground(new Color(254, 215, 180));
		acid.setBounds(279, 267, 201, 30);
		panel.add(acid);

		JLabel lblNewLabel_3_2 = new JLabel("Acid");
		acid.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 17));

		salt = new JPanel();
		salt.setBorder(UIManager.getBorder("DesktopIcon.border"));
		salt.setForeground(new Color(0, 0, 0));
		salt.setBackground(new Color(254, 215, 180));
		salt.setBounds(490, 185, 201, 30);
		panel.add(salt);

		JLabel lbsalt = new JLabel("Salt");
		salt.add(lbsalt);
		lbsalt.setFont(new Font("Tahoma", Font.PLAIN, 17));

		ocid = new JPanel();
		ocid.setBorder(UIManager.getBorder("DesktopIcon.border"));
		ocid.setForeground(new Color(0, 0, 0));
		ocid.setBackground(new Color(254, 215, 180));
		ocid.setBounds(490, 226, 201, 30);
		panel.add(ocid);

		JLabel lblNewLabel_3_1_1 = new JLabel("Ocid");
		ocid.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		donChat = new JPanel();
		donChat.setBackground(new Color(254, 191, 73));
		donChat.setBounds(126, 23, 402, 37);
		panel.add(donChat);
		donChat.setLayout(null);

		JLabel lbDonChat = new JLabel("I. Nguy\u00EAn t\u1ED1 h\u00F3a h\u1ECDc - \u0110\u01A1n ch\u1EA5t");
		lbDonChat.setBounds(4, 6, 339, 25);
		donChat.add(lbDonChat);
		lbDonChat.setBackground(new Color(255, 128, 128));
		lbDonChat.setFont(new Font("Tahoma", Font.BOLD, 20));

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(254, 191, 73));
//		panel_2_1.setLayout(null);
		panel_2_1.setBounds(126, 77, 402, 37);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("II. H\u1EE3p ch\u1EA5t h\u00F3a h\u1ECDc");
		lblNewLabel_1.setBounds(5, 7, 207, 25);
		panel_2_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	}

	public JPanel getSwitch() {
		return donChat;
	}
}
