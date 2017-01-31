public class Controller {
    private UserDao <User> userDao = new UserDao<>();
    private HotelDao <Hotel> hotelDao = new HotelDao<>();
    private RoomDao <Room> roomDao = hotelDao.getRoomDao();

    public Controller() throws Exception {
    }

    public Set<Hotel> findHotelByCity(String city) {
        Set<Hotel> hotels = hotelDao.getAll();
        try {
            Set<Hotel> hotelsByCity = hotels.stream().filter(hotel -> hotel.getCity().equals(city)).collect(Collectors.toSet());
            if (hotelsByCity.isEmpty()) {
                System.out.println("There are no hotels in city: '" + city + "'");
                return Collections.emptySet();
            }
            return hotelsByCity;
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    public Set<Hotel> findHotelByName(String name) {
        Set<Hotel> hotels = hotelDao.getAll();
        try {
            Set<Hotel> hotelsByName = hotels.stream().filter(hotel -> hotel.getName().equals(name)).collect(Collectors.toSet());

            if (hotelsByName.isEmpty()) {
                System.out.println("There are no hotels with name: '" + name + "'");
                return Collections.emptySet();
            }
            return hotelsByName;
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    private List <Room> listCheckNullOrEmpty(List <Room> listToCheck){
        List <Room> list = new ArrayList<>();
        list.addAll(roomDao.getAll());
        if (listToCheck.isEmpty()) return list;
        else return listToCheck;
    }

    public List <Room> findRoom(Map<String, String> params) {
        Set <Room> rooms = roomDao.getAll();
        try {
            List <Room> hotelNamesSet = rooms.stream().filter(room -> room.getHotel().getName().equalsIgnoreCase(params.get("hotelName"))).collect(Collectors.toList());
            listCheckNullOrEmpty(hotelNamesSet);

            List <Room> cityNameSet = rooms.stream().filter(room -> room.getHotel().getCity().equalsIgnoreCase(params.get("cityName"))).collect(Collectors.toList());
            listCheckNullOrEmpty(cityNameSet);

            List <Room> priceSet = rooms.stream().filter(room -> room.getPrice() == Integer.parseInt(params.get("price"))).collect(Collectors.toList());
            listCheckNullOrEmpty(priceSet);

            List <Room> personsSet = rooms.stream().filter(room -> room.getPersons() == Integer.parseInt(params.get("persons"))).collect(Collectors.toList());
            listCheckNullOrEmpty(personsSet);

            hotelNamesSet.retainAll(cityNameSet);
            hotelNamesSet.retainAll(priceSet);
            hotelNamesSet.retainAll(personsSet);
            return hotelNamesSet;
        }
        catch (NullPointerException e) {
            System.out.println("Some room is not assigned to Hotel");
        }
        return Collections.emptyList();
    }

    public boolean bookRoom (User user, Room room){
        try {
            if (!room.isBooked()) {
                room.setBooked(true);
                room.setUserReserved(user);
                return true;
            }
            else return false;
        }
        catch (UserNotRegisteredException e){
            e.printStackTrace();
            return false;
        }
        catch (Exception e){
            System.out.println("Cannot make reservation");
            return false;
        }
    }

    public boolean cancelBooking (User user, Room room){
        try {
            checkRegisteredUser(user);
            if (!room.isBooked()) {
                System.out.println("Room is not booked");
                return room.isBooked();
            } else {
                room.setBooked(false);
                room.setUserReserved(null);
                return true;
            }
        }
        catch (UserNotRegisteredException e){
            e.printStackTrace();
            return false;
        }
        catch (Exception e){
            System.out.println("Cannot cancel booking");
            return false;
        }
    }

    private boolean checkRegisteredUser (User user) throws UserNotRegisteredException {
        if (!user.isRegistered) throw new UserNotRegisteredException("Non-registered users cannot perform this action");
        else return false;
    }

    public User registerUser (User user) throws Exception {
        userDao.save(user);
        return user;
    }
}