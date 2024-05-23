package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtil {

    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    private static final int SALT_LENGTH = 32;

    // Băm mật khẩu sử dụng PBKDF2
    public static String hashPassword(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] saltBytes = Base64.getDecoder().decode(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    public static String generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Xác minh mật khẩu cung cấp so với băm và muối đã lưu trữ
    public static boolean verifyPassword(String providedPassword, String hashedPassword, String salt) {
        try {
            String computedHash = hashPassword(providedPassword, salt);
            return computedHash.equals(hashedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            String password = "Hoang2711#";
            String salt = generateSalt();
            String hashedPassword = hashPassword(password, salt);
            
            String password2 = "Hoang2711#";
            String hashedPassword2 = hashPassword(password2, salt);
            
            if(hashedPassword.equals(hashedPassword2)) {
            	System.out.println("done");
            }
            System.out.println("Salt: " + salt);
            System.out.println("Hashed Password: " + hashedPassword);

            boolean isPasswordCorrect = verifyPassword("Hoang2711#", hashedPassword, salt);
            System.out.println("Password verification: " + (isPasswordCorrect ? "Success" : "Failure"));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}