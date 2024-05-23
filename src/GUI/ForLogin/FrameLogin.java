package GUI.ForLogin;

import javax.imageio.ImageIO;
import javax.management.Notification;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.ControlUser.RegisterUser;
import Model.User;
import component.Notifications;
import component.Notifications.Location;
import jnafilechooser.api.JnaFileChooser;
import util.PasswordUtil;

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
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

public class FrameLogin extends JFrame {
	private JPanel contentPane;
	public PaneLogin pLogin ;
	public PaneSignIn pSignIn = new PaneSignIn(null, null, null,null);
	private PaneEnterGmail pEnterGmail = new PaneEnterGmail();
	private JPanel panelConvert;
	private JFrame j = this;
	private PaneInputAvatar pAvatar;
	private String salt = "MiT6mPRGR4nSTiUEmbiW2gnnI9TdS5a0rq9FiEL3B+k=";

//    private JPanel panelConvert;;
	public FrameLogin() throws IOException {
		pLogin = new PaneLogin(this);
		System.out.println(salt);
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
//		pAvatar = new PaneInputAvatar(this);
		panelConvert.add(pLogin);
		contentPane.add(panelConvert);

		BufferedImage myLogo = ImageIO.read(new File("asset//img//logoDACS.png"));
		Image imgLogo = myLogo.getScaledInstance(185, 155, Image.SCALE_SMOOTH);
		ImageIcon scalesLoogo = new ImageIcon(imgLogo);
		JLabel lblNewLabel = new JLabel(scalesLoogo);
		lblNewLabel.setBounds(17, 98, 173, 172);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("EASY CHEMISTY");
//		lblNewLabel_1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                thongBaoSuccess(evt,  Notifications.Type.SUCCESS, Location.TOP_RIGHT, "ôi, chúc mừng bạn nhé"));
//            }
//        });
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

		pEnterGmail.btnEnterGmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String mail = pEnterGmail.tiepTuc();
				System.out.println("done " + mail);
				if (!mail.equals("err")) {
					if (!RegisterUser.checkMail(mail)) {
						contentPane.remove(panelConvert);
						try {
							String maXacNhan = RegisterUser.sentVari(mail);
							if (!maXacNhan.equals("")) {
								pSignIn = new PaneSignIn(mail, maXacNhan, j,salt);
								panelConvert = pSignIn;
								panelConvert.setBounds(205, 0, 543, 482);
								contentPane.add(panelConvert);
								contentPane.revalidate();
								contentPane.repaint();
								// trở lại trang đăng nhập
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
								// trở lại nhập gmail
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
								pSignIn.btnDK.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										try {
											User u = pSignIn.register();
											if (u != null) {
												pSignIn.userName = u.getUserName();
												contentPane.remove(panelConvert);
												pAvatar = new PaneInputAvatar(j, u);
												panelConvert = pAvatar;
												panelConvert.setBounds(205, 0, 543, 482);
												contentPane.add(panelConvert);
												contentPane.revalidate();
												contentPane.repaint();
												pAvatar.btnHoanThanh.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														if (RegisterUser.updateAvt(mail, pAvatar.imageBytes)) {
															contentPane.remove(panelConvert);
															panelConvert = pLogin;
															pLogin.tfTK.setText(u.getUserName());
															panelConvert.setBounds(205, 0, 543, 482);
															contentPane.add(panelConvert);
															contentPane.revalidate();
															contentPane.repaint();
															thongBao(ev, Notifications.Type.SUCCESS, Location.BOTTOM_CENTER,
																	"Hoàn thành đăng ký");
														}else {
															thongBao(ev, Notifications.Type.WARNING, Location.BOTTOM_CENTER,
																	"Không thể cập nhật hình ảnh");
														}

													}
												});
											}
										} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
//										contentPane.remove(panelConvert);
//										panelConvert = pLogin;
//										panelConvert.setBounds(205, 0, 543, 482);
//										contentPane.add(panelConvert);
//										contentPane.revalidate();
//										contentPane.repaint();
									}
								});
								thongBao(ev, Notifications.Type.INFO, Location.BOTTOM_CENTER,
										"Đã gửi mã xác nhận đến gmail của bạn");
							} else {
								thongBao(ev, Notifications.Type.WARNING, Location.BOTTOM_CENTER, "Gmail không tồn tại");
							}

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						thongBao(ev, Notifications.Type.WARNING, Location.BOTTOM_CENTER, "Gmail đã được sử dụng");
					}

				}

			}
		});
		// back to đăng nhập
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

	private void thongBao(java.awt.event.ActionEvent evt, component.Notifications.Type type, Location local,
			String text) {
		Notifications panel = new Notifications(this, type, local, text);
		panel.showNotification();
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
