package Controller.ControlUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import Controller.Database.Connection.ConnectJDBC;
import Model.User;
import util.Verification;

public class RegisterUser {
	// kiếm tra gmail đã tồn tại hay chưa
	public static boolean checkMail(String gmail) {
		String sql = "SELECT COUNT(*) AS email_count FROM easychemistry.users WHERE Email = ?";
		try (Connection connection = ConnectJDBC.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, gmail);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					int emailCount = resultSet.getInt("email_count");
					return emailCount > 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean addUser(User u ) {
        try (Connection conn = ConnectJDBC.getConnection();
        		PreparedStatement preparedStatement = conn.prepareStatement(
						"INSERT INTO easychemistry.users(UserName,Email,PasswordHash,FullName) VALUES (?,?,?,?)")) {
        	preparedStatement.setString(1, u.getUserName());
			preparedStatement.setString(2, u.getGmail());
			preparedStatement.setString(3, u.getPassword());
			preparedStatement.setString(4, u.getFullName());
			return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error occurred while adding User
        }
    }
	public static boolean updateAvt(String mail, byte[] avt) {
		try(Connection cn = ConnectJDBC.getConnection();
				PreparedStatement ps = cn.prepareStatement("UPDATE easychemistry.users SET Avatar=? WHERE Email=?")) {
			ps.setBytes(1, avt);
			ps.setString(2, mail);
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	

	public static String sentVari(String gmail) {
		String mxn = Verification.generateRandomCode();
		if(Verification.sendEmail(gmail, "Mã xác nhận tài khoản EasyChemistry","Mã xác nhận nhận đăng kí tài khoản hóa học của bạn là: "+mxn)) {
			return mxn;
		}
		return "";
	}
	
}
