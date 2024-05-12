package GUI.ForNotePage.KhungNotePage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import GUI.ElementPublic.ElementListNote;
import GUI.ForCommunity.KhungHienThiCommunity.FrameAddPost;

public class FrameChoiceFileToSave extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameChoiceFileToSave frame = new FrameChoiceFileToSave();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	//chọn file để đăng tải :true
	//chọn file để thêm danh pháp :false
	public FrameChoiceFileToSave(boolean tinHieu, FrameAddPost frame) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(690, 150, 500, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		JPanel listNotePane = new JPanel();
		listNotePane.setBorder(new LineBorder(new Color(0, 0, 0)));
		listNotePane.setBackground(new Color(0, 255, 255));
		listNotePane.setBounds(0, 0, 484, 596);
		contentPane.add(listNotePane);
		listNotePane.setLayout(null);

		JScrollPane scrollPaneList = new JScrollPane();
		scrollPaneList.setBounds(0, 40, 484, 556);
		listNotePane.add(scrollPaneList);

		JPanel areaList = new JPanel();
		areaList.setBackground(new Color(192, 192, 192));
		BoxLayout boxlayout = new BoxLayout(areaList, BoxLayout.Y_AXIS);
		areaList.setLayout(boxlayout);

		scrollPaneList.setViewportView(areaList);
		
		scrollPaneList.setViewportView(areaList);
		for (int i = 0; i < 10; i++) {
			ElementListNote el = new ElementListNote();
			el.setMaximumSize(new Dimension(Integer.MAX_VALUE, el.getPreferredSize().height));
			areaList.add(el);
			el.lbChoice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(tinHieu) {
						try {
							frame.addFileNote("1");
							setVisible(false);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						System.out.println("thêm danh pháp vào file");
					}
				}
			});

			Component rigidArea = Box.createRigidArea(new Dimension(0, 10));
			areaList.add(rigidArea);
		}
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
