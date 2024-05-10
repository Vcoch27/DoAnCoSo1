package GUI.ForCommunity.KhungHienThiCommunity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.BadLocationException;

import GUI.ForCommunity.ElementForCommunity.ElementForPost.ElementComment;
import component.ButtonGradient;

import javax.swing.JTextPane;

public class PaneMiniPost extends JPanel {
	private int totalCount = 999;
	private JLabel totalLabel;
	private static final int WIDTH = 980;
	private static final int HEIGHT = 365;

	private ImageIcon scalesVoteUp = new ImageIcon(
			ImageIO.read(new File("asset//img//voteUp.png")).getScaledInstance(45, 45, Image.SCALE_SMOOTH));
	private ImageIcon scalesVoteDown = new ImageIcon(
			ImageIO.read(new File("asset//img//voteDown.png")).getScaledInstance(45, 45, Image.SCALE_SMOOTH));
	private ImageIcon scalesSelectVoteUp = new ImageIcon(
			ImageIO.read(new File("asset//img//selectVoteUp.png")).getScaledInstance(85, 130, Image.SCALE_SMOOTH));
	private ImageIcon scalesSelectVoteDown = new ImageIcon(
			ImageIO.read(new File("asset//img//selectVoteDown.png")).getScaledInstance(85, 130, Image.SCALE_SMOOTH));
	private int forVote = 0;
	private JLabel increase;
	private JLabel reduce;

	/**
	 * Create the panel.
	 */
	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws BadLocationException
	 */
	public PaneMiniPost() throws IOException, BadLocationException {
		setBackground(new Color(255, 206, 206));
//		setBounds(0, 0, WIDTH, HEIGHT);
//		setPreferredSize(new Dimension(980, 406));
		
		setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setLayout(null);

		JPanel mainContent = new JPanel();
		mainContent.setBounds(0, 50, 980, 265);
		add(mainContent);
		mainContent.setLayout(null);

		totalLabel = new JLabel("999");
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalLabel.setBounds(73, 219, 45, 46);
		mainContent.add(totalLabel);
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);

		increase = new JLabel(scalesVoteUp);
		increase.setBounds(10, 219, 45, 45);
		mainContent.add(increase);

		reduce = new JLabel(scalesVoteDown);
		reduce.setBounds(128, 219, 45, 45);
		mainContent.add(reduce);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPane.setText(
				"TÔI ĐÃ TR.ẦY TR.ẬT VÌ TIẾNG ANH VÀ ĐÂY CÁC TIP TỰ HỌC CỦA TÔI - MỘT ÔNG DEV QUÈN MẤT GỐC 👓\r\n"
						+ "______\r\n"
						+ "Ai biết hay giỏi cái gì thì cũng đi từ không biết mà lên. Tui cũng zậy nhưng được cái chịu khó nên tiếng Anh giờ cũng đủ xài nên share lại cho anh em vài tip xương m.áu, mong là giúp ích cho anh em được tí"
						+ "\n   #1: HỌC CĂN BẢN 📝\r\n"
						+ "Mất gốc thì học lại gốc chứ sao giờ đúng ko :)) Phần đông các bạn khổ sở với tiếng Anh ở Đại học là vì các bạn mất căn bản từ khi còn là học sinh."
						+ "\n#2: ĐỪNG ĐỂ TIẾNG ANH THÀNH NIỀM Đ.AU 😩\r\n"
						+ "Ngoài học chủ động thì tui cũng để mình tiếp xúc bị động với tiếng Anh nhiều hơn");
		textPane.setBounds(0, 3, 978, 213);
		mainContent.add(textPane);

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

		JPanel comment = new JPanel();
		ElementComment eComment = new ElementComment("Để tính toán số hàng cần thiết để hiển thị đoạn văn bản trên JTextPane và điều chỉnh chiều cao của nó, bạn có thể sử dụng FontMetrics để lấy thông tin về kích thước của font và tính toán số hàng dựa trên độ dài của đoạn văn bản và chiều rộng của JTextPane. Dưới đây là một ví dụ về cách làm điều này trong Java:");
		int cao = eComment.getSize().height;
		eComment.setBounds(0, 0, 815, cao);
		comment.setBounds(2, 315, 815, cao);
		comment.setLayout(null);
		comment.add(eComment);
		setPreferredSize(new Dimension(WIDTH, (HEIGHT +cao-46)));
		add(comment);

		BufferedImage myIconAvt = ImageIO.read(new File("asset//img//account.png"));
		Image imgIconAvt = myIconAvt.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		ImageIcon scalesAvt = new ImageIcon(imgIconAvt);
		JLabel avatar = new JLabel(scalesAvt);
		avatar.setBounds(22, 4, 45, 45);
		add(avatar);

		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDateTime = formatter.format(currentDate);

		System.out.println("Thời gian: " + formattedDateTime);
		JLabel lblNewLabel = new JLabel(formattedDateTime);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(80, 32, 159, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Trần Đức Hoàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(80, 10, 203, 21);
		add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 206, 206));
		panel.setBounds(432, 13, 548, 28);
		add(panel);

		JLabel lblNewLabel_2 = new JLabel("NHẬT KÍ HÓA HỌC CỦA CÓC - DAY 1");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 19));

		ButtonGradient btnNewButton = new ButtonGradient();
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FramePostFull fullPost = new FramePostFull();
					fullPost.setVisible(true);
					fullPost.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (IOException | BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setText("Xem chi tiết");
		btnNewButton.setBounds(817, 326+cao-46, 160, 31);
		add(btnNewButton);
		

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

//    public void hideFullCommentLabel() {
//        lblFullComment.setVisible(false);
//    }
//
//	public void addComment(String comment) {
//		comMent.setText(comment);
//	}

	public String getName() {
		return "HAHA"; // Return the name from your data source here
	}
}
