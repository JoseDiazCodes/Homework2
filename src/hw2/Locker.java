package hw2;

/**
 * Represents a locker in a package delivery system.
 * This class manages the storage and retrieval of mail items within specified dimensions.
 */
public class Locker {
  /** The maximum width the locker can accommodate, in inches. */
  private final int maxWidth;

  /** The maximum height the locker can accommodate, in inches. */
  private final int maxHeight;

  /** The maximum depth the locker can accommodate, in inches. */
  private final int maxDepth;

  /** The current mail item stored in the locker. Null if the locker is empty. */
  private MailItem item;

  /**
   * Constructs a new Locker with specified maximum dimensions.
   * @param maxWidth The maximum width of the locker, in inches.
   * @param maxHeight The maximum height of the locker, in inches.
   * @param maxDepth The maximum depth of the locker, in inches.
   * @throws IllegalArgumentException if any dimension is less than 1 inch.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) {
    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException("All dimensions must be at least 1 inch.");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.item = null;
  }

  /**
   * Attempts to add a mail item to the locker.
   * The method will not add the item if the locker is already occupied,
   * if the item is null, or if the item exceeds the locker's dimensions.
   * @param mailItem The mail item to be added to the locker.
   */
  public void addMail(MailItem mailItem) {
    if (item != null || mailItem == null) {
      return; // Locker is already occupied or mailItem is null
    }
    if (mailItem.getWidth() > maxWidth
            || mailItem.getHeight() > maxHeight
            || mailItem.getDepth() > maxDepth) {
      return; // Mail item exceeds locker dimensions
    }
    this.item = mailItem;
  }

  /**
   * Attempts to retrieve the mail item from the locker for a given recipient.
   * @param recipient The recipient attempting to pick up the mail.
   * @return The MailItem if the recipient matches and the locker contains mail,
   *         null if the locker is empty or the recipient doesn't match.
   */
  public MailItem pickupMail(Recipient recipient) {
    if (item == null) {
      return null; // No mail in the locker
    }
    if (item.getRecipient().equals(recipient)) {
      MailItem temp = item;
      item = null;
      return temp;
    }
    return null; // Recipient doesn't match
  }
}