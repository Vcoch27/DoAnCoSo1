package GUI.ForCommunity.ElementForCommunity.ElementForPost;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import java.awt.Color;

public class ElementComment extends JPanel {
	private static final int WIDTH = 815;
	private static final int HEIGHT = 46;
	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws BadLocationException
	 */
	public ElementComment(String textt) throws IOException, BadLocationException {
		setBackground(new Color(128, 255, 255));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);

		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDateTime = formatter.format(currentDate);

		BufferedImage myIconAvt = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAvt = myIconAvt.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon scalesAvt = new ImageIcon(imgIconAvt);
		JLabel avatar = new JLabel(scalesAvt);
		avatar.setBounds(11, 6, 35, 35);
		add(avatar);

		JPanel panel = new JPanel();
		panel.setBounds(55, 2, 203, 42);
		add(panel);

		JLabel lblNewLabel_1 = new JLabel("Trần Đức Hoàng");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel lblNewLabel = new JLabel(formattedDateTime);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		String text = textt;
		int width = 474;
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(268, 6, 480, 31);
		add(textPane);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane.setPreferredSize(new Dimension(474, 29));
		int height = calculateHeight(textPane, text, width);
		textPane.setBounds(268, 6, 480, height);
		textPane.setText(text);
		textPane.setEditable(false);
		setBounds(0, 0, 815, height+15);
		setPreferredSize(new Dimension(WIDTH, height+15));
	}

	public static int calculateHeight(JTextPane textPane, String text, int width) {
		// FontMetrics chứa thông tin về các đặc tính của font
		FontMetrics metrics = textPane.getFontMetrics(textPane.getFont());
		Font font = textPane.getFont();
		// chỉ định rằng không có biến đổi nào được áp dụng cho font
		FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
		int totalWidth = 0;
		int lines = 1;
		// \\s đại diện cho ký tự khoảng trắng + một hoặc nhiều kí tự khoảng trắng có
		// thể xuất hiện
		String[] words = text.split("\\s+");
		for (String word : words) {
			int wordWidth = metrics.stringWidth(word);
			totalWidth += wordWidth;

			if (totalWidth > width) {
				lines++;
				totalWidth = wordWidth;
			} else {
				totalWidth += metrics.stringWidth(" ");
			}
		}

		int lineHeight = metrics.getHeight()+3;
		return lines * lineHeight;
	}

}
