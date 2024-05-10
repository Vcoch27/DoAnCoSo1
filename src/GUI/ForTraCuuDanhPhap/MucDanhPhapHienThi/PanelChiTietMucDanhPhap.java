package GUI.ForTraCuuDanhPhap.MucDanhPhapHienThi;

import javax.swing.JPanel;

import GUI.ElementPublic.PanelHienThiListDanhPhap;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class PanelChiTietMucDanhPhap extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws MalformedURLException
	 */
	public PanelChiTietMucDanhPhap()
			throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		setBounds(0, 0, 1285, 588);
		setLayout(null);

		BufferedImage BufferIMGMucDP = ImageIO.read(new File("asset/img/ion2.jpg"));
		Image imgIMGMucDP = BufferIMGMucDP.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon scalesIMGMucDP = new ImageIcon(imgIMGMucDP);
		JLabel imgMinhHoa = new JLabel(scalesIMGMucDP);
		imgMinhHoa.setBounds(80, 11, 250, 250);
		add(imgMinhHoa);

		JPanel panel = new JPanel();
		panel.setBounds(388, 11, 834, 237);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EAn m\u1EE5c danh ph\u00E1p");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(342, 0, 187, 27);
		panel.add(lblNewLabel);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(23, 28, 788, 198);
		editorPane.setContentType("text/html");
		editorPane.setText("<html><body><h1>About muc noi dung</h1><p>Kieen thuc danh phap</p></body></html>");
		editorPane.setEditable(false);
		panel.add(editorPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(605, 277, 670, 300);
		panel_1.setLayout(null);
		PanelHienThiListDanhPhap listdp = new PanelHienThiListDanhPhap();
		listdp.setBounds(0, 0, 670, 300);
		panel_1.add(listdp);
		add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 277, 567, 300);
		add(panel_2);
		panel_2.setLayout(null);

		JEditorPane kienThuc = new JEditorPane();
		kienThuc.setEditable(false);  
		kienThuc.setBounds(0, 0, 567, 300);
		panel_2.add(kienThuc);
		try {
			kienThuc.setPage("https://chat.openai.com/c/ee925a40-fb42-47ff-9606-7ec276cc4b90");
		} catch (IOException e) {
			kienThuc.setContentType("text/html");
			kienThuc.setText("<html>Could not load</html>");
		}
	}
}
