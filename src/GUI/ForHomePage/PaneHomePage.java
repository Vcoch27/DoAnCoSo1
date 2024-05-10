package GUI.ForHomePage;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;

public class PaneHomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public PaneHomePage() {
		setLayout(null);
		setBounds(0, 0, 1285, 635);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 233, 233));
		panel.setBounds(0, 0, 1285, 250);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 248, 1285, 387);
		add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane.setText("	Trong bối cảnh chương trình giáo dục phổ thông mới với sự tập trung cao hơn vào bản chất của hóa học và áp dụng các chuẩn danh pháp quốc tế IUPAC, chúng tôi nhận thấy cần thiết phải phát triển một ứng dụng giúp học sinh tiếp cận môn học một cách hiệu quả hơn.\r\n"
				+ "	Ứng dụng desktop này được thiết kế đặc biệt để hỗ trợ học sinh cấp THCS – THPT trong việc học hóa học. Giao diện của ứng dụng được tối ưu hóa để dễ dàng tiếp cận cho học sinh. Các tính năng chính bao gồm:\r\n"
				+ "•	Tra Cứu Thông Tin: Hỗ trợ tra cứu thông tin về nguyên tố hóa học và hợp chất hóa học, cung cấp thông tin thực tế và ứng dụng của chúng trong cuộc sống hàng ngày của chi tiết các nội dung thuộc nhóm nguyên tố, hợp chất với vô cơ, hữu cơ,...\r\n"
				+ "•	Danh Pháp Hóa Học Đúng Chuẩn: Tích hợp danh pháp hóa học theo chuẩn quốc tế IUPAC, kèm theo phiên âm IPA và âm thanh tương ứng để giúp học sinh học và phát âm chính xác.\r\n"
				+ "•	Sổ Tay Cá Nhân: Cho phép học sinh tạo và quản lý sổ tay cá nhân để ghi chú, lưu trữ những kiến thức quan trọng bao gồm nội dung ghi chú và các thẻ danh pháp – lí thuyết được thêm và hiện thị trong sổ tay và cho phép chia sẽ chung lên diễn đàn tương ứng.\r\n"
				+ "•	Flash Card: Sử dụng phương pháp học Flash Card để tăng cường hiệu quả học tập, giúp học sinh nhớ kiến thức một cách nhanh chóng và hiệu quả.\r\n"
				+ "•	Diễn Đàn Thảo Luận: Xây dựng một diễn đàn để mọi người có thể chia sẻ kiến thức, trao đổi kinh nghiệm và thảo luận về các vấn đề liên quan đến hóa học thông các bài viết mà người dung đăng tải.\r\n"
				+ "•	Tra cứu thông tin: Dựa vào nguồn tài nguyên của ứng dụng, xây dựng một hệ thống tra cứu thông tin, dữ liệu một cách logic và hiệu quả.\r\n"
			);
		textPane.setBounds(41, 29, 659, 312);
		panel_1.add(textPane);

	}
}
