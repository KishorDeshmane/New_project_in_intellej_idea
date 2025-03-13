package org.example;

import com.qa.utility.ConfigManager;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.example.AESPasswordEncryption.decrypt;
import static org.example.AESPasswordEncryption.encrypt;

public class EmailReportSender {

    public static void sendEmailWithReport(String recipientEmail) throws Exception {
        // SMTP Server Settings (Example: Gmail SMTP)
        final String senderEmail = "deshmanekishor1996@gmail.com";
        final String secret_key = "9oBcd/gN8QJTphyGmp5qgU2ZidcPtrAlvlK7CdP2zQU=";
        final String encryptedPassword = encrypt(Objects.requireNonNull(ConfigManager.getProperty("Passcode")), secret_key);
        System.out.println("Encrypted pass is: "+encryptedPassword);
        final String senderPassword = decrypt(encryptedPassword, secret_key);

        // SMTP Properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create Authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create Email Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Allure Test Report "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            // Create Email Body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please find the attached Allure test report.");

            // Attach Allure Report (HTML File)
            MimeBodyPart attachmentPart = new MimeBodyPart();
            File reportFile = new File("target/allure-report/index.zip"); // Path to report file
            attachmentPart.attachFile(reportFile);

            // Combine Message and Attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Send Email
            Transport.send(message);
            System.out.println("Email sent successfully with Allure report!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error sending email.");
        }
    }



    public static void zipLargeFile(String sourceFilePath, String zipFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            throw new FileNotFoundException("File not found: " + sourceFilePath);
        }

        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(sourceFile)) {

            ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024 * 8]; // 8KB buffer for better performance
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }
            zos.closeEntry();
        }
        System.out.println("File zipped successfully: " + zipFilePath);
    }

    public static void main(String[] args) throws Exception {

        zipLargeFile("target/allure-report/index.html","target/allure-report/index.zip");
        sendEmailWithReport("kishor.deshmane@iffort.com");

    }
}
