import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilyav on 26.01.2017.
 */
public class HotelDao <T extends Hotel> implements AbstactDao <Hotel>{

    Set<Hotel> listOfHotels = new HashSet<>();


    @Override
    public Hotel save(Hotel hotel) throws Exception {
        if (!listOfHotels.add(hotel)) {
            throw new Exception ("Cannot save hotel "+ hotel.getName());
        }
        else listOfHotels.add(hotel);
        return hotel;
    }

    @Override
    public Hotel delete(Hotel hotel) throws Exception {
        if (!listOfHotels.remove(hotel)) {
            throw new Exception("Cannot delete hotel " + hotel.getName());
        }
        else listOfHotels.remove(hotel);
        return hotel;
    };
}
