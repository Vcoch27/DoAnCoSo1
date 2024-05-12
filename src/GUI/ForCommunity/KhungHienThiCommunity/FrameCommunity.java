package GUI.ForCommunity.KhungHienThiCommunity;

import org.json.simple.JSONObject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

public class FrameCommunity extends JFrame {

	private JPanel contentPane;
	private JPanel panelForSurf;
	private JPanel seeMore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCommunity frame = new FrameCommunity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws BadLocationException
	 */
	public FrameCommunity() throws IOException, BadLocationException {
		setBackground(new Color(255, 255, 255));
		setBounds(250, 150, 1285, 692);
		getContentPane().setLayout(null);
		setResizable(false);
		JPanel paneForMini = new JPanel();
		paneForMini.setBounds(0, 52, 1269, 220);
		getContentPane().add(paneForMini);
		paneForMini.setLayout(null);
		PaneSlideShow slideShow = new PaneSlideShow();
		slideShow.setBounds(0, 0, 1269, 220);
		paneForMini.add(slideShow);

//	JScrollPane scrollPane = new JScrollPane();
//	scrollPane.setBounds(0, 271, 1269, 382);
//	getContentPane().add(scrollPane);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 272, 1000, 381);
		getContentPane().add(scrollPane);

		panelForSurf = new JPanel();

		BoxLayout boxLayout = new BoxLayout(panelForSurf, BoxLayout.Y_AXIS);
		panelForSurf.setLayout(boxLayout);
		scrollPane.setViewportView(panelForSurf);

		seeMore = new JPanel();
		seeMore.setPreferredSize(new Dimension(980, 49));
		seeMore.setLayout(null);
		seeMore.setBackground(new Color(255, 0, 255));
		BufferedImage myMore = ImageIO.read(new File("asset//img//downToSeeMore.png"));
		Image imgMore = myMore.getScaledInstance(80, 45, Image.SCALE_SMOOTH);
		ImageIcon scalesMore = new ImageIcon(imgMore);
		JLabel lbforSeeMore = new JLabel(scalesMore);
		seeMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					seeMore();
				} catch (IOException | BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lbforSeeMore.setBounds(450, 2, 80, 45);
		seeMore.add(lbforSeeMore);
		
		
		for (int i = 0; i < 3; i++) {
			PaneMiniPost minipost = new PaneMiniPost();
			panelForSurf.add(minipost);
			Component rigidArea = Box.createRigidArea(new Dimension(0, 40));
			panelForSurf.add(rigidArea);

		}
		panelForSurf.add(seeMore);
//		panelForSurf.remove(seeMore);
//		PaneMiniPost minipost = new PaneMiniPost();
//		panelForSurf.add(minipost);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1285, 52);
		panel_1.setBackground(new Color(216, 216, 216));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		BufferedImage myAdd = ImageIO.read(new File("asset//img//newpost.png"));
		Image imgAdd = myAdd.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scalesAdd = new ImageIcon(imgAdd);
		JLabel add_post = new JLabel(scalesAdd);
		add_post.setBounds(1216, 7, 40, 40);
		panel_1.add(add_post);
		add_post.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				FrameAddPost addPostFrame;
				try {
					addPostFrame = new FrameAddPost(slideShow);
					addPostFrame.setVisible(true);
					addPostFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		JLabel toppost = new JLabel("CỘNG ĐỒNG HÓA HỌC");
		toppost.setBounds(90, 7, 250, 35);
		panel_1.add(toppost);
		toppost.setVerticalAlignment(SwingConstants.BOTTOM);
		toppost.setFont(new Font("Tahoma", Font.PLAIN, 22));
	}

	private void seeMore() throws IOException, BadLocationException {

		panelForSurf.remove(seeMore);
		for (int i = 0; i < 2; i++) {
			PaneMiniPost minipost = new PaneMiniPost();
			panelForSurf.add(minipost);
			Component rigidArea = Box.createRigidArea(new Dimension(0, 40));
			panelForSurf.add(rigidArea);
		}
		panelForSurf.add(seeMore);
	}

}
