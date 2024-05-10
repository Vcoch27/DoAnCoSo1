package GUI.ForCommunity.KhungHienThiCommunity;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public test() throws IOException {
		setBackground(new Color(255, 0, 255));
		setPreferredSize(new Dimension(980, 49));
		setLayout(null);
		
		
		
		BufferedImage myMore = ImageIO.read(new File("asset//img//newpost.png"));
		Image imgMore = myMore.getScaledInstance(80, 45, Image.SCALE_SMOOTH);
		ImageIcon scalesMore = new ImageIcon(imgMore);
		JLabel lbforSeeMore = new JLabel(scalesMore);
		lbforSeeMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lbforSeeMore.setBounds(450, 2, 80, 45);
		add(lbforSeeMore);
		
	}
}
