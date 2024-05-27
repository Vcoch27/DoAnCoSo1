package GUI.MainFramesDesktop;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import Client.MainClient.MainClient;
import GUI.ForBangTuanHoan.KhungHienThiBangTuanHoan.PanelBangTuanHoan;
import GUI.ForCommunity.KhungHienThiCommunity.FrameCommunity;
import GUI.ForHomePage.PaneAccount;
import GUI.ForHomePage.PaneHomePage;
import GUI.ForHomePage.PaneLogIn_Out;
import GUI.ForNotePage.KhungNotePage.FrameNote;
import GUI.ForTraCuuDanhPhap.KhungHienThiTCDP.PaneTraCuuDanhPhap;
import Model.PairModel;
import Model.User;
import component.Notifications;
import component.TextField;
import component.Notifications.Location;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;

public class FrameMain extends JFrame {
	private User user = null;
	private JPanel contentPane;
	private Color mauChuDao = new Color(100, 149, 237);
	private JPanel mainPane = new JPanel();
	private PaneHomePage homePane = new PaneHomePage();
	private PanelBangTuanHoan paneBTH = null;
	private PaneAccount pAcc;
	private PaneLogIn_Out pIO = null;
	private JPanel panel = new JPanel();
	private JPanel forAcc = new JPanel();
	private static MainClient client;
	private JFrame j = this;
	private FrameCommunity fCom = null;

//	private PaneTraCuuDanhPhap paneDP = new PaneTraCuuDanhPhap();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		client = new MainClient("localhost", 12345);
		try {
			client.connect();
//			String response = client.receiveString();
//			System.out.println("Server response: " + response);
			client.sendString("START");
			System.out.println("done");
			System.out.println(client.receiveString());
		} catch (IOException ex) {
			System.out.println("Client exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					FrameMain frame = new FrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public FrameMain() throws IOException {

		// ------------------------
		// Khởi tạo component với tham số
		pIO = new PaneLogIn_Out(client);
		// ------------------------

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(mauChuDao);
		panel.setBounds(0, 0, 1284, 65);
		contentPane.add(panel);
		panel.setLayout(null);

		BufferedImage myLogo = ImageIO.read(new File("asset//img//logoHoaHoc.png"));
		Image imgLogo = myLogo.getScaledInstance(90, 60, Image.SCALE_SMOOTH);
		ImageIcon scalesLoogo = new ImageIcon(imgLogo);
		JLabel lbLogo = new JLabel(scalesLoogo);
		lbLogo.setBounds(7, 3, 90, 60);
		panel.add(lbLogo);

		JLabel lbNameApp = new JLabel("Chem m\u00ED c\u1ED3");
		lbNameApp.setFont(new Font("Arial", Font.PLAIN, 29));
		lbNameApp.setBounds(107, 11, 184, 39);
		panel.add(lbNameApp);

		JPanel navBar = new JPanel();
		navBar.setBackground(mauChuDao);
		navBar.setBounds(301, -2, 419, 65);
		panel.add(navBar);
		navBar.setLayout(null);

		BufferedImage myIconHomePage = ImageIO.read(new File("asset//img//home.png"));
		Image imgIconHomePage = myIconHomePage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesHomePage = new ImageIcon(imgIconHomePage);
		JLabel lbHomePage = new JLabel(scalesHomePage);
		lbHomePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.remove(mainPane);
				mainPane = homePane;
				mainPane.setBounds(0, 76, 1285, 635);
				contentPane.add(mainPane);
				contentPane.revalidate();
				contentPane.repaint();

			}
		});
		lbHomePage.setBounds(10, 0, 65, 65);
		navBar.add(lbHomePage);

		BufferedImage myIconBTH = ImageIO.read(new File("asset//img//BTH.png"));
		Image imgIconBTH = myIconBTH.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesBTH = new ImageIcon(imgIconBTH);
		JLabel lbBTH = new JLabel(scalesBTH);
		lbBTH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					paneBTH = new PanelBangTuanHoan(client, j);
					contentPane.remove(mainPane);
					mainPane = paneBTH;
					mainPane.setBounds(0, 76, 1285, 635);
					contentPane.add(mainPane);
					contentPane.revalidate();
					contentPane.repaint();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		lbBTH.setBounds(85, 0, 65, 65);
		navBar.add(lbBTH);

		BufferedImage myIconDP = ImageIO.read(new File("asset//img//danhphap.png"));
		Image imgIconDP = myIconDP.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesDP = new ImageIcon(imgIconDP);
		JLabel lbDanhPhap = new JLabel(scalesDP);
		lbDanhPhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					contentPane.remove(mainPane);
					PaneTraCuuDanhPhap paneDP;
					paneDP = new PaneTraCuuDanhPhap(client, j);
					mainPane = paneDP;
					mainPane.setBounds(0, 76, 1285, 635);
					contentPane.add(mainPane);
					contentPane.revalidate();
					contentPane.repaint();
					paneDP.menuDP.donChat.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							contentPane.remove(mainPane);
							mainPane = paneBTH;
							mainPane.setBounds(0, 76, 1285, 635);
							contentPane.add(mainPane);
							contentPane.revalidate();
							contentPane.repaint();
						}
					});
				} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		lbDanhPhap.setBounds(160, 0, 65, 65);
		navBar.add(lbDanhPhap);

		BufferedImage myIconCD = ImageIO.read(new File("asset//img//community.png"));
		Image imgIconCD = myIconCD.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesCD = new ImageIcon(imgIconCD);
		JLabel lbCongDong = new JLabel(scalesCD);
		lbCongDong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (user != null) {
					try {
						fCom = new FrameCommunity(client,user );
						fCom.setVisible(true);
						fCom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} catch (IOException | BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {

					pIO.fl.setVisible(true);
					pIO.fl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Notifications panel = new Notifications(pIO.fl.j, Notifications.Type.WARNING,
							Location.BOTTOM_CENTER, "bạn cần đăng nhập để tiếp tục");
					panel.showNotification();

//					  Notifications panel = new Notifications(frame, type, Notifications.Location.BOTTOM_CENTER, message);
//					    panel.showNotification();
				}
			}
		});
		lbCongDong.setBounds(235, 0, 65, 65);
		navBar.add(lbCongDong);

		BufferedImage myIconNote = ImageIO.read(new File("asset//img//note.png"));
		Image imgIconNote = myIconNote.getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		ImageIcon scalesNote = new ImageIcon(imgIconNote);
		JLabel lbCongDong_1 = new JLabel(scalesNote);
		lbCongDong_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FrameNote note = new FrameNote();
					note.setVisible(true);
					note.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbCongDong_1.setBounds(312, 1, 65, 65);
		navBar.add(lbCongDong_1);

		TextField tf = new TextField();
		tf = new TextField();
		tf.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf.setBackground(mauChuDao);
		tf.setBounds(769, 11, 235, 46);
		panel.add(tf);
		tf.setColumns(10);

		BufferedImage myIconSearch = ImageIO.read(new File("asset//img//search.png"));
		Image imgIconSearch = myIconSearch.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scalesSearch = new ImageIcon(imgIconSearch);
		JLabel lbSearch = new JLabel(scalesSearch);
		lbSearch.setBounds(728, 19, 30, 30);
		panel.add(lbSearch);

		forAcc = new JPanel();
		forAcc.setLayout(null);
		forAcc.setBounds(1045, 0, 239, 65);

		// -----------------------
		// Open luồng Account
		pIO.btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pIO.fl.setVisible(true);
				pIO.fl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});

		forAcc.add(pIO);
		panel.add(forAcc);

		// ---------------------
		// Phương thức đăng nhập
		pIO.fl.pLogin.btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				PairModel<String, String> acc = pIO.fl.pLogin.loginConditions();
