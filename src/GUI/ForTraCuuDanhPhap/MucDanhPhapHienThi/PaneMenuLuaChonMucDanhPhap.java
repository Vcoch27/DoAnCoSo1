package GUI.ForTraCuuDanhPhap.MucDanhPhapHienThi;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class PaneMenuLuaChonMucDanhPhap extends JPanel {
	private Color mauChuDao = new Color(100,149,237);
	public JPanel donChat;
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1.setBackground(new Color(254, 215, 180));
		panel_1.setBounds(279, 367, 201, 30);
		panel.add(panel_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("Alkane");
		panel_1.add(lblNewLabel_3_4);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1.setBackground(new Color(254, 215, 180));
		panel_1_1.setBounds(279, 408, 201, 30);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Alkene");
		panel_1_1.add(lblNewLabel_3_1_2);
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1.setBackground(new Color(254, 215, 180));
		panel_1_1_1.setBounds(279, 449, 201, 30);
		panel.add(panel_1_1_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Alkyne");
		panel_1_1_1.add(lblNewLabel_3_2_2);
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1_1.setBackground(new Color(254, 215, 180));
		panel_1_1_1_1.setBounds(279, 490, 201, 30);
		panel.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Aromatic hydrocarbon");
		panel_1_1_1_1.add(lblNewLabel_3_1_2_1);
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1_2.setBackground(new Color(254, 215, 180));
		panel_1_1_1_2.setBounds(279, 531, 201, 30);
		panel.add(panel_1_1_1_2);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("Halogen derivatives");
		panel_1_1_1_2.add(lblNewLabel_3_2_2_1);
		lblNewLabel_3_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1_3 = new JPanel();
		panel_1_1_1_3.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1_3.setBackground(new Color(254, 215, 180));
		panel_1_1_1_3.setBounds(490, 367, 201, 30);
		panel.add(panel_1_1_1_3);
		
		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("Alcohol");
		panel_1_1_1_3.add(lblNewLabel_3_1_1_1_2);
		lblNewLabel_3_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1_4 = new JPanel();
		panel_1_1_1_4.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1_4.setBackground(new Color(254, 215, 180));
		panel_1_1_1_4.setBounds(490, 408, 201, 30);
		panel.add(panel_1_1_1_4);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Phenol");
		panel_1_1_1_4.add(lblNewLabel_3_1_1_1);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1_5 = new JPanel();
		panel_1_1_1_5.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1_5.setBackground(new Color(254, 215, 180));
		panel_1_1_1_5.setBounds(490, 449, 201, 30);
		panel.add(panel_1_1_1_5);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Aldehyde");
		panel_1_1_1_5.add(lblNewLabel_3_2_1_1);
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1_6 = new JPanel();
		panel_1_1_1_6.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1_6.setBackground(new Color(254, 215, 180));
		panel_1_1_1_6.setBounds(490, 490, 201, 30);
		panel.add(panel_1_1_1_6);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Ketone");
		panel_1_1_1_6.add(lblNewLabel_3_1_1_1_1);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_1_1_7 = new JPanel();
		panel_1_1_1_7.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1_1_7.setBackground(new Color(254, 215, 180));
		panel_1_1_1_7.setBounds(490, 531, 201, 30);
		panel.add(panel_1_1_1_7);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Carboxylic acid");
		panel_1_1_1_7.add(lblNewLabel_3_2_1_1_1);
		lblNewLabel_3_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(Color.GRAY));
		panel_1_2.setForeground(new Color(0, 0, 0));
		panel_1_2.setBackground(new Color(254, 215, 180));
		panel_1_2.setBounds(279, 185, 201, 30);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ion");
		panel_1_2.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_2_1.setForeground(new Color(0, 0, 0));
		panel_1_2_1.setBackground(new Color(254, 215, 180));
		panel_1_2_1.setBounds(279, 226, 201, 30);
		panel.add(panel_1_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Base");
		panel_1_2_1.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_2_2.setForeground(new Color(0, 0, 0));
		panel_1_2_2.setBackground(new Color(254, 215, 180));
		panel_1_2_2.setBounds(279, 267, 201, 30);
		panel.add(panel_1_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Acid");
		panel_1_2_2.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_2_3 = new JPanel();
		panel_1_2_3.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_2_3.setForeground(new Color(0, 0, 0));
		panel_1_2_3.setBackground(new Color(254, 215, 180));
		panel_1_2_3.setBounds(490, 185, 201, 30);
		panel.add(panel_1_2_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Mu\u1ED1i - Salt");
		panel_1_2_3.add(lblNewLabel_3_3);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1_2_4 = new JPanel();
		panel_1_2_4.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_2_4.setForeground(new Color(0, 0, 0));
		panel_1_2_4.setBackground(new Color(254, 215, 180));
		panel_1_2_4.setBounds(490, 226, 201, 30);
		panel.add(panel_1_2_4);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ocid");
		panel_1_2_4.add(lblNewLabel_3_1_1);
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
	public JPanel  getSwitch() {
		return donChat;
	}
}
