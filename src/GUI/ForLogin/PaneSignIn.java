package GUI.ForLogin;

import javax.swing.JPanel;
import javax.swing.Timer;

import Client.MainClient.MainClient;
import Controller.ControlUser.RegisterUser;
import Model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;

import component.ButtonGradient;
import component.Notifications;
import component.PasswordField;
import component.TextField;
import component.Notifications.Location;
import util.PasswordUtil;
import util.Verification;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaneSignIn extends JPanel {
	private TextField tfTK;
	private TextField tfMail;
	private TextField tfCode;
	private PasswordField pwMK;
	private PasswordField pwMKAgain;
	public ButtonGradient btnDK;
	public JLabel reSentCode;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel bg;
	private JLabel lblNewLabel_5;
	private JLabel lblBnChaC;
	public JLabel lbToLogin;
	private JLabel lblNewLabel_2;
	private JLabel lblngKVi;
	private int count;
	private javax.swing.Timer timer;
	private JLabel lbCountDown;
	public JLabel lbBack;
	private String to;
	public String maXacNhan;
	private JFrame frame;
	private TextField tfUserName;
	public String userName="";
	public String salt;
	public MainClient client;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public PaneSignIn(String gmail, String maXacNhan, JFrame frame, String salt , MainClient client) throws IOException {
		this.client = client;
		this.salt =salt;
		this.maXacNhan = maXacNhan;
		System.out.println(maXacNhan);
		this.to = gmail;
		this.frame = frame;
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		setBounds(0, 0, 543, 482);
		setLayout(null);

		BufferedImage mynoeye = ImageIO.read(new File("asset//img//noseePW.png"));
		Image imgnoeye = mynoeye.getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		ImageIcon scalesnoeye = new ImageIcon(imgnoeye);

		BufferedImage myeye = ImageIO.read(new File("asset//img//seePW.png"));
		Image imgeye = myeye.getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		ImageIcon scaleseye = new ImageIcon(imgeye);

		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setFont(new Font("Niagara Solid", Font.PLAIN, 64));
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setBounds(208, 6, 119, 49);
		add(lblNewLabel);

		tfMail = new TextField();
		tfMail.setEditable(false);
		tfMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfMail.setBounds(107, 75, 328, 55);
		add(tfMail);
		tfMail.setColumns(10);

		/// noteeeeeeeeeeeeee
		to = gmail;
		tfMail.setText(gmail);
		tfMail.isEditable();
		tfMail.setForeground(Color.GRAY);
		tfMail.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfMail.getText().equals("nhập mail")) {
					tfMail.setText("");
					tfMail.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfMail.getText().isEmpty()) {
					tfMail.setForeground(Color.GRAY);
					tfMail.setText("nhập mail");
				}
			}
		});
		tfUserName = new TextField();
		tfUserName.setText("username");
		tfUserName.setForeground(Color.GRAY);
		tfUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfUserName.setColumns(10);
		tfUserName.setBounds(107, 133, 328, 55);
		add(tfUserName);
		tfUserName.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfUserName.getText().equals("username")) {
					tfUserName.setText("");
					tfUserName.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfUserName.getText().isEmpty()) {
					tfUserName.setForeground(Color.GRAY);
					tfUserName.setText("username");
				}
			}
		});

		tfTK = new TextField();
		tfTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfTK.setBounds(107, 193, 328, 55);
		add(tfTK);
		tfTK.setColumns(10);

		tfTK.setText("họ và tên");
		tfTK.setForeground(Color.GRAY);
		tfTK.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfTK.getText().equals("họ và tên")) {
					tfTK.setText("");
					tfTK.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfTK.getText().isEmpty()) {
					tfTK.setForeground(Color.GRAY);
					tfTK.setText("họ và tên");
				}
			}
		});

		pwMK = new PasswordField();
		pwMK.setText("mật khẩu");
		pwMK.setEchoChar((char) 0);
		pwMK.setForeground(Color.GRAY);
		pwMK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwMK.setColumns(10);
		pwMK.setBounds(107, 259, 328, 49);
		add(pwMK);

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

		lblNewLabel_1.setBounds(438, 266, 26, 26);
		add(lblNewLabel_1);

		// ------------
		pwMKAgain = new PasswordField();
		pwMKAgain.setText("nhập lại mật khẩu");
		pwMKAgain.setEchoChar((char) 0);
		pwMKAgain.setForeground(Color.GRAY);
		pwMKAgain.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwMKAgain.setColumns(10);
		pwMKAgain.setBounds(107, 319, 328, 49);
		add(pwMKAgain);

		JLabel lblNewLabel_1_1 = new JLabel(scaleseye);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] password = pwMKAgain.getPassword();
				String text = new String(password);
				// Kiểm tra nếu passwordField đang hiển thị văn bản
				if (text.equals("nhập lại mật khẩu")) {
					pwMKAgain.setEchoChar((char) 0);
				} else if (pwMKAgain.getEchoChar() == 0) {
					// Che giấu văn bản
					pwMKAgain.setEchoChar('•'); // hoặc bất kỳ ký tự nào bạn muốn
					lblNewLabel_1_1.setIcon(scaleseye);
				} else {
					// Hiển thị văn bản
					pwMKAgain.setEchoChar((char) 0);
					lblNewLabel_1_1.setIcon(scalesnoeye);
				}

			}
		});

		pwMKAgain.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				char[] password = pwMKAgain.getPassword();
				String text = new String(password);
				if (text.equals("nhập lại mật khẩu")) {
					pwMKAgain.setEchoChar('•');
					pwMKAgain.setText("");
					pwMKAgain.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				char[] password = pwMKAgain.getPassword();
				String text = new String(password);
				if (text.isEmpty()) {
					pwMKAgain.setEchoChar((char) 0);
					pwMKAgain.setForeground(Color.GRAY);
					pwMKAgain.setText("nhập lại mật khẩu");
				}
			}
		});

		lblNewLabel_1_1.setBounds(438, 332, 26, 26);
		add(lblNewLabel_1_1);

		reSentCode = new JLabel("Gửi lại mã");
		reSentCode.setVisible(false);
		reSentCode.addMouseListener(new HoverListener(reSentCode));
		reSentCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reSentCode.setBounds(440, 387, 87, 23);
		add(reSentCode);

		btnDK = new ButtonGradient();
	
		btnDK.setForeground(new Color(0, 0, 0));
		btnDK.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDK.setText("buttonGradient1");
		btnDK.setText("Đăng ký");
