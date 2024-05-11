package GUI.ForCommunity.KhungHienThiCommunity;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import GUI.ForCommunity.ElementForCommunity.ElementForPost.ElementComment;

import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class FramePostFull extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfComment;
	private JTextArea textArea;

	private JLabel totalLabel;
	private int totalCount = 999;
	private int forVote = 0;
	private JLabel increase;
	private JLabel reduce;
	private ImageIcon scalesVoteUp = new ImageIcon(
			ImageIO.read(new File("asset//img//voteUp.png")).getScaledInstance(45, 45, Image.SCALE_SMOOTH));
	private ImageIcon scalesVoteDown = new ImageIcon(
			ImageIO.read(new File("asset//img//voteDown.png")).getScaledInstance(45, 45, Image.SCALE_SMOOTH));
	private ImageIcon scalesSelectVoteUp = new ImageIcon(
			ImageIO.read(new File("asset//img//selectVoteUp.png")).getScaledInstance(85, 130, Image.SCALE_SMOOTH));
	private ImageIcon scalesSelectVoteDown = new ImageIcon(
			ImageIO.read(new File("asset//img//selectVoteDown.png")).getScaledInstance(85, 130, Image.SCALE_SMOOTH));
	private JLabel avatar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panelComment;
	private JPanel seeMore;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FramePostFull frame = new FramePostFull();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FramePostFull() throws IOException, BadLocationException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 859);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//        PaneMiniPost miniPost = new PaneMiniPost();
//        miniPost.setBounds(10, 10, 980, 330); 
//        contentPane.add(miniPost); 

//        miniPost.hideFullCommentLabel();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(212, 212, 212));
		panel.setBounds(0, 317, 974, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		BufferedImage myIconU = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconU = myIconU.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		ImageIcon scalesU = new ImageIcon(imgIconU);
		JLabel lblNewLabel = new JLabel(scalesU);
		lblNewLabel.setBounds(10, 7, 41, 40);
		panel.add(lblNewLabel);

		tfComment = new JTextField();
		tfComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfComment.setBounds(55, 10, 854, 35);
		panel.add(tfComment);
		tfComment.setColumns(10);
		
		tfComment.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            sentComment();
		        } catch (IOException | BadLocationException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		
		BufferedImage myIconSent = ImageIO.read(new File("asset//img//sentCmt.png"));
		Image imgIconSent = myIconSent.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scalesSent = new ImageIcon(imgIconSent);
		lblNewLabel_4 = new JLabel(scalesSent);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					sentComment();
				} catch (IOException | BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		lblNewLabel_4.setBounds(909, 3, 46, 45);
		panel.add(lblNewLabel_4);
		setResizable(false);
		JPanel panelUserPost = new JPanel();
		panelUserPost.setBounds(0, 0, 972, 45);
		contentPane.add(panelUserPost);
		panelUserPost.setLayout(null);

		BufferedImage myIconAvt = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAvt = myIconAvt.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		ImageIcon scalesAvt = new ImageIcon(imgIconAvt);
		avatar = new JLabel(scalesAvt);
		avatar.setBounds(10, 0, 45, 45);
		panelUserPost.add(avatar);

		lblNewLabel_1 = new JLabel("Trần Đức Hoàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(68, 6, 203, 21);
		panelUserPost.add(lblNewLabel_1);

		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDateTime = formatter.format(currentDate);
		lblNewLabel_2 = new JLabel(formattedDateTime);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(68, 28, 159, 14);
		panelUserPost.add(lblNewLabel_2);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(420, 9, 548, 28);
		panelUserPost.add(panel_1);

		lblNewLabel_3 = new JLabel("NHẬT KÍ HÓA HỌC CỦA CÓC - DAY 1");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 19));
		panel_1.add(lblNewLabel_3);

		JPanel mainContent = new JPanel();
		mainContent.setBackground(new Color(170, 170, 170));
		mainContent.setLayout(null);
		mainContent.setBounds(0, 48, 980, 270);
		contentPane.add(mainContent);

		totalLabel = new JLabel("999");
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalLabel.setBounds(65, 219, 45, 46);
		mainContent.add(totalLabel);

		increase = new JLabel(scalesVoteUp);
		increase.setBounds(10, 219, 45, 45);
		mainContent.add(increase);

		reduce = new JLabel(scalesVoteDown);
		reduce.setBounds(123, 220, 45, 45);
		mainContent.add(reduce);

		reduce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				reduceTotal();
			}
		});

		increase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				increaseTotal();
			}
		});

		JTextPane textPane = new JTextPane();
		textPane.setText(
				"TÔI ĐÃ TR.ẦY TR.ẬT VÌ TIẾNG ANH VÀ ĐÂY CÁC TIP TỰ HỌC CỦA TÔI - MỘT ÔNG DEV QUÈN MẤT GỐC 👓\r\n______\r\nAi biết hay giỏi cái gì thì cũng đi từ không biết mà lên. Tui cũng zậy nhưng được cái chịu khó nên tiếng Anh giờ cũng đủ xài nên share lại cho anh em vài tip xương m.áu, mong là giúp ích cho anh em được tí\n   #1: HỌC CĂN BẢN 📝\r\nMất gốc thì học lại gốc chứ sao giờ đúng ko :)) Phần đông các bạn khổ sở với tiếng Anh ở Đại học là vì các bạn mất căn bản từ khi còn là học sinh.\n#2: ĐỪNG ĐỂ TIẾNG ANH THÀNH NIỀM Đ.AU 😩\r\nNgoài học chủ động thì tui cũng để mình tiếp xúc bị động với tiếng Anh nhiều hơn");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPane.setEditable(false);
		textPane.setBounds(0, 3, 978, 213);
		mainContent.add(textPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 374, 976, 454);
		getContentPane().add(scrollPane);
		
		panelComment = new JPanel();
		
		BoxLayout boxLayout = new BoxLayout(panelComment, BoxLayout.Y_AXIS);
		panelComment.setLayout(boxLayout);
		scrollPane.setViewportView(panelComment);

		

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
		
		
		for (int i = 0; i <3 ; i++) {
			if (i == 10) {
				panelComment.add(seeMore);
				break;
			}
			ElementComment minipost = new ElementComment("Để tính toán số hàng cần thiết để hiển thị đoạn văn bản trên JTextPane và điều chỉnh chiều cao của nó, bạn có thể sử dụng FontMetrics để lấy thông tin về kích thước của font và tính toán số hàng dựa trên độ dài của đoạn văn bản và chiều rộng của JTextPane. Dưới đây là một ví dụ về cách làm điều này trong Java:");
			panelComment.add(minipost);
			Component rigidArea = Box.createRigidArea(new Dimension(0, 10));
			panelComment.add(rigidArea);
			

		}
