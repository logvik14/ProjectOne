/**
 * Created by ilyav on 26.01.2017.
 */
public class Room {
    private String persons;
    private int price;
    private long roomId;
    boolean isBooked;
    private static int count;

    public Room(String persons, int price, long roomId) {
        this.persons = persons;
        this.price = price;
        this.roomId = roomId;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Room.count = count;
    }
}
