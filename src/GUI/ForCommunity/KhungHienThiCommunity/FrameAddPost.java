package GUI.ForCommunity.KhungHienThiCommunity;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import component.TextField;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class FrameAddPost extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PaneSlideShow slideshow;
	private TextField textField;
	private JLabel countLabel;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaneSlideShow slideshow = new PaneSlideShow(); // Táº¡o má»™t Ä‘á»‘i tÆ°á»£ng SlidesShow
					FrameAddPost frame = new FrameAddPost(slideshow); // GÃ¡n SlidesShow cho AddPost
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor vá»›i tham sá»‘ kiá»ƒu SlidesShow
	public FrameAddPost(PaneSlideShow slideshow) throws IOException {
		// Thiáº¿t láº­p Ä‘á»‘i tÆ°á»£ng SlidesShow cho AddPost
		this.slideshow = slideshow;
		setResizable(false);

		// CÃ¡c pháº§n cÃ²n láº¡i cá»§a constructor
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 571);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 243, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel addPost = new JLabel("");
		addPost.setIcon(new ImageIcon("C:\\Java\\DACS-1\\add (1).png"));
		addPost.setBounds(688, 318, 38, 39);
		contentPane.add(addPost);

		BufferedImage myIconAvt = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAvt = myIconAvt.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		ImageIcon scalesAvt = new ImageIcon(imgIconAvt);
		JLabel avatar = new JLabel(scalesAvt);
		avatar.setBounds(9, 7, 42, 42);
		contentPane.add(avatar);

		JPanel panel = new JPanel();
		panel.setBounds(57, 11, 203, 29);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Trần Đức Hoàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel_1);

		textField = new TextField();
		textField.setBounds(526, 0, 534, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tiêu đề");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		lblNewLabel.setBounds(428, 7, 94, 29);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(243, 243, 243));
		panel_1.setBounds(339, 475, 597, 57);
		contentPane.add(panel_1);

		BufferedImage myAttach = ImageIO.read(new File("asset//img//attach.png"));
		Image imgAttach = myAttach.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon scalesAttach = new ImageIcon(imgAttach);
		JLabel avatar_1 = new JLabel(scalesAttach);
		avatar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		avatar_1.setBounds(946, 480, 45, 45);
		contentPane.add(avatar_1);

		Button btnNewButton = new Button("Đăng tải");
		btnNewButton.setForeground(new Color(64, 0, 0));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(174, 236, 249));
		btnNewButton.setBounds(999, 480, 89, 45);
		contentPane.add(btnNewButton);

		countLabel = new JLabel("Characters: 0");
		countLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		countLabel.setBounds(9, 492, 176, 29);
		contentPane.add(countLabel);

		 textArea = new JTextArea();
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setFont(new Font("Monospaced", Font.PLAIN, 22));
	        textArea.setText("Dương ơi, bạn đang suy nghĩ gì?");
	        textArea.setBounds(9, 60, 1079, 406);
		contentPane.add(textArea);
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateCounts();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateCounts();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateCounts();
			}
		});

		// Gáº¯n sá»± kiá»‡n cho addPost label
		addPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//                addNewEventToSlideshow();
			}
		});
		textArea.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textArea.getText().equals("Dương ơi, bạn đang suy nghĩ gì?")) {
					textArea.setText("");
					textArea.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textArea.getText().isEmpty()) {
					textArea.setForeground(Color.GRAY);
					textArea.setText("Dương ơi, bạn đang suy nghĩ gì?");
				}
			}
		});
	}

//	private int getLineCount(JTextArea textArea) {
//	    int lineHeight = 230;
//	    int totalHeight = textArea.getHeight();
//	    return totalHeight / lineHeight;
//	}
	private void updateCounts() {
        String text = textArea.getText();
        if (text.equals("Dương ơi, bạn đang suy nghĩ gì?")) {
            countLabel.setText("Characters: " + 0 );
            return;
        }

        int characterCount = text.length();
//        int lineCount = getLineCount(textArea);
        countLabel.setText("Characters: " + characterCount );
    }
}
