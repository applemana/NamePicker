package NamePicker;

/**
 * Represents a person that will be a part of the random assignment of partners.
 *
 * @author Appleman
 */
public class Person implements IPerson {
  private String name;
  private String email;

  /**
   * Creates a new person given their name and email address.
   * @param name  The person's first and last name.
   * @param email The person's email address where the email will be sent.
   */
  public Person(String name, String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * Gets the name of the person.
   * @return Person's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the email of the person.
   * @return Person's email.
   */
  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Person person = (Person) obj;

    if (!name.equals(person.name)) {
      return false;
    }
    return email.equals(person.email);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + email.hashCode();
    return result;
  }
}
