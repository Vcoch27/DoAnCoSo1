package moduleSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UpdateImageModule {
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Librarian";
    private static final String USER = "root";
    private static final String PASS = "PHW#84#jeor";

    // SQL query to update the img field
    private static final String UPDATE_IMAGE_SQL = "UPDATE easychemistry.nhomdanhphap SET img = ? WHERE nhomid = ?";

    public static void main(String[] args) {
        // Example usage: updateImage("nhom01", "path/to/your/image.jpg");
        updateImage("ocid", "C:\\Users\\LENOVO\\OneDrive\\Pictures\\Ảnh chụp màn hình\\Screenshot 2024-05-22 225649.png");
    }

    public static void updateImage(String nhomid, String imagePath) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_IMAGE_SQL)) {
            
            // Read the image file into a FileInputStream
            File imgFile = new File(imagePath);
            try (FileInputStream fis = new FileInputStream(imgFile)) {
                // Set the parameters for the PreparedStatement
                pstmt.setBinaryStream(1, fis, (int) imgFile.length());
                pstmt.setString(2, nhomid);

                // Execute the update
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Image updated successfully for nhomid: " + nhomid);
                } else {
                    System.out.println("No record found with nhomid: " + nhomid);
                }
            } catch (IOException e) {
                System.err.println("Error reading the image file: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
}
