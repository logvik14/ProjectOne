import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexandrsemenov on 24.01.17.
 */
public class HotelDao implements AbstactDao<Hotel> {

    Set<Hotel> hotels = new HashSet<>();

    @Override
    public Hotel save(Hotel hotel) throws Exception {
        if (!hotels.add(hotel)) throw new Exception("Saving failed.");
        else hotels.add(hotel);
        return hotel;
    }

    @Override
    public Hotel delete(Hotel hotel) throws Exception {
        if (!hotels.remove(hotel)) throw new Exception("Delete failed.");
        else hotels.remove(hotel);
        return hotel;
    }
}
