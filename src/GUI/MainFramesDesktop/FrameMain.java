package GUI.MainFramesDesktop;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import GUI.ForBangTuanHoan.KhungHienThiBangTuanHoan.PanelBangTuanHoan;
import GUI.ForHomePage.PaneHomePage;
import GUI.ForNotePage.KhungNotePage.FrameNote;
import GUI.ForTraCuuDanhPhap.KhungHienThiTCDP.PaneTraCuuDanhPhap;
import component.TextField;

//import CongDong.KhungGiaoDienHienThi_;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMain extends JFrame {

	private JPanel contentPane;
//	private JTextField tf;
	private Color mauChuDao = new Color(100, 149, 237);
	private JPanel mainPane;
	private PaneHomePage homePane = new PaneHomePage();
	private PanelBangTuanHoan paneBTH = new PanelBangTuanHoan();
//	private PaneTraCuuDanhPhap paneDP = new PaneTraCuuDanhPhap();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain frame = new FrameMain();
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
	 */
	public FrameMain() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(mauChuDao);
		panel.setBounds(0, 0, 1284, 65);
		contentPane.add(panel);
		panel.setLayout(null);

		BufferedImage myLogo = ImageIO.read(new File("asset//img//logoHoaHoc.png"));
		Image imgLogo = myLogo.getScaledInstance(90, 60, Image.SCALE_SMOOTH);
		ImageIcon scalesLoogo = new ImageIcon(imgLogo);
		JLabel lbLogo = new JLabel(scalesLoogo);
		lbLogo.setBounds(7, 3, 90, 60);
		panel.add(lbLogo);

		JLabel lbNameApp = new JLabel("Chem m\u00ED c\u1ED3");
		lbNameApp.setFont(new Font("Arial", Font.PLAIN, 29));
		lbNameApp.setBounds(107, 11, 184, 39);
		panel.add(lbNameApp);

		JPanel navBar = new JPanel();
		navBar.setBackground(mauChuDao);
		navBar.setBounds(301, -2, 419, 65);
		panel.add(navBar);
		navBar.setLayout(null);

		BufferedImage myIconHomePage = ImageIO.read(new File("asset//img//home.png"));
		Image imgIconHomePage = myIconHomePage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesHomePage = new ImageIcon(imgIconHomePage);
		JLabel lbHomePage = new JLabel(scalesHomePage);
		lbHomePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.remove(mainPane);
				mainPane = homePane;
				mainPane.setBounds(0, 76, 1285, 635);
				contentPane.add(mainPane);
				contentPane.revalidate();
				contentPane.repaint();

			}
		});
		lbHomePage.setBounds(10, 0, 65, 65);
		navBar.add(lbHomePage);

		BufferedImage myIconBTH = ImageIO.read(new File("asset//img//BTH.png"));
		Image imgIconBTH = myIconBTH.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesBTH = new ImageIcon(imgIconBTH);
		JLabel lbBTH = new JLabel(scalesBTH);
		lbBTH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.remove(mainPane);
				mainPane = paneBTH;
				mainPane.setBounds(0, 76, 1285, 635);
				contentPane.add(mainPane);
				contentPane.revalidate();
				contentPane.repaint();

			}
		});
		lbBTH.setBounds(85, 0, 65, 65);
		navBar.add(lbBTH);

		BufferedImage myIconDP = ImageIO.read(new File("asset//img//danhphap.png"));
		Image imgIconDP = myIconDP.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesDP = new ImageIcon(imgIconDP);
		JLabel lbDanhPhap = new JLabel(scalesDP);
		lbDanhPhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					contentPane.remove(mainPane);
					PaneTraCuuDanhPhap paneDP;
					paneDP = new PaneTraCuuDanhPhap();
					mainPane = paneDP;
					mainPane.setBounds(0, 76, 1285, 635);
					contentPane.add(mainPane);
					contentPane.revalidate();
					contentPane.repaint();
					paneDP.menuDP.donChat.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							contentPane.remove(mainPane);
							mainPane = paneBTH;
							mainPane.setBounds(0, 76, 1285, 635);
							contentPane.add(mainPane);
							contentPane.revalidate();
							contentPane.repaint();
					    }
					});
				} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		lbDanhPhap.setBounds(160, 0, 65, 65);
		navBar.add(lbDanhPhap);

		BufferedImage myIconCD = ImageIO.read(new File("asset//img//community.png"));
		Image imgIconCD = myIconCD.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesCD = new ImageIcon(imgIconCD);
		JLabel lbCongDong = new JLabel(scalesCD);
		lbCongDong.setBounds(235, 0, 65, 65);
		navBar.add(lbCongDong);

		BufferedImage myIconNote = ImageIO.read(new File("asset//img//note.png"));
		Image imgIconNote = myIconNote.getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		ImageIcon scalesNote = new ImageIcon(imgIconNote);
		JLabel lbCongDong_1 = new JLabel(scalesNote);
		lbCongDong_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FrameNote note = new FrameNote();
					note.setVisible(true);
					note.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		lbCongDong_1.setBounds(312, 1, 65, 65);
		navBar.add(lbCongDong_1);

		TextField tf = new TextField();
		tf = new TextField();
		tf.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf.setBackground(mauChuDao);
		tf.setBounds(769, 11, 235, 46);
		panel.add(tf);
		tf.setColumns(10);
//		tf.setBorder(new RoundBorder(40));

		BufferedImage myIconSearch = ImageIO.read(new File("asset//img//search.png"));
		Image imgIconSearch = myIconSearch.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scalesSearch = new ImageIcon(imgIconSearch);
		JLabel lbSearch = new JLabel(scalesSearch);
		lbSearch.setBounds(728, 19, 30, 30);
		panel.add(lbSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1045, 0, 239, 65);
		panel.add(panel_1);

		mainPane = new JPanel();
		mainPane.setBounds(0, 76, 1285, 635);
		mainPane.setLayout(null);
		mainPane.add(homePane);
		contentPane.add(mainPane);
	}

}