package hw2;

/**
 * Represents a recipient in our package delivery system.
 * This class handles the essential information about a recipient: their name and email.
 */
public class Recipient {
  /** The recipient's first name. */
  private final String firstName;

  /** The recipient's last name. */
  private final String lastName;

  /** The recipient's email address for notifications. */
  private String email;

  /**
   * Constructs a new Recipient with the provided details.
   * checks for null or if the fields are empty before assigning values.
   *
   * @param firstName The recipient's first name.
   * @param lastName The recipient's last name.
   * @param email The recipient's email address.
   * @throws IllegalArgumentException if any parameter is null or empty.
   */
  public Recipient(String firstName, String lastName, String email) {
    if (firstName == null || lastName == null || email == null
            ||
            firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
      throw new IllegalArgumentException(
              "All fields (first name, last name, and email) must be non-null and non-empty.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Updates the recipient's email address.
   *
   * @param email The new email address.
   * @throws IllegalArgumentException if the new email is null or empty.
   */
  public void setEmail(String email) {
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("New email must be non-null and non-empty.");
    }
    this.email = email;
  }

  /**
   * Compares this Recipient to another object for equality.
   * Two recipients are considered equal if they have the same first name, last name, and email.
   *
   * @param obj The object to compare with this Recipient.
   * @return true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Recipient recipient = (Recipient) obj;
    return firstName.equals(recipient.firstName)
            &&
            lastName.equals(recipient.lastName)
            &&
            email.equals(recipient.email);
  }

  /**
   * Returns a string representation of the Recipient.
   *
   * @return A string in the format "FirstName LastName Email:address@example.com".
   */
  @Override
  public String toString() {
    return firstName + " " + lastName + " Email:" + email;
  }

  /**
   * Gets the recipient's first name.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the recipient's last name.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Gets the recipient's email address.
   *
   * @return The email address.
   */
  public String getEmail() {
    return email;
  }
}