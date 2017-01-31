import java.util.HashSet;
import java.util.Set;


public class HotelDao <T extends Hotel> implements AbstactDao <Hotel>{

    private Set<Hotel> allHotels = new HashSet<>();

    private Hotel grand = new Hotel("Grand Hotel", "Kyiv");
    private Hotel mariott1 = new Hotel("Mariott", "Paris");
    private Hotel mariott2 = new Hotel("Mariott", "Paris");
    private RoomDao <Room> roomDao = new RoomDao<>();

    public HotelDao () throws Exception {
        allHotels.add(grand);
        allHotels.add(mariott1);
        allHotels.add(mariott2);

        addRoom(grand, roomDao.getRoom3() );
        addRoom(grand, roomDao.getRoom6() );
        addRoom(mariott1, roomDao.getRoom1() );
        addRoom(mariott1, roomDao.getRoom4() );
        addRoom(mariott2, roomDao.getRoom2() );
        addRoom(mariott2, roomDao.getRoom5() );
    }

    @Override
    public Hotel save(Hotel hotel) throws Exception {
        if (!allHotels.add(hotel)) {
            throw new Exception ("Cannot save hotel "+ hotel.getName());
        }
        else allHotels.add(hotel);
        return hotel;
    }

    @Override
    public Hotel delete(Hotel hotel) throws Exception {
        if (!allHotels.remove(hotel)) {
            throw new Exception("Cannot delete hotel " + hotel.getName());
        }
        else allHotels.remove(hotel);
        return hotel;
    }

    @Override
    public Set<Hotel> getAll() {
        return allHotels;
    }


    public boolean addRoom (Hotel hotel, Room room) throws Exception{
        try {
            hotel.getRooms().add(room);
            room.setHotel(hotel);
            return true;
        }
        catch (Exception e){
            System.out.println("Cannot add room " + room + " into " + hotel);
            return false;
        }
    }

    public RoomDao<Room> getRoomDao() {
        return roomDao;
    }
}
