package hw2;

/**
 * Represents a mail item in a package delivery system.
 * This class encapsulates the dimensions of a package
 * and its intended recipient.
 */
public class MailItem {
  /** The width of the mail item, in inches. Must be at least 1. */
  private final int width;

  /** The height of the mail item, in inches. Must be at least 1. */
  private final int height;

  /** The depth of the mail item, in inches. Must be at least 1. */
  private final int depth;

  /** The recipient of the mail item. Cannot be null. */
  private final Recipient recipient;

  /**
   * Constructs a new MailItem with specified dimensions and recipient.
   * @param width    The width of the mail item, in inches.
   * @param height   The height of the mail item, in inches.
   * @param depth    The depth of the mail item, in inches.
   * @param recipient The intended recipient of the mail item.
   * @throws IllegalArgumentException
   *     if any dimension is less than 1 inch or if the recipient is null.
   */
  public MailItem(int width, int height, int depth, Recipient recipient) {
    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException("All dimensions must be at "
              +
              "least 1 inch. No flat packages, please!");
    }
    if (recipient == null) {
      throw new IllegalArgumentException("Recipient cannot be null. "
              +
              "We need to know where to send this!");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    // Create a defensive copy of the recipient
    this.recipient = new Recipient(
            recipient.getFirstName(), recipient.getLastName(), recipient.getEmail());
  }

  /**
   * Gets the width of the mail item.
   * @return The width of the mail item, in inches.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets the height of the mail item.
   * @return The height of the mail item, in inches.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Gets the depth of the mail item.
   * @return The depth of the mail item, in inches.
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Gets the recipient of the mail item.
   * @return The Recipient object associated with this mail item.
   */
  public Recipient getRecipient() {
    // Return a defensive copy of the recipient
    return new Recipient(
            recipient.getFirstName(),
            recipient.getLastName(),
            recipient.getEmail());
  }
}