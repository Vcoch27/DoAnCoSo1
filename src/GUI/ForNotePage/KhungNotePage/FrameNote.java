package GUI.ForNotePage.KhungNotePage;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import GUI.ElementPublic.ElementDanhPhap;
import GUI.ElementPublic.ElementListNote;
import GUI.ElementPublic.PanelHienThiListDanhPhap;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

public class FrameNote extends JFrame {

	private JPanel contentPane;
	boolean isExpanded = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameNote frame = new FrameNote();
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
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws MalformedURLException
	 */
	public FrameNote()
			throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(690, 150, 500, 635);
//		setBounds(100, 150, 1285, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel listNotePane = new JPanel();
		listNotePane.setBorder(new LineBorder(new Color(0, 0, 0)));
		listNotePane.setBackground(new Color(0, 255, 255));
		listNotePane.setBounds(0, 0, 484, 596);
		contentPane.add(listNotePane);
		listNotePane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 484, 40);
		listNotePane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Note ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setBounds(31, 7, 92, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel_2.add(lblNewLabel);
		System.out.println("X: " + getLocation().x);

		JScrollPane scrollPaneList = new JScrollPane();
		scrollPaneList.setBounds(0, 40, 484, 556);
		listNotePane.add(scrollPaneList);

		JPanel areaList = new JPanel();
		areaList.setBackground(new Color(192, 192, 192));
		BoxLayout boxlayout = new BoxLayout(areaList, BoxLayout.Y_AXIS);
		areaList.setLayout(boxlayout);

		scrollPaneList.setViewportView(areaList);
		for (int i = 0; i < 3; i++) {
			ElementListNote el = new ElementListNote();
			el.setMaximumSize(new Dimension(Integer.MAX_VALUE, el.getPreferredSize().height));
			areaList.add(el);
			el.lbOpenNote.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openDetailNote();
				}
			});

			Component rigidArea = Box.createRigidArea(new Dimension(0, 10));
			areaList.add(rigidArea);
		}

		PaneNewNote addCard = new PaneNewNote();
		addCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, addCard.getPreferredSize().height));
		areaList.add(addCard);
		addCard.enterName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!addCard.enterName.getText().equals("")) {
					try {
	                    ElementListNote newNote = new ElementListNote();
	                    newNote.setMaximumSize(new Dimension(Integer.MAX_VALUE, newNote.getPreferredSize().height));
	                    int addCardIndex = areaList.getComponentZOrder(addCard);
	                    areaList.add(newNote, addCardIndex);
	                    Component rigidArea = Box.createRigidArea(new Dimension(0, 10));
	        			areaList.add(rigidArea,++addCardIndex);
	                    areaList.revalidate();
	                    areaList.repaint();
	                    newNote.lbOpenNote.addMouseListener(new MouseAdapter() {
	        				@Override
	        				public void mouseClicked(MouseEvent e) {
	        					openDetailNote();
	        				}
	        			});

	                    System.out.println(addCard.enterName.getText());
	                    addCard.chuyen();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});

		JPanel contentListPane = new JPanel();
		contentListPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentListPane.setBounds(494, 40, 770, 556);
		contentPane.add(contentListPane);
		contentListPane.setLayout(null);
		
		PaneContentList paneContentList = new PaneContentList();
		paneContentList.setBounds(0, 0, 770, 556);
		contentListPane.add(paneContentList);
		
		

		BufferedImage bufferBack = ImageIO.read(new File("asset//img//back.png"));
		Image imgBack = bufferBack.getScaledInstance(33, 33, Image.SCALE_SMOOTH);
		ImageIcon scalesIconBack = new ImageIcon(imgBack);
		JLabel lbBack = new JLabel(scalesIconBack);
		lbBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeDetailNote();
			}
		});
		lbBack.setBounds(490,8, 33, 33);
		contentPane.add(lbBack);
		
		BufferedImage bufferSave = ImageIO.read(new File("asset//img//save.png"));
		Image imgSave = bufferSave.getScaledInstance(33, 33, Image.SCALE_SMOOTH);
		ImageIcon scalesIconSave = new ImageIcon(imgSave);
		JLabel save = new JLabel(scalesIconSave);
		save.setBounds(1129, 0, 33, 33);
		contentPane.add(save);
		
		BufferedImage bufferLeft = ImageIO.read(new File("asset//img//left.png"));
		Image imgeleft = bufferLeft.getScaledInstance(33, 33, Image.SCALE_SMOOTH);
		ImageIcon scalesIconLeft = new ImageIcon(imgeleft);
		JLabel left = new JLabel(scalesIconLeft);
		left.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneContentList.undo();
			}
		});
		left.setBounds(1172, 0, 33, 33);
		contentPane.add(left);
		
		BufferedImage bufferright = ImageIO.read(new File("asset//img//right.png"));
		Image imgeright = bufferright.getScaledInstance(33, 33, Image.SCALE_SMOOTH);
		ImageIcon scalesIconright = new ImageIcon(imgeright);
		JLabel right = new JLabel(scalesIconright);
		right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneContentList.endo();
			}
		});
		right.setBounds(1215, 0, 33, 33);
		contentPane.add(right);
		
		
	}

	int xMini = 690;
	int widthMini = 500;
	int xDetail = 350;
	int widthDetail = 1285;

	int stepX = (xMini - xDetail) / 80;
	int stepWidth = (widthDetail - widthMini) / 80;

	private void closeDetailNote() {
		int currentY = getLocation().y;

		int currentHeight = getSize().height;
		Timer timer = new Timer(5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int currentX = getLocation().x;

				int currentWidth = getSize().width;
				if (currentX >= xMini && currentWidth <= widthMini) {
					((Timer) e.getSource()).stop();
					System.out.println("okee");

					isExpanded = !isExpanded;
				} else {

					System.out.println("-->");
					if (currentX < xMini) {
						currentX += stepX;
					}
					if (currentWidth > widthMini) {
						currentWidth -= stepWidth;
					}
					setBounds(currentX, currentY, currentWidth, currentHeight);

				}

			}
		});
		timer.start();
	}

	private void openDetailNote() {

		int currentY = getLocation().y;

		int currentHeight = getSize().height;
		Timer timer = new Timer(5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int currentX = getLocation().x;

				int currentWidth = getSize().width;
				System.out.println(isExpanded);
				if (currentX <= xDetail && currentWidth >= widthDetail) {
					((Timer) e.getSource()).stop();
					isExpanded = !isExpanded;
					System.out.println("keo");
					System.out.println("---------------------");
				} else {
					System.out.println("<--");
					if (currentX > xDetail) {
						currentX -= stepX;
					}
					if (currentWidth < widthDetail) {
						currentWidth += stepWidth;
					}
					setBounds(currentX, currentY, currentWidth, currentHeight);
				}

			}
		});
		timer.start();
	}
}
