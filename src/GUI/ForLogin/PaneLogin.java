package GUI.ForLogin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;

import Controller.ControlUser.LoginUser;
import Model.PairModel;
import Model.User;
import component.ButtonGradient;
import component.Notifications;
import component.PasswordField;
import component.TextField;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//new JPanel() {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				ImageIcon imageIcon = new ImageIcon("asset//bg//bglogin.jpg");
//				Image image = imageIcon.getImage();
//				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
//			}
//		};
public class PaneLogin extends JPanel {
	public TextField tfTK;
	private PasswordField pwMK;
	public ButtonGradient btnLogIn;
	private JLabel lbQPass;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel bg;
	private JLabel lblNewLabel_5;
	private JLabel lblBnChaC;
	public JLabel lbCreate;
	private JFrame frame;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public PaneLogin(JFrame f) throws IOException {
		this.frame = f;
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		setBounds(0, 0, 543, 482);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setFont(new Font("Niagara Solid", Font.PLAIN, 67));
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setBounds(224, 51, 96, 55);
		add(lblNewLabel);

		tfTK = new TextField();
		tfTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfTK.setBounds(106, 150, 328, 55);
		add(tfTK);
		tfTK.setColumns(10);

		tfTK.setText("tên tài khoản");
		tfTK.setForeground(Color.GRAY);
		tfTK.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfTK.getText().equals("tên tài khoản")) {
					tfTK.setText("");
					tfTK.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfTK.getText().isEmpty()) {
					tfTK.setForeground(Color.GRAY);
					tfTK.setText("tên tài khoản");
				}
			}
		});

		pwMK = new PasswordField();
		pwMK.setText("mật khẩu");
		pwMK.setEchoChar((char) 0);
		pwMK.setForeground(Color.GRAY);
		pwMK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwMK.setColumns(10);
		pwMK.setBounds(106, 229, 328, 49);
		add(pwMK);

		btnLogIn = new ButtonGradient();

		btnLogIn.setForeground(new Color(0, 0, 0));
		btnLogIn.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLogIn.setText("buttonGradient1");
		btnLogIn.setText("Đăng nhập");
//		Button btnStart = new Button();
		btnLogIn.setBounds(200, 327, 143, 43);
		add(btnLogIn);

		BufferedImage mynoeye = ImageIO.read(new File("asset//img//noseePW.png"));
		Image imgnoeye = mynoeye.getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		ImageIcon scalesnoeye = new ImageIcon(imgnoeye);

		BufferedImage myeye = ImageIO.read(new File("asset//img//seePW.png"));
		Image imgeye = myeye.getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		ImageIcon scaleseye = new ImageIcon(imgeye);
		JLabel lblNewLabel_1 = new JLabel(scaleseye);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] password = pwMK.getPassword();
				String text = new String(password);
				// Kiểm tra nếu passwordField đang hiển thị văn bản
				if (text.equals("mật khẩu")) {
					pwMK.setEchoChar((char) 0);
				} else if (pwMK.getEchoChar() == 0) {
					// Che giấu văn bản
					pwMK.setEchoChar('•'); // hoặc bất kỳ ký tự nào bạn muốn
					lblNewLabel_1.setIcon(scaleseye);
				} else {
					// Hiển thị văn bản
					pwMK.setEchoChar((char) 0);
					lblNewLabel_1.setIcon(scalesnoeye);
				}

			}
		});

		pwMK.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				char[] password = pwMK.getPassword();
				String text = new String(password);
				if (text.equals("mật khẩu")) {
					pwMK.setEchoChar('•');
					pwMK.setText("");
					pwMK.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				char[] password = pwMK.getPassword();
				String text = new String(password);
				if (text.isEmpty()) {
					pwMK.setEchoChar((char) 0);
					pwMK.setForeground(Color.GRAY);
					pwMK.setText("mật khẩu");
				}
			}
		});

		lblNewLabel_1.setBounds(438, 241, 26, 26);
		add(lblNewLabel_1);

		lbQPass = new JLabel("Quên mật khẩu?");
		lbQPass.addMouseListener(new HoverListener(lbQPass));
		lbQPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbQPass.setBounds(323, 289, 111, 23);
		add(lbQPass);

		BufferedImage myIconAcc = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAcc = myIconAcc.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon scalesAcc = new ImageIcon(imgIconAcc);
		lblNewLabel_3 = new JLabel(scalesAcc);
		lblNewLabel_3.setBounds(68, 155, 36, 37);
		add(lblNewLabel_3);

		BufferedImage myIconpass = ImageIO.read(new File("asset//img//pass.png"));
		Image imgIconpass = myIconpass.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		ImageIcon scalespass = new ImageIcon(imgIconpass);
		lblNewLabel_4 = new JLabel(scalespass);
		lblNewLabel_4.setBounds(70, 232, 36, 37);
		add(lblNewLabel_4);
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(106, 204, 111, 26);
		add(lblNewLabel_5);

		lblBnChaC = new JLabel("Bạn chưa có tài khoản?");
		lblBnChaC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBnChaC.setBounds(117, 392, 153, 23);
		add(lblBnChaC);

		lbCreate = new JLabel("Tạo tài khoản");
		lbCreate.addMouseListener(new HoverListener(lbCreate));
		lbCreate.setForeground(new Color(0, 106, 106));
		lbCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbCreate.setBounds(287, 393, 111, 23);
		add(lbCreate);

		BufferedImage mybg = ImageIO.read(new File("asset//bg//bglogin2.png"));
		Image imgbg = mybg.getScaledInstance(543, 482, Image.SCALE_SMOOTH);
		ImageIcon scales = new ImageIcon(imgbg);
		bg = new JLabel(scales);
		bg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bg.setBounds(0, 0, 543, 482);
		add(bg, BorderLayout.SOUTH);

	}

	class HoverListener implements MouseListener {
		private JLabel label;
		private String originalText;

		public HoverListener(JLabel label) {
			this.label = label;
			this.originalText = label.getText();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label.setText("<html><u>" + originalText + "</u></html>");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			label.setText(originalText);
		}

		// Các phương thức còn lại không cần thiết, ta có thể để trống
		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	public PairModel<String, String> loginConditions() {
		String username = tfTK.getText();
		char[] pw = pwMK.getPassword();
		PairModel<String, String> acc = null;
		System.out.println(new String(pw));
		if (username.isEmpty() || username.equals("tên tài khoản") || pw.toString().isEmpty()
				|| pw.toString().equals("mật khẩu")) {
			showNotification(Notifications.Type.WARNING, "Hãy nhập đầy đủ thông tin");
			return null;
		} else {
			return new PairModel<String, String>(username, new String(pw));
//			try {
//				User u = LoginUser.login(username, new String(pw));
//				if(u!=null) {
//					showNotification(Notifications.Type.SUCCESS, "Đăng nhập thành công");
//					return u;
//					
//				}else {
//					showNotification(Notifications.Type.WARNING, "Tên tài khoản hoặc mật khẩu không chính xác");
//				}
//			} catch (Exception e) {
//				showNotification(Notifications.Type.WARNING, "Đăng nhập không thành công");
//			}
		}

	}

	public void showNotification(Notifications.Type type, String message) {
		Notifications panel = new Notifications(frame, type, Notifications.Location.BOTTOM_CENTER, message);
		panel.showNotification();
	}
}
