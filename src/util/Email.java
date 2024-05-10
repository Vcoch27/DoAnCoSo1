package util;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	// passwork: rery qymz pqku xprt
	// email: chemmistryiseasy@gmail.com
	static final String from = "froxfive@gmail.com";
	static final String password = "zlyzjiobjrxygyqv";

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final int CODE_LENGTH = 5;

	public static boolean sendEmail(String to, String title, String content) {
		// Properties: khai báo các thuộc tính
		Properties props = new Properties();
		// Thiết lập SMTP Host
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		// Thiết lập cổng cho TLS (Transport Layer Security)
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		// Yêu cầu xác thực
		props.put("mail.smtp.auth", "true");
		// Bật TLS
		props.put("mail.smtp.starttls.enable", "true");

		// create Autheticator: sử dụng để xác thưc với máy chủ SMTP khi gửi email
		Authenticator auth = new Authenticator() {
			@Override
			// cung cấp thoong tin xác thực
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};

		// tạo phiên làm việc
		Session session = Session.getInstance(props, auth);

		// tạo một tin nhắn
		MimeMessage msg = new MimeMessage(session);

		try {
			// kiểu nội dung
			msg.addHeader("Content-type", "text/HTML;charet-UTF-8");
			// người gửi
			msg.setFrom(from);
			// nguồi nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			// tiêu đề email]
			msg.setSubject(title);
			// quy định ngày gửi
			msg.setSentDate(new Date());
			// quy định email nhận phản hồi
//			msg.setReplyTo(InternetAddress(from,false));
			msg.setContent(content, "text/HTML; charset=UTF-8");
			// gửi email
			Transport.send(msg);
			System.out.println("done");
			return true;
		} catch (Exception e) {
			System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
		}
	}

	public static String generateRandomCode() {
		SecureRandom random = new SecureRandom();
		StringBuilder code = new StringBuilder(CODE_LENGTH);
		for (int i = 0; i < CODE_LENGTH; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			code.append(CHARACTERS.charAt(randomIndex));
		}
		return code.toString();
	}
	public void  maXacMinh(String mail) {
		if (Email.sendEmail("hoangtungmy123@gmail.com", new Date() + "",
				"Mã xác thực cho tài khoản hóe họt của bạn là : " + generateRandomCode())) {
			System.out.println("gửi thành công ");
		} else {
			System.out.println("chet me may r");
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
//			if (Email.sendEmail("luubdd.23it@vku.udn.vn", new Date() + "",
//					"Mã xác thực cho tài khoản hóe họt của bạn là : " + generateRandomCode()
//							+ " chết mày gồi, bay acc nè")) {
//				System.out.println("gửi thành công ");
			if (Email.sendEmail("nqhoang102@gmail.com", new Date() + "",
					"Tín hiệu vũ trụ " + i + " chết mày gồi, bay acc nè")) {
				System.out.println("gửi thành công ");
			} else {
				System.out.println("chet me may r");
			}
		}

	}
}
