package GUI.ElementPublic;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import Controller.ControlDanhPhap.ForNguyenTo;
import GUI.ForNotePage.KhungNotePage.FrameChoiceFileToSave;
import Model.ElementDanhPhapHoaHoc;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.Icon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElementDanhPhap extends JPanel {

	private static final int WIDTH = 650;
	private static final int HEIGHT = 70;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws MalformedURLException
	 * @throws LineUnavailableException
	 */
	public ElementDanhPhap(ElementDanhPhapHoaHoc eDP)
			throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		setBackground(new Color(192, 192, 192));
		

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLayout(null);

//		File fileAudioUS = new File("asset/audio/hidrouk.wav");
//		AudioInputStream audioIn = AudioSystem.getAudioInputStream(fileAudioUS.toURI().toURL());
//		Clip clip = AudioSystem.getClip();
//		clip.open(audioIn);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1.setBounds(190, 5, 190, 33);
		add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel apiUK = new JLabel("UK  "+eDP.getIpaUK()+"");
		apiUK.setBounds(4, 5, 186, 23);
		apiUK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1_1.add(apiUK);
		
		BufferedImage BufferAudioNT = ImageIO.read(new File("asset//img//audio.png"));
		Image imgAudioNT = BufferAudioNT.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		ImageIcon scalesAudioNT = new ImageIcon(imgAudioNT);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1_1.setBounds(405, 7, 190, 33);
		add(panel_1_1_1);
		
		JLabel apiUS = new JLabel("UK  "+eDP.getIpaUS());
		apiUS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		apiUS.setBounds(4, 5, 186, 23);
		panel_1_1_1.add(apiUS);
		
		JLabel lblNewLabel = new JLabel("<html>\r\n"
				+ "<body style=\"margin: 0; padding: 0;\">\r\n"
				+ "    <p 0>"+eDP.getDanhPhapCu()+"</p>\r\n"
				+ "    <h3 >"+eDP.getIdDanhPhap()+" - "+eDP.getKiHieu()+"</h3>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		lblNewLabel.setBounds(10, 0, 169, 70);
		add(lblNewLabel);
		
		BufferedImage BufferAdd = ImageIO.read(new File("asset//img//add.png"));
		Image imgAdd = BufferAdd.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon scalesAdd = new ImageIcon(imgAdd);
		JLabel lblNewLabel_1 = new JLabel(scalesAdd);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FrameChoiceFileToSave fcfts = new FrameChoiceFileToSave(false,null);
					fcfts.setVisible(true);
					fcfts.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_1.setBounds(611, 18, 32, 32);
		add(lblNewLabel_1);
		JLabel soundUK = new JLabel(scalesAudioNT);
		soundUK.setBounds(347, 35, 33, 33);
		add(soundUK);
		
		JLabel soundUS = new JLabel(scalesAudioNT);
		soundUS.setBounds(569, 36, 33, 33);
		add(soundUS);
		soundUS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForNguyenTo.playAudio(eDP.getAudioUS());
			}
		});
		soundUK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForNguyenTo.playAudio(eDP.getAudioUK());
			}
		});
	}
}
