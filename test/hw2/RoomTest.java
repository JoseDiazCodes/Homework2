package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Test class for the Room class.
 * These tests cover the main functionality of creating rooms,
 * checking availability, booking rooms, and checking guest numbers.
 */
class RoomTest {

  /**
   * Test the Room constructor.
   * Ensures that a room is created correctly with initial guest count of 0.
   */
  @Test
  void testRoomConstructor() {
    Room room = new Room(RoomType.SINGLE, 100.0);
    assertNotNull(room);
    assertEquals(0, room.getNumberOfGuests());
  }

  /**
   * Test the Room constructor with a negative price.
   * Ensures that an IllegalArgumentException is thrown for negative prices.
   */
  @Test
  void testRoomConstructorNegativePrice() {
    try {
      new Room(RoomType.DOUBLE, -50.0);
      fail("Expected IllegalArgumentException was not thrown");
    } catch (IllegalArgumentException e) {
      // Test passes if this exception is caught
      System.out.println("Test passed: Negative price correctly threw IllegalArgumentException");
    }
  }

  /**
   * Test the isAvailable method.
   * Checks if a room is initially available and becomes unavailable after booking.
   */
  @Test
  void testIsAvailable() {
    Room room = new Room(RoomType.DOUBLE, 150.0);
    assertTrue(room.isAvailable());
    room.bookRoom(2);
    assertFalse(room.isAvailable());
  }

  /**
   * Test the bookRoom method.
   * Verifies successful booking and that a booked room can't be booked again.
   */
  @Test
  void testBookRoom() {
    Room room = new Room(RoomType.FAMILY, 200.0);
    assertTrue(room.bookRoom(3));
    assertEquals(3, room.getNumberOfGuests());
    assertFalse(room.bookRoom(2)); // Room is already booked
  }

  /**
   * Test booking a room with more guests than its capacity.
   * Ensures that booking fails when trying to exceed room capacity.
   */
  @Test
  void testBookRoomExceedCapacity() {
    Room room = new Room(RoomType.SINGLE, 80.0);
    assertFalse(room.bookRoom(2)); // Exceeds capacity
    assertEquals(0, room.getNumberOfGuests());
  }

  /**
   * Test booking a room with zero guests.
   * Verifies that attempting to book with 0 guests fails.
   */
  @Test
  void testBookRoomZeroGuests() {
    Room room = new Room(RoomType.DOUBLE, 120.0);
    assertFalse(room.bookRoom(0));
    assertEquals(0, room.getNumberOfGuests());
  }

  /**
   * Test the getNumberOfGuests method.
   * Checks if the guest count is correctly updated after booking.
   */
  @Test
  void testGetNumberOfGuests() {
    Room room = new Room(RoomType.FAMILY, 250.0);
    assertEquals(0, room.getNumberOfGuests());
    room.bookRoom(4);
    assertEquals(4, room.getNumberOfGuests());
  }
}