//		Button btnStart = new Button();
		btnDK.setBounds(184, 435, 143, 43);
		add(btnDK);

		BufferedImage myIconAcc = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAcc = myIconAcc.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon scalesAcc = new ImageIcon(imgIconAcc);
		lblNewLabel_3 = new JLabel(scalesAcc);
		lblNewLabel_3.setBounds(62, 133, 36, 37);
		add(lblNewLabel_3);

		BufferedImage myIconpass = ImageIO.read(new File("asset//img//pass.png"));
		Image imgIconpass = myIconpass.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		ImageIcon scalespass = new ImageIcon(imgIconpass);
		lblNewLabel_4 = new JLabel(scalespass);
		lblNewLabel_4.setBounds(62, 262, 36, 37);
		add(lblNewLabel_4);
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(106, 204, 111, 26);
		add(lblNewLabel_5);

		lblBnChaC = new JLabel("Bạn đã có tài khoản?");
		lblBnChaC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBnChaC.setBounds(378, 435, 153, 23);
		add(lblBnChaC);

		lbToLogin = new JLabel("Đến đăng nhập");
		lbToLogin.addMouseListener(new HoverListener(lbToLogin));
		lbToLogin.setForeground(new Color(0, 106, 106));
		lbToLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbToLogin.setBounds(398, 457, 111, 23);
		add(lbToLogin);

		lblNewLabel_2 = new JLabel(scalespass);
		lblNewLabel_2.setBounds(60, 321, 36, 37);
		add(lblNewLabel_2);

		BufferedImage myIconBack = ImageIO.read(new File("asset//img//back.png"));
		Image imgIconBack = myIconBack.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scalesBack = new ImageIcon(imgIconBack);
		lbBack = new JLabel(scalesBack);
		lbBack.setBounds(10, 6, 40, 40);
