
public class Room {

    private int persons;
    private int price;
    private long roomId;
    private Hotel hotel;
    private boolean isBooked;
    private User userReserved;
    private static int count = 0;


    public Room(int persons, int price) {
        this.persons = persons;
        this.price = price;
        this.roomId = count +1;
        this.hotel = null;
        count ++;
    }

    public int getPersons() {
        return persons;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public User getUserReserved() {
        return userReserved;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (persons != room.persons) return false;
        if (price != room.price) return false;
        if (roomId != room.roomId) return false;
        if (isBooked != room.isBooked) return false;
        return hotel != null ? hotel.equals(room.hotel) : room.hotel == null;

    }

    @Override
    public int hashCode() {
        int result = persons;
        result = 31 * result + price;
        result = 31 * result + (int) (roomId ^ (roomId >>> 32));
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (isBooked ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                '}';
    }
}
