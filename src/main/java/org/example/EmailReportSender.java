package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class EmailReportSender {

    public static void sendEmailWithReport(String recipientEmail) throws Exception {
        // SMTP Server Settings (Example: Gmail SMTP)
        final String senderEmail = "deshmanekishor1996@gmail.com";
        String password = AESPasswordEncryption.encrypt("Rroitilp09mM4gdGzB6lFMJj4AVmzYKYujIVmPuSFAw=","3BuCj5vNfveDS089IzTvgd9G55Iuj1wHIP8WEeZ0+q8=");
        System.out.println(password);
        final String senderPassword = "icww pcjd unza dmze";
        // Use App Password (not your real password)

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
            message.setSubject("Allure Test Report");

            // Create Email Body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please find the attached Allure test report.");

            // Attach Allure Report (HTML File)
            MimeBodyPart attachmentPart = new MimeBodyPart();
            File reportFile = new File("target/allure-report/index.html"); // Path to report file
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

    public static void main(String[] args) throws Exception {
        sendEmailWithReport("kishor.deshmane@iffort.com");
//        sendEmailWithReport("suman.maity@iffort.com");
    }
}
