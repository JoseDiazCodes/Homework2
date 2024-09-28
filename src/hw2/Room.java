package hw2;

/**
 * Represents a room in our hotel booking system.
 * This class handles the basics of what makes a hotel room: its type, price,
 * and how many people are staying in it.
 */
public class Room {
  private final RoomType roomType;
  private final double price;
  private int numberOfGuests;

  /**
   * Creates a new Room with a specific type and price.
   *
   * @param roomType The kind of room (SINGLE, DOUBLE, or FAMILY).
   * @param price
   *        How much the room costs per night.
   *        Can't be negative (we're not paying people to stay!).
   * @throws IllegalArgumentException if someone tries to set a negative price.
   */
  public Room(RoomType roomType, double price) {
    if (price < 0) {
      throw new IllegalArgumentException(
              "Price can't be negative. We're running a hotel, not a charity!");
    }
    this.roomType = roomType;
    this.price = price;
    this.numberOfGuests = 0;
  }

  /**
   * Checks if the room is available for booking.
   *
   * @return true if the room is empty and ready for guests, false if it's occupied.
   */
  public boolean isAvailable() {
    return numberOfGuests == 0;
  }

  /**
   * Tries to book the room for a group of guests.
   *
   * @param guests How many people want to stay in the room.
   * @return true if the booking was successful, false if it didn't work out
   *         (maybe the room was full, or they tried to squeeze too many people in).
   */
  public boolean bookRoom(int guests) {
    if (isAvailable() && guests > 0 && guests <= roomType.getCapacity()) {
      numberOfGuests = guests;
      return true;
    }
    return false;
  }

  /**
   * Gets the number of guests currently in the room.
   *
   * @return The number of people staying in the room right now.
   */
  public int getNumberOfGuests() {
    return numberOfGuests;
  }
}