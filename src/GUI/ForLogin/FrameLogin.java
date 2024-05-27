package GUI.ForLogin;

import javax.imageio.ImageIO;
import javax.management.Notification;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Client.MainClient.MainClient;
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
	public PaneLogin pLogin;
	public PaneSignIn pSignIn = new PaneSignIn(null, null, null, null, null);
	private PaneEnterGmail pEnterGmail = new PaneEnterGmail();
	private JPanel panelConvert;
	public JFrame j = this;
	private PaneInputAvatar pAvatar;
	private String salt = "MiT6mPRGR4nSTiUEmbiW2gnnI9TdS5a0rq9FiEL3B+k=";

//    private JPanel panelConvert;;
	public FrameLogin(MainClient client) throws IOException {
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

		pEnterGmail.btnEnterGmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String mail = pEnterGmail.tiepTuc();
				if (!mail.equals("err")) {
					// -----------------------------
					try {
						client.dataOutput.writeUTF("ACCOUNT");
						client.sendString("REGISTERMail");
						client.sendString(mail);
						String checkMail = client.receiveString();
						if (checkMail.equals("DONE")) {
							String codeVerification = client.receiveString();
							pSignIn.maXacNhan = codeVerification;
							// ---------------------
							try {
								contentPane.remove(panelConvert);
								pSignIn = new PaneSignIn(mail, codeVerification, j, salt, client);
								panelConvert = pSignIn;
								panelConvert.setBounds(205, 0, 543, 482);
								contentPane.add(panelConvert);
								contentPane.revalidate();
								contentPane.repaint();

								// ---------------------------
								// chuyển giữa các panel
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
								// ---------------------------
								// Đăng kí tài khoản
								pSignIn.btnDK.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										try {
											User u = pSignIn.register();
											if (u != null) {
												client.sendString("ACCOUNT");
												client.sendString("REGISTER");
												client.objectOutput.writeObject(u);
												String signal = client.dataInput.readUTF();
												if (signal.equals("DONE")) {
													// ....tieesp tuc
													// ----------------------------------
													// chuyển đổi sang panelAvatar
													pSignIn.userName = u.getUserName();
													contentPane.remove(panelConvert);
													pAvatar = new PaneInputAvatar(j, u);
													panelConvert = pAvatar;
													panelConvert.setBounds(205, 0, 543, 482);
													contentPane.add(panelConvert);
													contentPane.revalidate();
													contentPane.repaint();
													// -----------------
													// hoàn thành đăng kí
													pAvatar.btnHoanThanh.addMouseListener(new MouseAdapter() {
														@Override
														public void mouseClicked(MouseEvent e) {

															try {
																client.dataOutput.writeUTF("ACCOUNT");
																client.dataOutput.writeUTF("AVATAR");

																client.objectOutput
																		.writeObject(new User(pAvatar.imageBytes));
																client.objectOutput.flush();
																client.dataOutput.writeUTF(pAvatar.u.getGmail());
																client.objectOutput.flush();
																String s = client.dataInput.readUTF();
																if (s.equals("DONE")) {
																	contentPane.remove(panelConvert);
																	panelConvert = pLogin;
																	pLogin.tfTK.setText(u.getUserName());
																	panelConvert.setBounds(205, 0, 543, 482);
																	contentPane.add(panelConvert);
																	contentPane.revalidate();
																	contentPane.repaint();
																	thongBao(ev, Notifications.Type.SUCCESS,
																			Location.BOTTOM_CENTER,
																			"Cập nhật AVT thành công");
																} else {
																	thongBao(ev, Notifications.Type.WARNING,
																			Location.BOTTOM_CENTER,
																			"Không thể cập nhật hình ảnh");
																}
															} catch (IOException e1) {
																// TODO Auto-generated catch block
																e1.printStackTrace();
															}

														}
													});

													pSignIn.showNotification(Notifications.Type.SUCCESS,
															"Tạo tài khoản thành công");
												} else {
													pSignIn.showNotification(Notifications.Type.WARNING,
															"Tên tài khoản đã tồn tại");
												}
											}

										} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {

											e1.printStackTrace();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
//										
									}
								});
								thongBao(ev, Notifications.Type.INFO, Location.BOTTOM_CENTER,
										"Đã gửi mã xác nhận đến gmail của bạn");

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							// ----------------------
						} else {
							thongBao(ev, Notifications.Type.WARNING, Location.BOTTOM_CENTER, "Gmail đã được sử dụng");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					// ------------------------------

//					if (!RegisterUser.checkMail(mail)) {} else {
//						thongBao(ev, Notifications.Type.WARNING, Location.BOTTOM_CENTER, "Gmail đã được sử dụng");
//					}

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

	public void thongBao(java.awt.event.ActionEvent evt, component.Notifications.Type type, Location local,
			String text) {
		Notifications panel = new Notifications(this, type, local, text);
		panel.showNotification();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			FrameLogin app;
			try {
				app = new FrameLogin(null);
				app.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
	}

}
