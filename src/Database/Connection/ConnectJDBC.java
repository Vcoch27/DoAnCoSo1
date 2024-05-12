package Database.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectJDBC {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/Librarian";
			String username = "root";
			String password = "PHW#84#jeor";
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connect mysql fail!");
		}
		return connection;
	}
	//TEST DATABASE
	public static void main(String[] args) {
		try (Connection connection = ConnectJDBC.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT IPAUS FROM easychemistry.danhphap")) {
			while (resultSet.next()) {
				String kq = resultSet.getString("IPAUS");
				System.out.println(kq);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("loi");
		}
	}
}
