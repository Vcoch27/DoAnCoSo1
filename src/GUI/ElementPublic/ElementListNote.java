package GUI.ElementPublic;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;

import GUI.ForNotePage.KhungNotePage.FrameChoiceFileToSave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

public class ElementListNote extends JPanel {
	public JLabel lbOpenNote = new JLabel();
	public JLabel lbChoice = new JLabel();
	private final int WIDTH = 465;
	private final int HEIGHT = 55;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public ElementListNote(boolean type) throws IOException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
//		setBounds(0, 0, 465, 55);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
		
		BufferedImage mys = ImageIO.read(new File("asset//img//seePW.png"));
		Image imgs = mys.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon scaless = new ImageIcon(imgs);
		JLabel lbChoice_1 = new JLabel(scaless);
		lbChoice_1.setBounds(427, 11, 32, 32);
		add(lbChoice_1);
		
		if(type) {
			lbChoice_1.setVisible(false);
		}else {
			lbOpenNote.setVisible(false);
		}
		

	}

	public ElementListNote() throws IOException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
//		setBounds(0, 0, 465, 55);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
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

		BufferedImage myChoice = ImageIO.read(new File("asset//img//add.png"));
		Image imgChoice = myChoice.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon scaleschoice = new ImageIcon(imgChoice);
		lbChoice = new JLabel(scaleschoice);
		

		lbChoice.setBounds(427, 11, 32, 32);
		add(lbChoice);
		


	}
}
