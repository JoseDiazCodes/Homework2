package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;


class MailItemTest {

  @Test
  void testMailItemCreation() {
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    MailItem mailItem = new MailItem(10, 20, 30, recipient);
    assertEquals(10, mailItem.getWidth());
    assertEquals(20, mailItem.getHeight());
    assertEquals(30, mailItem.getDepth());
    assertEquals(recipient, mailItem.getRecipient());
    System.out.println("Test passed: Mail item created successfully");
  }

  @Test
  void testInvalidMailItemCreation() {
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");

    try {
      new MailItem(0, 20, 30, recipient);
      fail("Expected IllegalArgumentException was not thrown for invalid width");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed: Invalid width threw IllegalArgumentException");
    }

    try {
      new MailItem(10, 0, 30, recipient);
      fail("Expected IllegalArgumentException was not thrown for invalid height");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed: Invalid height threw IllegalArgumentException");
    }

    try {
      new MailItem(10, 20, 0, recipient);
      fail("Expected IllegalArgumentException was not thrown for invalid depth");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed: Invalid depth threw IllegalArgumentException");
    }
  }

  @Test
  void testNullRecipient() {
    try {
      new MailItem(10, 20, 30, null);
      fail("Expected IllegalArgumentException was not thrown for null recipient");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed: Null recipient threw IllegalArgumentException");
    }
  }
}