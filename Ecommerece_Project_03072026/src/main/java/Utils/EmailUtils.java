package Utils;

import java.io.File;
import java.util.Properties;



import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;



public class EmailUtils 
{
	public static void sendEmail(String reportPath)
    {
        final String senderEmail = "ynitin1566@gmail.com";
        final String password = "ofapfzxfybubsouz";

        String receiverEmail = "ynitin1566@gmail.com";

        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(senderEmail, password);
                    }
                });

        try
        {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(senderEmail));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiverEmail));

            message.setSubject("Automation Execution Report");

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setText("Please find attached Automation Test Report.");

            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachmentPart = new MimeBodyPart();

            attachmentPart.attachFile(new File(reportPath));

            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email Sent Successfully");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
