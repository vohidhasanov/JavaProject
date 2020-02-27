package Func.MyWorks;

import javax.mail.*;

import java.util.*;


import javax.mail.internet.*;

public class SendEmail {
    public static void main(String[] args) {


        String to = "vohidhasanov@gmail.com";
        String from = "vohid@list.ru";
       // String host = "smtp.gmail.com";

        Properties prop = System.getProperties();
       // prop.setProperty("mail.smtp.host", host);
        prop.setProperty("mail.transport.protocol", "smtp");
//        prop.setProperty("mail.host", host);
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.host", "smtp.mail.ru");
        prop.setProperty("mail.smpt.user", "vohid@list.ru");
        prop.setProperty("mail.smpt.password", "*kok$an1D.");
        prop.setProperty("mail.smtp.starttls.enable","true");
        prop.setProperty("mail.smtp.port","465");
       //prop.setProperty("mail.smtp.ssl","yes");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vohid@list.ru", "*kok$an1D.");
            }
        });
       try {
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(from));
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
           message.setSubject("This is th Subject Line");
           message.setText("This is actual message");

          // System.out.println("Sent message successfully...");


           //Send message
            Transport.send(message );
//           Transport transport = session.getTransport();
//           transport.connect();
//           transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
           System.out.println("Message sent successfully");
       } catch (MessagingException mex) {
           mex.printStackTrace();

       }

        }
        }

//class SmtpAuthenticator extends Authenticator {
//    public  SmtpAuthenticator () {super();}
//
//    public PasswordAuthentication getPasswordAuthentication () {
//        String username = "vohid@list.ru";
//        String password = "*kok$an1D.";
//        if (username !=null && username.length() > 0 && password !=null && password.length() >0)
//            return new PasswordAuthentication(username, password);
//        return null;}
//}
