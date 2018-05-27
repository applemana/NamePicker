package NamePicker;

/**
 * Represents the content that will be in the email.
 *
 * @author Appleman
 */
class EmailInformation extends Email implements IEmailInformation {
  private IPerson giftGiver;
  private IPerson giftReceiver;
  private String subject;
  private String body;

  /**
   * Creates new email information given a gift giver, gift receiver, a subject, and a email body.
   * @param giftGiver    The person that will be giving the gift.
   * @param giftReceiver The person who will be receiving the gift.
   * @param subject      The subject of the email.
   * @param body         The body of the email.
   */
  public EmailInformation(IPerson giftGiver, IPerson giftReceiver, String subject, String body) {
    this.giftGiver = giftGiver;
    this.giftReceiver = giftReceiver;
    this.subject = subject;
    this.body = body;
  }

  /**
   * Creates new default email given the gift giver and gift receiver.
   * @param giftGiver    The person who will be giving the gift.
   * @param giftReceiver The person who will be receiving the gift.
   */
  public EmailInformation(IPerson giftGiver, IPerson giftReceiver) {
    this.giftGiver = giftGiver;
    this.giftReceiver = giftReceiver;
    this.subject = emailSubject();
    this.body = emailBody();
  }

  /**
   * Returns the default subject.
   * @return default subject.
   */
  private String emailSubject() {
    return "Stocking Secret Santa Spectacular";
  }

  /**
   * Returns the default email body.
   * @return default email body.
   */
  private String emailBody() {
    return "<p>Hi " + giftGiver.getName() + ",</p>" +
        "\n" + "<p>You have been volun-told<span class=\"Apple-converted-space\">&nbsp;</span>to "
        + "participate in the &ldquo;Stocking Secret Santa Spectacular&rdquo;. Good news, I "
        + "(Aaron&rsquo;s Computer) have chosen the perfect match for you!</p>\n" +
        "<p>The person you will have almost 8 full months to shop for is "
        + "<span style=\"text-decoration: underline;\"><strong>" + giftReceiver.getName()
        + "</strong></span>!!!</p>\n<p>010101110110100101110100011010000010000001101100011011110"
        + "11101100110010100101100000101001000001011000010111001001101111011011100010011101110011"
        + "001000000100001101101111011011010111000001110101011101000110010101110010</p>\n<p>Oh "
        + "sorry, I forgot I was talking to a human.</p>\n<p>With love,<br>Aaron's Computer</p>";
  }

  /**
   * Gets the emails subject.
   * @return emails subject.
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Gets the email body.
   * @return email body.
   */
  public String getBody() {
    return body;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    EmailInformation that = (EmailInformation) obj;

    if (!giftGiver.equals(that.giftGiver)) {
      return false;
    }
    if (!giftReceiver.equals(that.giftReceiver)) {
      return false;
    }
    if (!subject.equals(that.subject)) {
      return false;
    }
    return body.equals(that.body);
  }

  @Override
  public int hashCode() {
    int result = giftGiver.hashCode();
    result = 31 * result + giftReceiver.hashCode();
    result = 31 * result + subject.hashCode();
    result = 31 * result + body.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "EmailInformation{" + "giftGiver=" + giftGiver + ", giftReceiver=" + giftReceiver
        + ", subject='" + subject + '\'' + ", body='" + body + '\'' + '}';
  }
}
