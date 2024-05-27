package GUI.ForLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.User;
import component.ButtonGradient;
import component.ImageAvatar;
import component.Notifications;
import jnafilechooser.api.JnaFileChooser;

public class PaneInputAvatar extends JPanel {
	public ButtonGradient btnHoanThanh;
	private JLabel bg;
	public JLabel lbErr;
	private JFrame frame;
	private ImageAvatar ia;
	public byte[] imageBytes;

	public User u;
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private ImageIcon scalesA = new ImageIcon(
			(ImageIO.read(new File("asset//img//avatarMacDinh.png"))).getScaledInstance(180, 180, Image.SCALE_SMOOTH));

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public PaneInputAvatar(JFrame frame, User u ) throws IOException {
		this.u = u;
		this.frame = frame;
		ByteArrayOutputStream baoss = new ByteArrayOutputStream();
		ImageIO.write(ImageIO.read(new File("asset//img//avatarMacDinh.png")), "png", baoss);
		
		//hình ảnh măc định
		imageBytes = baos.toByteArray();
		
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(192, 192, 192));
		setBounds(0, 0, 543, 482);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setFont(new Font("Niagara Solid", Font.PLAIN, 64));
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setBounds(212, 6, 119, 49);
		add(lblNewLabel);

		btnHoanThanh = new ButtonGradient();
		btnHoanThanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoanThanh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnHoanThanh.setForeground(new Color(0, 0, 0));
		btnHoanThanh.setFont(new Font("Arial", Font.PLAIN, 18));

		btnHoanThanh.setText("Hoàn thành");
		btnHoanThanh.setBounds(200, 393, 143, 43);
		add(btnHoanThanh);

		BufferedImage mybg = ImageIO.read(new File("asset//bg//bglogin2.png"));
		Image imgbg = mybg.getScaledInstance(543, 482, Image.SCALE_SMOOTH);
		ImageIcon scales = new ImageIcon(imgbg);

		ButtonGradient button_1 = new ButtonGradient();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					chonFile(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setText("Chọn ảnh");
		button_1.setColor2(new Color(0, 0, 255));
		button_1.setColor1(new Color(64, 0, 0));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(384, 281, 94, 31);
		add(button_1);

		ia = new ImageAvatar();
		ia.setIcon(scalesA);
		ia.setBounds(181, 132, 180, 180);
		add(ia);
		
		lbErr = new JLabel("");
		lbErr.setBounds(109, 281, 301, 14);
		add(lbErr);
		setBg(scales);
	}
	public byte[] getImagesImage() {
		return imageBytes;
	}

	private void setBg(ImageIcon s) {
		bg = new JLabel(s);
		bg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bg.setBounds(0, 0, 543, 482);
		add(bg);

	}

	private void chonFile(java.awt.event.ActionEvent evt) throws IOException {
		JnaFileChooser ch = new JnaFileChooser();
		boolean action = ch.showOpenDialog(frame);
		if (action) {
			try {
				File selectedFile = ch.getSelectedFile();
				if (selectedFile != null) {
					ImageIcon newIcon = new ImageIcon(
							ImageIO.read(selectedFile).getScaledInstance(180, 180, Image.SCALE_SMOOTH));
					ia.setIcon(newIcon);
					Notifications panel = new Notifications(frame, Notifications.Type.INFO,
							Notifications.Location.BOTTOM_CENTER, "Avatar đã được lựa chọn");
					panel.showNotification();

					BufferedImage image = ImageIO.read(selectedFile);
					
					ImageIO.write(image, "png", baos); // Chọn định dạng phù hợp, ví dụ: "png" hoặc "jpg"
					imageBytes = baos.toByteArray();
					
					System.out.println(imageBytes);
				} else {
					throw new IOException("File được chọn không tồn tại.");
				}
			} catch (IOException e) {
				e.printStackTrace();
				Notifications panel = new Notifications(frame, Notifications.Type.WARNING,
						Notifications.Location.BOTTOM_CENTER, "Lỗi khi đọc file ảnh");
				panel.showNotification();
			}
		} else {
			Notifications panel = new Notifications(frame, Notifications.Type.WARNING,
					Notifications.Location.BOTTOM_CENTER, "Bạn chưa chọn file ảnh");
			panel.showNotification();
		}
	}
}
