/**
 * Created by alexandrsemenov on 24.01.17.
 */
public class Hotel {
    private String name;
    private String city;
    private long hotelID;
    //private Set<Room> rooms;
    private static long count;

    public Hotel(String name, String city, long hotelID) {
        this.name = name;
        this.city = city;
        this.hotelID = hotelID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        return hotelID == hotel.hotelID;

    }

    @Override
    public int hashCode() {
        return (int) (hotelID ^ (hotelID >>> 32));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Hotel.count = count;
    }
}
