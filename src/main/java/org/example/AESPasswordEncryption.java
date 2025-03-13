package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESPasswordEncryption {

    // Generate AES Key (Used only once, store it securely)
    public static String generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // AES-256 encryption
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    // Encrypt Password
    public static String encrypt(String password, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt Password
    public static String decrypt(String encryptedPassword, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Generate AES Key (Store securely, do not hardcode in production)
            String secretKey = generateKey();
            System.out.println("Generated Key: " + secretKey);

            // Password to encrypt
            String originalPassword = "icww pcjd unza dmze";
            System.out.println("Original Password: " + originalPassword);

            // Encrypt Password
            String encryptedPassword = encrypt(originalPassword, secretKey);
            System.out.println("Encrypted Password: " + encryptedPassword);

            // Decrypt Password
            String decryptedPassword = decrypt(encryptedPassword, secretKey);
            System.out.println("Decrypted Password: " + decryptedPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
