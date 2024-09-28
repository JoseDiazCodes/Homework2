package hw2;

/**
 * Represents the different types of rooms available in our hotel.
 * Each room type has a maximum capacity, which determines how many guests can stay.
 */
public enum RoomType {
  /** A room for one. */
  SINGLE(1),

  /** A room for two. */
  DOUBLE(2),

  /** A room for families. */
  FAMILY(4);

  private final int capacity;

  /**
   * Creates a new room type with a specific capacity.
   *
   * @param capacity The maximum number of guests this room type can accommodate.
   */
  RoomType(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Gets the maximum number of guests this room type can handle.
   *
   * @return The capacity of the room.
   */
  public int getCapacity() {
    return capacity;
  }
}