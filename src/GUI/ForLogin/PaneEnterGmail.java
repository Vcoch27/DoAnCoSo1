package GUI.ForLogin;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

//new JPanel() {
//			@Override
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				ImageIcon imageIcon = new ImageIcon("asset//bg//bglogin.jpg");
//				Image image = imageIcon.getImage();
//				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
//			}
//		};
public class PaneEnterGmail extends JPanel {
	private TextField tfMail;
	public ButtonGradient button;
	private JLabel bg;
	private JLabel lblNewLabel_5;
	private JLabel lblBnChaC;
	public JLabel lbToLogIn;
	private JLabel lblngKVi;
	public JLabel lbErr;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public PaneEnterGmail() throws IOException {

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
		tfMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfMail.setBounds(99, 215, 328, 55);
		add(tfMail);
		tfMail.setColumns(10);

		tfMail.setText("nhập mail");
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

		button = new ButtonGradient();
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		button.setText("buttonGradient1");
		button.setText("Tiếp tục");
//		Button btnNewButton = new Button();
		button.setBounds(184, 393, 143, 43);
		add(button);

		BufferedImage myIconAcc = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAcc = myIconAcc.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon scalesAcc = new ImageIcon(imgIconAcc);

		BufferedImage myIconpass = ImageIO.read(new File("asset//img//pass.png"));
		Image imgIconpass = myIconpass.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		ImageIcon scalespass = new ImageIcon(imgIconpass);
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(106, 204, 111, 26);
		add(lblNewLabel_5);

		lblBnChaC = new JLabel("Bạn đã có tài khoản?");
		lblBnChaC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBnChaC.setBounds(130, 447, 153, 23);
		add(lblBnChaC);

		lbToLogIn = new JLabel("Đến đăng nhập");
		lbToLogIn.addMouseListener(new HoverListener(lbToLogIn));
		lbToLogIn.setForeground(new Color(0, 106, 106));
		lbToLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbToLogIn.setBounds(286, 447, 111, 23);
		add(lbToLogIn);

		BufferedImage myIconBack = ImageIO.read(new File("asset//img//back.png"));
		Image imgIconBack = myIconBack.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scalesBack = new ImageIcon(imgIconBack);

		lblngKVi = new JLabel("Nhập gmail đăng ký:");
		lblngKVi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblngKVi.setBounds(107, 185, 153, 23);
		add(lblngKVi);

		BufferedImage mybg = ImageIO.read(new File("asset//bg//bglogin2.png"));
		Image imgbg = mybg.getScaledInstance(543, 482, Image.SCALE_SMOOTH);
		ImageIcon scales = new ImageIcon(imgbg);

		 lbErr = new JLabel("");
		lbErr.setBounds(109, 281, 301, 14);
		add(lbErr);
		setBg(scales);
	}

	private void setBg(ImageIcon s) {
		bg = new JLabel(s);
		bg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bg.setBounds(0, 0, 543, 482);
		add(bg);
		

	}
	
	public String tiepTuc() {
		String gmail = tfMail.getText().trim();
		if(gmail.equals("")) {
			lbErr.setText("Hãy nhập gmail");
			return "err";
		}else if(!isGmailAddress(gmail)) {
			lbErr.setText("Gmail không hợp lệ");
			return "err";
		}else {
			return gmail;
		}
	}
	public  boolean isGmailAddress(String email) {
        String regex = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        // Kiểm tra nếu chuỗi khớp với biểu thức chính quy
        return matcher.matches();
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
}
