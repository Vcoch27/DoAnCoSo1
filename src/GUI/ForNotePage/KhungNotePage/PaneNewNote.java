package GUI.ForNotePage.KhungNotePage;

import javax.swing.JPanel;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaneNewNote extends JPanel {
	public JTextField enterName;
	private JPanel add;	
	private JPanel inputName;
	private JLabel lblNewLabel_2;
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public PaneNewNote() throws IOException {
		setBackground(new Color(0, 0, 0));
		setBounds(0, 0, 465, 54);
		setLayout(null);
		
		inputName = new JPanel();
		inputName.setBackground(new Color(58, 58, 58));
		inputName.setBounds(600, 0, 500, 54);
		add(inputName);
		inputName.setLayout(null);
		
		enterName = new JTextField();
		enterName.setBounds(122, 11, 320, 32);
		inputName.add(enterName);
		enterName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn t\u1EC7p ghi ch\u00FA:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 11, 112, 32);
		inputName.add(lblNewLabel_1);
		
		BufferedImage bufferX = ImageIO.read(new File("asset//img//x.png"));
		Image imgX = bufferX.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		ImageIcon scalesIconX = new ImageIcon(imgX);
		lblNewLabel_2 = new JLabel(scalesIconX);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chuyen();
			}
		});
		lblNewLabel_2.setBounds(450, 15, 23, 23);
		inputName.add(lblNewLabel_2);
		
		add = new JPanel();
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chuyen();
				
			}
		});
		add.setLayout(null);
		add.setBackground(new Color(58, 58, 58));
		add.setBounds(0, 0, 480, 54);
		add(add);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(222, 5, 20, 43);
		add.add(lblNewLabel);
	}
	public void chuyen() {
		if(inputName.getLocation().x!=0) {
			inputName.setBounds(0, 0, 500, 54);
			add.setBounds(0, 0, 480, 54);
		}else {
			inputName.setBounds(600, 0, 500, 54);
			add.setBounds(0, 0, 480, 54);
		}
	}
}
