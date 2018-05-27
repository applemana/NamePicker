package NamePicker;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Represents the sending of an email to the gift giver.
 *
 * @author Appleman
 */
public class Email implements IEmail {
  private static final String EMAIL_FROM = "[enter email here]";
  private static final String username = "[enter username here]";
  private static final String password = "[enter email password here]";

  /**
   * Creates a new instance of an email given no parameters.
   */
  public Email() {
  }

  /**
   * Sends an email to the giver.
   * @param giver    The person who will be receiving the email.
   * @param receiver The person's name that will be in the email.
   */
  public void sendEmail(IPerson giver, IPerson receiver) {
    EmailInformation emailInfo = new EmailInformation(giver, receiver);

    Properties properties = setGmailProperties();

    Session session = Session.getInstance(properties, new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
          }
        }
    );

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(EMAIL_FROM));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(giver.getEmail()));
      message.setSubject(emailInfo.getSubject());
      message.setContent(emailInfo.getBody(), "text/html");
      Transport.send(message);
      System.out.println("Mail sent successfully");

    } catch (MessagingException me) {
      System.out.println("Unsuccessful, if sending from a gmail account, ensure that the \"Allow "
          + "less secure apps\" setting is turned on at https://myaccount.google.com/security?utm_"
          + "source=OGB&utm_medium=act#connectedapps");
      me.printStackTrace();
    }
  }

  /**
   * Sets the properties needed to send a email though Google's mail servers.
   * @return the properties needed to send though a gmail account.
   */
  private Properties setGmailProperties() {
    Properties gmailProperties = System.getProperties();

    gmailProperties.setProperty("mail.smtp.host", "smtp.gmail.com");
    gmailProperties.put("mail.smtp.socketFactory.port", "587");
    gmailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    gmailProperties.put("mail.smtp.auth", "true");
    gmailProperties.put("mail.smtp.starttls.enable", "true");
    gmailProperties.put("mail.smtp.port", "587");

    return gmailProperties;
  }
}
