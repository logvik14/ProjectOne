
public class Hotel {
    private String name;
    private String city;
    private long hotelId;
    private static long count =0;

    public Hotel(String name, String city, long hotelId) {
        this.name = name;
        this.city = city;
        this.hotelId = count + 1;
        count ++;
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

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }
}
