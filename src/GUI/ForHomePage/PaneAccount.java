package GUI.ForHomePage;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class PaneAccount extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public PaneAccount() throws IOException {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(0, 0, 239, 65);
		setBackground(new Color(0, 91, 183));
		setLayout(null);
		BufferedImage myIconAvt = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAvt = myIconAvt.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		ImageIcon scalesAvt = new ImageIcon(imgIconAvt);
		JLabel lblNewLabel = new JLabel(scalesAvt);
		lblNewLabel.setBounds(2, 5, 48, 48);
		add(lblNewLabel);
		
		JTextPane txtpnHunhThHoi = new JTextPane();
		txtpnHunhThHoi.setForeground(new Color(255, 255, 255));
		txtpnHunhThHoi.setEditable(false);
		txtpnHunhThHoi.setBackground(getBackground());
		txtpnHunhThHoi.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtpnHunhThHoi.setBounds(51, 14, 188, 46);
		add(txtpnHunhThHoi);
		txtpnHunhThHoi.setText("Nguy\u1EC5n V\u0103n Ho\u00E0ng");
	}
}
