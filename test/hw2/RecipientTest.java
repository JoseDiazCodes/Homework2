package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;



class RecipientTest {

  @Test
  void testRecipientCreation() {
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    assertEquals("Jose", recipient.getFirstName());
    assertEquals("Diaz", recipient.getLastName());
    assertEquals("jose@example.com", recipient.getEmail());
  }

  @Test
  void testInvalidRecipientCreation() {
    try {
      new Recipient("", "Diaz", "jose@example.com");
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed, exception thrown");

    }

    try {
      new Recipient("Jose", "", "jose@example.com");
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed, exception thrown");

    }

    try {
      new Recipient("Jose", "Diaz", "");
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed, exception thrown");
    }
  }

  @Test
  void testSetEmail() {
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    recipient.setEmail("newemail@example.com");
    assertEquals("newemail@example.com", recipient.getEmail());
  }

  @Test
  void testInvalidSetEmail() {
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    try {
      recipient.setEmail("");
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      System.out.println("Test passed, exception thrown");
    }
  }

  @Test
  void testToString() {
    Recipient recipient = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    assertEquals("Jose Diaz Email:jose@example.com", recipient.toString());
  }

  @Test
  void testEquals() {
    Recipient recipient1 = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    Recipient recipient2 = new Recipient(
            "Jose", "Diaz", "jose@example.com");
    Recipient recipient3 = new Recipient(
            "Maria", "Lopez", "maria@example.com");

    assertTrue(recipient1.equals(recipient2));
    assertFalse(recipient1.equals(recipient3));
  }
}