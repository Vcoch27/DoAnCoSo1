package moduleSQL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddAudioToDanhPhapTable {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Librarian"; // Replace with your MySQL database URL
        String username = "root"; // Replace with your MySQL username
        String password = "PHW#84#jeor"; // Replace with your MySQL password

        Scanner sc = new Scanner(System.in);
        //-----------------------------------
        System.out.println("Nhập kí hiệu hóa học:");
        String kihieuhoahoc = sc.nextLine();

        System.out.println("Nhập đường dẫn đến file âm thanh US:");
        String filePathUS = sc.nextLine(); // Đường dẫn đến file âm thanh US

        System.out.println("Nhập đường dẫn đến file âm thanh UK:");
        String filePathUK = sc.nextLine(); // Đường dẫn đến file âm thanh UK

        // Adding audio files to the database
        addAudioToDatabase(url, username, password, kihieuhoahoc, filePathUS, filePathUK);
        
        
        
        //--------------------
        //Hủy comment và comment input line 22 đến 32 để phát dữ liệu
//        retrieveAudioFromDatabase(url, username, password, kihieuhoahoc);

        // Close resources
        sc.close();
    }

    public static void addAudioToDatabase(String url, String username, String password,
                                          String kihieuhoahoc, String filePathUS, String filePathUK) {
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE easychemistry.danhphap SET AudioUS = ?, AudioUK = ? WHERE KiHieuHoaHoc = ?"
                );
                FileInputStream fisUS = new FileInputStream(filePathUS);
                FileInputStream fisUK = new FileInputStream(filePathUK)
        ) {
            // Read all bytes from the audio files
            byte[] audioUSData = fisUS.readAllBytes();
            byte[] audioUKData = fisUK.readAllBytes();

            // Setting the byte arrays into the prepared statement
            stmt.setBytes(1, audioUSData);
            stmt.setBytes(2, audioUKData);
            stmt.setString(3, kihieuhoahoc);

            // Executing the update
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Đã thêm dữ liệu vào bảng danhphap. Số dòng được cập nhật: " + rowsAffected);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    //theo lấy và phát audio từ database/ sử dụng file temp
    public static void retrieveAudioFromDatabase(String url, String username, String password,
                                                 String kihieuhoahoc) {
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT AudioUS, AudioUK FROM easychemistry.danhphap WHERE KiHieuHoaHoc = ?"
                )
        ) {
            stmt.setString(1, kihieuhoahoc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Retrieve audio data
                byte[] audioUSData = rs.getBytes("AudioUS");
                byte[] audioUKData = rs.getBytes("AudioUK");

                // Example: Writing bytes to audio files
                try (FileOutputStream fosUS = new FileOutputStream("audio_us_retrieved.wav");
                     FileOutputStream fosUK = new FileOutputStream("audio_uk_retrieved.wav")) {
                    fosUS.write(audioUSData);
                    fosUK.write(audioUKData);
                    System.out.println("Đã lấy dữ liệu âm thanh từ cơ sở dữ liệu và ghi vào các tệp audio.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Không tìm thấy dữ liệu âm thanh cho kí hiệu hóa học đã nhập.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
