package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class LockerTest {

  @Test
  void testLockerCreation() {
    Locker locker = new Locker(50, 60, 70);
    assertNotNull(locker);
  }

  @Test
  void testInvalidLockerCreation() {
    try {
      new Locker(0, 60, 70);
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed, exception thrown");
    }

    try {
      new Locker(50, 0, 70);
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed, exception thrown");
    }

    try {
      new Locker(50, 60, 0);
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed, exception thrown");
    }
  }

  @Test
  void testAddAndPickupMail() {
    Locker locker = new Locker(50, 50, 50);
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    MailItem mailItem = new MailItem(10, 20, 30, recipient);

    locker.addMail(mailItem);
    MailItem retrievedItem = locker.pickupMail(recipient);

    assertNotNull(retrievedItem);
    assertEquals(recipient, retrievedItem.getRecipient());
  }

  @Test
  void testPickupEmptyLocker() {
    Locker locker = new Locker(50, 50, 50);
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");

    MailItem retrievedItem = locker.pickupMail(recipient);
    assertNull(retrievedItem);
  }

  @Test
  void testAddMailToFullLocker() {
    Locker locker = new Locker(50, 50, 50);
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    MailItem mailItem1 = new MailItem(10, 20, 30, recipient);
    MailItem mailItem2 = new MailItem(5, 10, 15, recipient);

    locker.addMail(mailItem1);
    locker.addMail(mailItem2);  // This should not be added

    MailItem retrievedItem = locker.pickupMail(recipient);
    assertEquals(mailItem1, retrievedItem);
  }

  @Test
  void testAddOversizedMail() {
    Locker locker = new Locker(30, 30, 30);
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    MailItem oversizedItem = new MailItem(40, 40, 40, recipient);

    locker.addMail(oversizedItem);  // This should not be added

    MailItem retrievedItem = locker.pickupMail(recipient);
    assertNull(retrievedItem);
  }
}