//		lbBack.setVisible(false);
		add(lbBack);

		JLabel lblMXcMinh = new JLabel("Mã xác minh:");
		lblMXcMinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMXcMinh.setBounds(112, 386, 101, 23);
		add(lblMXcMinh);

		tfCode = new TextField();
		tfCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfCode.setBounds(211, 377, 221, 45);
		add(tfCode);
		tfCode.setColumns(10);

		tfCode.setText("mã xác minh gmail");
		tfCode.setForeground(Color.GRAY);
		tfCode.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfCode.getText().equals("mã xác minh gmail")) {
					tfCode.setText("");
					tfCode.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfCode.getText().isEmpty()) {
					tfCode.setForeground(Color.GRAY);
					tfCode.setText("mã xác minh gmail");
				}
			}
		});

		lblngKVi = new JLabel("Đăng kí với:");
		lblngKVi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblngKVi.setBounds(12, 86, 87, 23);
		add(lblngKVi);

		BufferedImage mybg = ImageIO.read(new File("asset//bg//bglogin2.png"));
		Image imgbg = mybg.getScaledInstance(543, 482, Image.SCALE_SMOOTH);
		ImageIcon scales = new ImageIcon(imgbg);

		lbCountDown = new JLabel();
		lbCountDown.setBounds(438, 384, 46, 31);
		add(lbCountDown);

		countDown();

		setBg(scales);
	}

	private void setBg(ImageIcon s) {
		bg = new JLabel(s);
		bg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bg.setBounds(0, 0, 543, 482);
		add(bg);

	}

	private void countDown() {
		count = 10;
		lbCountDown.setText(String.valueOf(count));
		setFont(new Font("Arial", Font.PLAIN, 24));
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				if (count > 0) {
					lbCountDown.setText(String.valueOf(count));
				} else if (count == 0) {
					reSentCode.setVisible(true);
					lbCountDown.setVisible(false);

				} else {
					((Timer) e.getSource()).stop();
				}
			}
		});
		timer.start();
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

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				if (refreshVeri(client)) {
					reSentCode.setVisible(false);
					lbCountDown.setVisible(true);
					countDown();
					Notifications panel = new Notifications(frame, Notifications.Type.INFO,
							Notifications.Location.BOTTOM_CENTER, "Gửi lại mã thành công");
					panel.showNotification();
				} else {
					Notifications panel = new Notifications(frame, Notifications.Type.WARNING,
							Notifications.Location.BOTTOM_CENTER, "Gửi lại mã không thành công");
					panel.showNotification();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	private boolean refreshVeri(MainClient client) throws IOException {
		client.dataOutput.writeUTF("ACCOUNT");
		client.dataOutput.writeUTF("REGISTERMail");
		client.dataOutput.writeUTF(to);
		String s = client.dataInput.readUTF();
		if(!s.equals("OUT")) {
			String veri = client.dataInput.readUTF();
			maXacNhan = veri;
			return true;
		}
		return false;

	}

	public User register() throws NoSuchAlgorithmException, InvalidKeySpecException {
	    
	    String userName = tfUserName.getText() ;
	    String fullName = tfTK.getText() ;
	    String mxn = tfCode.getText() ;
	    char[] passwordChars = pwMK.getPassword();
	    char[] confirmPasswordChars = pwMKAgain.getPassword();

	    // Chuyển đổi mảng ký tự mật khẩu thành chuỗi
	    String password = new String(passwordChars);
	    String confirmPassword = new String(confirmPasswordChars);

	    // Kiểm tra xem có thiếu thông tin nào không
	    if (userName.isEmpty() ||userName.equals("username")|| fullName.isEmpty() ||fullName.equals("họ và tên")|| password.isEmpty() ||password.equals("mật khẩu")|| confirmPassword.isEmpty()||confirmPassword.equals("nhập lại mật khẩu") || mxn.isEmpty()||mxn.equals("mã xác minh gmail")) {
	        showNotification(Notifications.Type.WARNING, "Hãy nhập đầy đủ thông tin");
	        return null;
	    }

	    // Kiểm tra xem mật khẩu và mật khẩu xác nhận có khớp nhau không
	    if (!password.equals(confirmPassword)) {
	        showNotification(Notifications.Type.WARNING, "Mật khẩu không trùng nhau");
	        return null;
	    }

	    // Kiểm tra độ mạnh của mật khẩu
	    if (!isStrongPassword(password)) {
	        showNotification(Notifications.Type.WARNING, "Mật khẩu không đủ mạnh ");
	        Timer timer = new Timer(2000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                showNotification(Notifications.Type.INFO, "Chứa ít nhất 1 chữ hoa, 1 chữ thường và 1 ký tự đặc biệt");
	            }
	        });
	        timer.setRepeats(false);
	        timer.start();

	        return null;
	    }

	    // Hash mật khẩu
	    salt = "MiT6mPRGR4nSTiUEmbiW2gnnI9TdS5a0rq9FiEL3B+k=";
	    String hashedPassword = PasswordUtil.hashPassword(password, salt);

	    // Tạo một đối tượng User mới
	    User u = new User(userName, tfMail.getText(), hashedPassword, fullName);
	    return u;
	    // Thêm người dùng vào cơ sở dữ liệu
//	    if (RegisterUser.addUser(u)) {
//	        showNotification(Notifications.Type.SUCCESS, "Tạo tài khoản thành công");
//	        clearFields();
//	        return u;
//	    } else {
//	        showNotification(Notifications.Type.WARNING, "Tên tài khoản đã tồn tại");
//	        return null;
//	    }
	}

	public void showNotification(Notifications.Type type, String message) {
	    Notifications panel = new Notifications(frame, type, Notifications.Location.BOTTOM_CENTER, message);
	    panel.showNotification();
	}

	private void clearFields() {
	    tfUserName.setText("");
	    tfTK.setText("");
	    tfCode.setText("");
	    pwMK.setText("");
	    pwMKAgain.setText("");
	}


    // Phương thức để kiểm tra mật khẩu có đủ mạnh không
    private boolean isStrongPassword(String password) {
        // Biểu thức chính quy để kiểm tra mật khẩu (phải chứa ít nhất một chữ hoa, một chữ thường và một ký tự đặc biệt)
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        // Tạo Pattern từ biểu thức chính quy
        Pattern pattern = Pattern.compile(passwordRegex);

        // Tạo Matcher từ mật khẩu đầu vào
        Matcher matcher = pattern.matcher(password);

        // Kiểm tra xem mật khẩu có khớp với biểu thức chính quy không
        return matcher.matches();
    }

}