//		Component rigidArea = Box.createRigidArea(new Dimension(0, 200));
//		panelComment.add(rigidArea,0);
//		panelComment.setBounds(0, 374, 976, 388);

//        JLabel send = new JLabel("");
//        send.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                String name = miniPost.getName();
//                String comment = tfComment.getText().trim();
//                if (!comment.isEmpty()) {
////                    miniPost.addComment(name + ": " + comment);
//                    tfComment.setText("");
//                }
//            }
//        });
//
//        send.setIcon(new ImageIcon("C:\\Java\\DACS-1\\send.png"));
//        send.setBounds(929, 10, 41, 35);
//        panel.add(send);
	}

	private void increaseTotal() {
		if (forVote == 0 || forVote == -1) {
			totalCount = (++totalCount) - forVote;
			totalLabel.setText(Integer.toString(totalCount));
			forVote = 1;
			increase.setIcon(scalesSelectVoteUp);
			reduce.setIcon(scalesVoteDown);
		} else {
			totalLabel.setText(Integer.toString(--totalCount));
			forVote = 0;
			increase.setIcon(scalesVoteUp);
		}
//		else if(forVote==1) {
//			totalCount++;
//			totalLabel.setText(Integer.toString(totalCount));
//			forVote = 0;
//		}

	}

	private void reduceTotal() {
//		if (totalCount > 0) {
//			totalCount--;
//			totalLabel.setText(Integer.toString(totalCount));
//			forVote = -1;
//		}
		if (forVote == 0 || forVote == 1) {
			totalCount = totalCount - 1 - forVote;
			totalLabel.setText(Integer.toString(totalCount));
			forVote = -1;
			increase.setIcon(scalesVoteUp);
			reduce.setIcon(scalesSelectVoteDown);
		} else {
			totalLabel.setText(Integer.toString(++totalCount));
			forVote = 0;
			reduce.setIcon(scalesVoteDown);
		}
	}
	private void seeMore() throws IOException, BadLocationException {

		panelComment.remove(seeMore);
		for (int i = 0; i < 2; i++) {
			ElementComment minipost = new ElementComment("\"Để tính toán số hàng cần thiết để hiển thị đoạn văn bản trên JTextPane và điều chỉnh chiều cao của nó, bạn có thể sử dụng FontMetrics để lấy thông tin về kích thước của font và tính toán số hàng dựa trên độ dài của đoạn văn bản và chiều rộng của JTextPane. Dưới đây là một ví dụ về cách làm điều này trong Java:\"");
			panelComment.add(minipost);
			Component rigidArea = Box.createRigidArea(new Dimension(0, 40));
			panelComment.add(rigidArea);
		}
		panelComment.add(seeMore);
	}

	private void sentComment() throws IOException, BadLocationException {
		String text = tfComment.getText().trim();
		if(!text.equals("")) {
			ElementComment cmt = new ElementComment(text);
			panelComment.add(cmt,0);
			Component rigidArea = Box.createRigidArea(new Dimension(0, 10));
			panelComment.add(rigidArea,1);
			tfComment.setText("");
		}
	}
}
