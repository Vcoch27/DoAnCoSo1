package moduleSQL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.sql.*;

public class PlayAudioFromDatabase extends JFrame {

	private JButton playButtonUS;
	private JButton playButtonUK;
	private Connection conn;
	private PreparedStatement stmt;
	private byte[] audioUSData;
	private byte[] audioUKData;

	public PlayAudioFromDatabase() {
		super("Phát âm thanh từ MySQL");

		// Kết nối đến cơ sở dữ liệu
		String url = "jdbc:mysql://localhost:3306/Librarian"; // Thay đổi thành URL của cơ sở dữ liệu MySQL của bạn
		String username = "root"; // Thay đổi thành username của cơ sở dữ liệu MySQL của bạn
		String password = "PHW#84#jeor"; // Thay đổi thành password của cơ sở dữ liệu MySQL của bạn
//        String password = "Hoang2711#";
		String kihieuhoahoc = "H"; // Thay thế bằng IDDanhPhap cụ thể
		String lenh = "SELECT AudioUS, AudioUK FROM easychemistry.danhphap WHERE KiHieuHoaHoc = ?";
		try {

			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.prepareStatement(lenh);
			stmt.setString(1, kihieuhoahoc);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				audioUSData = rs.getBytes("AudioUS");
				audioUKData = rs.getBytes("AudioUK");
			} else {
				System.out.println("Không tìm thấy danh pháp: " + kihieuhoahoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Thiết lập giao diện Swing
		playButtonUS = new JButton("Phát Audio US");
		playButtonUK = new JButton("Phát Audio UK");

		playButtonUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAudio(audioUSData);
			}
		});

		playButtonUK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAudio(audioUKData);
			}
		});

		JPanel panel = new JPanel();
		panel.add(playButtonUS);
		panel.add(playButtonUK);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Phát âm thanh từ mảng byte
	public void playAudio(byte[] audioData) {
		try {
			// Tạo AudioFormat với các thông số phù hợp
			AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, // Sample rate
					11, // Sample size in bits
					2, // Channels (2 for stereo)
					4, // Frame size (4 bytes/frame for 16-bit stereo)
					44100, // Frame rate
					false); // Big-endian (false for little-endian)

			// Tạo AudioInputStream từ mảng byte và AudioFormat
			AudioInputStream audioInputStream = new AudioInputStream(new ByteArrayInputStream(audioData), format,
					audioData.length / format.getFrameSize());

			// Tạo Clip để phát âm thanh
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Thiết lập tốc độ phát lại của clip
			float playbackRate = 0.1f; // Thay đổi giá trị này để thay đổi tốc độ phát
			clip.setFramePosition((int) (clip.getFrameLength() * playbackRate));

			// Bắt đầu phát âm thanh
			clip.start();

			// Đợi cho đến khi âm thanh phát xong
			clip.drain();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PlayAudioFromDatabase();
			}
		});
	}
}
