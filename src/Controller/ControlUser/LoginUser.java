package Controller.ControlUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.Database.Connection.ConnectJDBC;
import Model.User;
import util.PasswordUtil;

public class LoginUser {
	// Method to get the hashed password from the database
	public static String getHashedPassword(String userName) {
		String hashPwSql = null;

		// Use try-with-resources to automatically close resources
		try (Connection con = ConnectJDBC.getConnection();
				PreparedStatement pre = con
						.prepareStatement("SELECT PasswordHash FROM easychemistry.users WHERE UserName = ?")) {

			// Set the userName parameter
			pre.setString(1, userName);

			// Execute the query
			try (ResultSet resultSet = pre.executeQuery()) {
				// Check if the result set has at least one row
				if (resultSet.next()) {
					// Get the hashed password from the result set
					hashPwSql = resultSet.getString("PasswordHash");
					System.out.println("lấy ra được mật khẩu => tên tìa khoản đúng");
				}
			}
		} catch (SQLException e) {
			// Handle any SQL exceptions
			e.printStackTrace();
		}

		// Return the hashed password or null if not found
		return hashPwSql;
	}

	// Method to login the user
	public static User login(String userName, String passwordInput) {
		String storedHashPassword = null;
		User u = null;
		try {
			storedHashPassword = getHashedPassword(userName);
			System.out.println(storedHashPassword);
			String provideHashPW = PasswordUtil.hashPassword(passwordInput,
					"MiT6mPRGR4nSTiUEmbiW2gnnI9TdS5a0rq9FiEL3B+k=");// Check if the stored hash password matches the
			System.out.println(provideHashPW);						
			// provided hash password
			if (provideHashPW.equals(storedHashPassword)) {
				try (Connection con = ConnectJDBC.getConnection();
						PreparedStatement pre = con
								.prepareStatement("SELECT *	 FROM easychemistry.users WHERE UserName = ?")) {
					pre.setString(1, userName);
					try (ResultSet resultSet = pre.executeQuery()) {
						if (resultSet.next()) {
							u = new User(resultSet.getString("UserName"), resultSet.getString("Email"),
									resultSet.getString("FullName"), resultSet.getBytes("Avatar"));
						}
					}
					return u;
				} catch (Exception e) {

				}

				return u; // Login successful
			} else {
				System.out.println("khống đúng mật khẩu");
				// khống đúng mật khẩu
				return u; // Login failed
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return u;
		}

	}
}
