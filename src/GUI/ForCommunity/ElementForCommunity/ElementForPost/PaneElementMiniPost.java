package GUI.ForCommunity.ElementForCommunity.ElementForPost;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.text.BadLocationException;

import GUI.ForCommunity.KhungHienThiCommunity.FramePostFull;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaneElementMiniPost extends JPanel {
	private JTextPane textPane;
	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */

	// Tham số content ~~~ thêm sau
	public PaneElementMiniPost(String content) throws IOException {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBounds(0, 0, 330, 199);
		setLayout(null);

		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setEditable(false);

//		textPane.setText("Em bé Điện Biên ngày ngày dậy từ 5h sáng luyện tập cho lễ kỷ niệm. Có những hôm nắng nóng, hay những hôm không có lịch tập mà đổi lịch gấp em cũng vui vẻ đi tập, không thấy quấy bao giờ. ❤❤");
		textPane.setText(content);

		textPane.setBounds(3, 39, 324, 156);
		add(textPane);

		BufferedImage myIconAvt = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAvt = myIconAvt.getScaledInstance(40, 38, Image.SCALE_SMOOTH);
		ImageIcon scalesAvt = new ImageIcon(imgIconAvt);
		JLabel avt = new JLabel(scalesAvt);
		avt.setBounds(10, 0, 40, 38);
		add(avt);

		JLabel lbNameUser = new JLabel("Nguy\u1EC5n V\u0103n D\u01B0\u01A1ng");
		lbNameUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNameUser.setBounds(58, 1, 200, 20);
		add(lbNameUser);

		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDateTime = formatter.format(currentDate);

		System.out.println("Thời gian: " + formattedDateTime);
		JLabel lblNewLabel = new JLabel(formattedDateTime);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(60, 24, 117, 14);
		add(lblNewLabel);

		BufferedImage myIconView = ImageIO.read(new File("asset//img//view.png"));
		Image imgIconView = myIconView.getScaledInstance(24, 25, Image.SCALE_SMOOTH);
		ImageIcon scalesView = new ImageIcon(imgIconView);
		JLabel viewDetail = new JLabel(scalesView);
		viewDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FramePostFull fullPost = new FramePostFull();
					fullPost.setVisible(true);
					fullPost.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (IOException | BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		viewDetail.setBounds(292, 5, 24, 25);
		add(viewDetail);
	}
	public void setContentForMini(String a) {
		textPane.setText(a);
	}
}
