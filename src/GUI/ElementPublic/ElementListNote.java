package GUI.ElementPublic;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElementListNote extends JPanel {
	public JLabel lbOpenNote;
	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public ElementListNote() throws IOException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 465, 55);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Text note 1 ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(18, 11, 183, 32);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("update:");
		lblNewLabel_1.setBounds(225, 20, 46, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("29/04/2024");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(268, 20, 97, 14);
		add(lblNewLabel_2);
		
		
		BufferedImage myLogo = ImageIO.read(new File("asset//img//eye.png"));
        Image imgLogo = myLogo.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon scalesLogo = new ImageIcon(imgLogo);
		lbOpenNote = new JLabel(scalesLogo);
		lbOpenNote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lbOpenNote.setBounds(427, 15, 25, 25);
		add(lbOpenNote);

      

	}
}
