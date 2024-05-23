package moduleSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UpdateImage {
    public static void main(String[] args) {
        // Thông tin kết nối cơ sở dữ liệu
        String url = "jdbc:mysql://localhost:3306/Librarian";
        String user = "root";
        String password = "PHW#84#jeor";

        // Đường dẫn tới file hình ảnh
        Scanner sc = new Scanner(System.in);
        String imagePath = sc.nextLine();

        // ID của donchat cần cập nhật
        int donchatID = sc.nextInt();

        Connection conn = null;
        PreparedStatement pstmt = null;
        FileInputStream fis = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE easychemistry.element SET hinhminhhoa = ? WHERE sohieunguyentu = ?";

            pstmt = conn.prepareStatement(sql);

            // Đọc file hình ảnh
            File image = new File(imagePath);
            fis = new FileInputStream(image);

            // Thiết lập giá trị cho các tham số trong câu lệnh SQL
            pstmt.setBinaryStream(1, fis, (int) image.length());
            pstmt.setInt(2, donchatID);

            // Thực thi câu lệnh SQL
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Hình ảnh đã được cập nhật thành công.");
            } else {
                System.out.println("Không tìm thấy bản ghi với donchatID: " + donchatID);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}