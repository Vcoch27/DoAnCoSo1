package GUI.ElementPublic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileOutputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer extends JFrame {

    private JButton playButton;

    public AudioPlayer() {
        // Thiết lập giao diện JFrame
        setTitle("Audio Player");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo nút phát âm thanh
        playButton = new JButton("Play Audio");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAudioFromDatabase("H");
            }
        });

        // Thêm nút vào JFrame
        setLayout(new BorderLayout());
        add(playButton, BorderLayout.CENTER);
    }

    private void playAudioFromDatabase(String kiHieuHoaHoc) {
        String url = "jdbc:mysql://localhost:3306/Librarian";
        String user = "root";
        String password = "PHW#84#jeor";
        String query = "SELECT AudioUK, IPAUS FROM easychemistry.danhphap WHERE KiHieuHoaHoc = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Thiết lập giá trị của KiHieuHoaHoc
            stmt.setString(1, kiHieuHoaHoc);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    byte[] audioBytes = rs.getBytes("AudioUK");
                    System.out.println(rs.getString("IPAUS"));
                    playAudio(audioBytes);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playAudio(byte[] audioBytes) {
        try {
            // Tạo tệp âm thanh tạm thời
            File tempFile = File.createTempFile("audio", ".wav");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(audioBytes);
            }

            // Phát tệp âm thanh
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(tempFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // Đợi cho đến khi âm thanh kết thúc
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);

            // Đóng và xóa tệp tạm thời sau khi phát xong
            clip.close();
            tempFile.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Chạy chương trình
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AudioPlayer().setVisible(true);
            }
        });
    }
}
