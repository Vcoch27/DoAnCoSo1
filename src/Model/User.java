package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

public class User implements Serializable{
	private String userName;
	private String gmail;
	private String passwordHash;
	private String fullName;
	private Timestamp dateJoined;
	private byte[] avatar;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userID) {
		this.userName = userID;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPassword() {
		return passwordHash;
	}
	public void setPassword(String password) {
		this.passwordHash = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Timestamp getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Timestamp dateJoined) {
		this.dateJoined = dateJoined;
	}
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	public User(String userName, String gmail, String password, String fullName, Timestamp dateJoined, byte[] avatar) {
		this.userName = userName;
		this.gmail = gmail;
		this.passwordHash = password;
		this.fullName = fullName;
		this.dateJoined = dateJoined;
		this.avatar = avatar;
	}
	public User(String userName, String gmail, String password, String fullName) {
		this.userName = userName;
		this.gmail = gmail;
		this.passwordHash = password;
		this.fullName = fullName;
		this.dateJoined = null;
		this.avatar = null;
	}
	public User(String userName, String gmail, String fullName, byte[] avatar) {
		this.userName = userName;
		this.gmail = gmail;
		this.passwordHash = null;
		this.fullName = fullName;
		this.dateJoined = null;
		this.avatar = avatar;
	}
	public User( byte[] avatar) {
		this.userName = "";
		this.gmail = "";
		this.passwordHash = "";
		this.fullName = "";
		this.dateJoined = null;
		this.avatar = avatar;
	}
	public User() {
		this.userName = "";
		this.gmail = "";
		this.passwordHash = "";
		this.fullName = "";
		this.dateJoined = null;
		this.avatar = null;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", gmail=" + gmail + ", passwordHash=" + passwordHash + ", fullName=" + fullName
				+ ", dateJoined=" + dateJoined + ", avatar=" + Arrays.toString(avatar) + "]";
	}
	

}