//				if (acc != null) {
//					try {
//						client.sendString("ACCOUNT");
//						client.sendString("LOGIN");
//						client.objectOutput.writeObject(acc);
//						client.objectOutput.flush();
//						System.out.println("done gửi pair");
//						user = (User) client.objectInput.readObject();
//						if (user != null) {
//							pIO.fl.pLogin.showNotification(Notifications.Type.SUCCESS, "Đăng nhập thành công");
//							doneLogin(user);
//						} else {
//							pIO.fl.pLogin.showNotification(Notifications.Type.WARNING,
//									"Tên tài khoản hoặc mật khẩu không chính xác");
//						}
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (ClassNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				} else {
//					System.out.println("null roi");
//				}
				try {
					performLogin(false);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		mainPane = new JPanel();
		mainPane.setBounds(0, 76, 1285, 635);
		mainPane.setLayout(null);
		mainPane.add(homePane);
		contentPane.add(mainPane);

		// -----------------------------------
		// đóng chương trình - đóng luồng client
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Gọi client.close() trước khi đóng chương trình
				try {
					client.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				// Đóng JFrame
				dispose();
			}
		});
	}

	private void doneLogin(User u, boolean s) throws IOException, BadLocationException {

		panel.remove(forAcc);
		pAcc = new PaneAccount(u);
		forAcc = pAcc;
		forAcc.setBounds(1045, 0, 239, 65);
		panel.add(forAcc);
		System.out.println("done");
		panel.revalidate();
		panel.repaint();
		pIO.fl.setVisible(false);
		if (s) {
			fCom = new FrameCommunity(client,user);
			fCom.setVisible(true);
			fCom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			System.out.println("done");
		}

	}

	private void performLogin(boolean s) throws BadLocationException {
		PairModel<String, String> acc = pIO.fl.pLogin.loginConditions();
		if (acc != null && user == null) {
			try {
				client.sendString("ACCOUNT");
				client.sendString("LOGIN");
				client.objectOutput.writeObject(acc);
				client.objectOutput.flush();
				System.out.println("done gửi pair");
				user = (User) client.objectInput.readObject();
				if (user != null) {
					pIO.fl.pLogin.showNotification(Notifications.Type.SUCCESS, "Đăng nhập thành công");
					doneLogin(user, s);
					if (s) {
//						fCom = new FrameCommunity();
						fCom.setVisible(true);
						fCom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						System.out.println("done");
					}
				} else {
					pIO.fl.pLogin.showNotification(Notifications.Type.WARNING,
							"Tên tài khoản hoặc mật khẩu không chính xác");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			System.out.println("null roi");
		}
	}
}