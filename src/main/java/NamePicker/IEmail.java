package NamePicker;

public interface IEmail {

  /**
   * Sends an email to the giver.
   * @param giver    The person who will be receiving the email.
   * @param receiver The person's name that will be in the email.
   */
  void sendEmail(IPerson giver, IPerson receiver);
}
