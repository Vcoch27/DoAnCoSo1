package GUI.ForHomePage;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Model.User;
import component.ImageAvatar;

public class PaneAccount extends JPanel {
	private ImageAvatar ia;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public PaneAccount(User u) throws IOException {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(0, 0, 239, 65);
		setBackground(new Color(91, 173, 255));
		setLayout(null);
		

		ByteArrayInputStream bais = new ByteArrayInputStream(u.getAvatar());

		try {
			BufferedImage bufferedImage = ImageIO.read(bais);
			ImageIcon icon = new ImageIcon(bufferedImage);
			ia = new ImageAvatar();
			ia.setIcon(icon);
			ia.setBounds(3, 3, 50, 51);
			add(ia);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JTextPane txtpnHunhThHoi = new JTextPane();
		txtpnHunhThHoi.setForeground(new Color(255, 255, 255));
		txtpnHunhThHoi.setEditable(false);
		txtpnHunhThHoi.setBackground(getBackground());
		txtpnHunhThHoi.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtpnHunhThHoi.setBounds(58, 2, 178, 43);
		add(txtpnHunhThHoi);
		txtpnHunhThHoi.setText(u.getFullName());
		
		JTextPane txtpnHunhThHoi_1 = new JTextPane();
		txtpnHunhThHoi_1.setText(u.getUserName());
		txtpnHunhThHoi_1.setForeground(Color.WHITE);
		txtpnHunhThHoi_1.setFont(new Font("Monospaced", Font.BOLD, 11));
		txtpnHunhThHoi_1.setEditable(false);
		txtpnHunhThHoi_1.setBackground(new Color(91, 173, 255));
		txtpnHunhThHoi_1.setBounds(60, 38, 178, 21);
		add(txtpnHunhThHoi_1);
	}
}
