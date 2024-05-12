package GUI.ForLogin;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class FrameLogin extends JFrame {
	private JPanel contentPane;
	public PaneLogin pLogin = new PaneLogin();
	private PaneSignIn pSignIn ;
	private PaneEnterGmail pEnterGmail = new PaneEnterGmail();
	private JPanel panelConvert;

//    private JPanel panelConvert;;
	public FrameLogin() throws IOException {
		setResizable(false);
		setTitle("Login or Register");
		setBounds(500, 200, 764, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(14, 0, 81));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JPanel panelConvert = new PaneEnterGmail();
		panelConvert = new JPanel();
		panelConvert.setBounds(205, 0, 543, 482);
		panelConvert.setLayout(null);
		panelConvert.add(pLogin);
		contentPane.add(panelConvert);

		BufferedImage myLogo = ImageIO.read(new File("asset//img//logoDACS.png"));
		Image imgLogo = myLogo.getScaledInstance(185, 155, Image.SCALE_SMOOTH);
		ImageIcon scalesLoogo = new ImageIcon(imgLogo);
		JLabel lblNewLabel = new JLabel(scalesLoogo);
		lblNewLabel.setBounds(17, 98, 173, 172);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("EASY CHEMISTY");
		lblNewLabel_1.setFont(new Font("NSimSun", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 259, 173, 60);
		contentPane.add(lblNewLabel_1);

		pLogin.lbCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.remove(panelConvert);
				panelConvert = pEnterGmail;
				panelConvert.setBounds(205, 0, 543, 482);
				contentPane.add(panelConvert);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		pEnterGmail.button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mail = pEnterGmail.tiepTuc();
				if (!mail.equals("err")) {
					contentPane.remove(panelConvert);
					try {
						pSignIn = new PaneSignIn(mail);
						panelConvert = pSignIn;
						panelConvert.setBounds(205, 0, 543, 482);
						contentPane.add(panelConvert);
						contentPane.revalidate();
						contentPane.repaint();
						pSignIn.lbToLogin.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								contentPane.remove(panelConvert);
								panelConvert = pLogin;
								panelConvert.setBounds(205, 0, 543, 482);
								contentPane.add(panelConvert);
								contentPane.revalidate();
								contentPane.repaint();
							}
						});
						pSignIn.lbBack.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								contentPane.remove(panelConvert);
								panelConvert = pEnterGmail;
								panelConvert.setBounds(205, 0, 543, 482);
								contentPane.add(panelConvert);
								contentPane.revalidate();
								contentPane.repaint();
							}
						});
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});
		pEnterGmail.lbToLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.remove(panelConvert);
				panelConvert = pLogin;
				panelConvert.setBounds(205, 0, 543, 482);
				contentPane.add(panelConvert);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			FrameLogin app;
			try {
				app = new FrameLogin();
				app.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
	}
}
