package GUI.ForLogin;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import component.ButtonGradient;
import component.PasswordField;
import component.TextField;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private PasswordField pwMKa;
	private ButtonGradient button;
	private JLabel reSentCode;
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

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public PaneSignIn(String gmail) throws IOException {

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
		tfMail.setBounds(101, 75, 328, 55);
		add(tfMail);
		tfMail.setColumns(10);

		///noteeeeeeeeeeeeee
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

		tfTK = new TextField();
		tfTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfTK.setBounds(101, 141, 328, 55);
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
		pwMK.setBounds(101, 207, 328, 49);
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

		lblNewLabel_1.setBounds(438, 214, 26, 26);
		add(lblNewLabel_1);

		// ------------
		pwMKa = new PasswordField();
		pwMKa.setText("nhập lại mật khẩu");
		pwMKa.setEchoChar((char) 0);
		pwMKa.setForeground(Color.GRAY);
		pwMKa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwMKa.setColumns(10);
		pwMKa.setBounds(101, 267, 328, 49);
		add(pwMKa);

		JLabel lblNewLabel_1_1 = new JLabel(scaleseye);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] password = pwMKa.getPassword();
				String text = new String(password);
				// Kiểm tra nếu passwordField đang hiển thị văn bản
				if (text.equals("nhập lại mật khẩu")) {
					pwMKa.setEchoChar((char) 0);
				} else if (pwMKa.getEchoChar() == 0) {
					// Che giấu văn bản
					pwMKa.setEchoChar('•'); // hoặc bất kỳ ký tự nào bạn muốn
					lblNewLabel_1_1.setIcon(scaleseye);
				} else {
					// Hiển thị văn bản
					pwMKa.setEchoChar((char) 0);
					lblNewLabel_1_1.setIcon(scalesnoeye);
				}

			}
		});

		pwMKa.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				char[] password = pwMKa.getPassword();
				String text = new String(password);
				if (text.equals("nhập lại mật khẩu")) {
					pwMKa.setEchoChar('•');
					pwMKa.setText("");
					pwMKa.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				char[] password = pwMKa.getPassword();
				String text = new String(password);
				if (text.isEmpty()) {
					pwMKa.setEchoChar((char) 0);
					pwMKa.setForeground(Color.GRAY);
					pwMKa.setText("nhập lại mật khẩu");
				}
			}
		});

		lblNewLabel_1_1.setBounds(438, 280, 26, 26);
		add(lblNewLabel_1_1);

		reSentCode = new JLabel("Gửi lại mã");
		reSentCode.setVisible(false);
		reSentCode.addMouseListener(new HoverListener(reSentCode));
		reSentCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reSentCode.setBounds(438, 340, 87, 23);
		add(reSentCode);

		button = new ButtonGradient();
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		button.setText("buttonGradient1");
		button.setText("Đăng ký");
//		Button btnNewButton = new Button();
		button.setBounds(184, 393, 143, 43);
		add(button);

		BufferedImage myIconAcc = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAcc = myIconAcc.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon scalesAcc = new ImageIcon(imgIconAcc);
		lblNewLabel_3 = new JLabel(scalesAcc);
		lblNewLabel_3.setBounds(62, 148, 36, 37);
		add(lblNewLabel_3);

		BufferedImage myIconpass = ImageIO.read(new File("asset//img//pass.png"));
		Image imgIconpass = myIconpass.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		ImageIcon scalespass = new ImageIcon(imgIconpass);
		lblNewLabel_4 = new JLabel(scalespass);
		lblNewLabel_4.setBounds(62, 210, 36, 37);
		add(lblNewLabel_4);
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(106, 204, 111, 26);
		add(lblNewLabel_5);

		lblBnChaC = new JLabel("Bạn đã có tài khoản?");
		lblBnChaC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBnChaC.setBounds(130, 447, 153, 23);
		add(lblBnChaC);

		lbToLogin = new JLabel("Đến đăng nhập");
		lbToLogin.addMouseListener(new HoverListener(lbToLogin));
		lbToLogin.setForeground(new Color(0, 106, 106));
		lbToLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbToLogin.setBounds(286, 447, 111, 23);
		add(lbToLogin);

		lblNewLabel_2 = new JLabel(scalespass);
		lblNewLabel_2.setBounds(60, 269, 36, 37);
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
		lblMXcMinh.setBounds(106, 343, 101, 23);
		add(lblMXcMinh);

		tfCode = new TextField();
		tfCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfCode.setBounds(206, 332, 221, 45);
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
		lbCountDown.setBounds(438, 335, 46, 31);
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
		count = 3;
		lbCountDown.setText(String.valueOf(count));
		setFont(new Font("Arial", Font.PLAIN, 24));
		timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count > 0) {
                	lbCountDown.setText(String.valueOf(count));
                } else if(count==0) {
                	reSentCode.setVisible(true);
                	lbCountDown.setVisible(false);
                	
                }
                else {
                    ((Timer)e.getSource()).stop();
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

		// Các phương thức còn lại không cần thiết, ta có thể để trống
		@Override
		public void mouseClicked(MouseEvent e) {
			//gửi lại mã 
			reSentCode.setVisible(false);
			lbCountDown.setVisible(true);
			countDown();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}
