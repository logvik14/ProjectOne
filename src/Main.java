
public class Main {
    public static void main(String[] args) throws Exception {

        Controller controller = new Controller();
        User Vladymyr = new User("Vladymyr", "Logvinov", 23, "email");

        System.out.println(controller.findHotelByCity("Paris"));
        System.out.println(controller.findHotelByName("Mariott"));

        Map <String, String> request1 = new HashMap<>();
        request1.put("hotelName", "mariott");
        request1.put("cityName", "paris");
        request1.put("price", "500");
        request1.put("persons", "2");

        List<Room> listOfAvailableRooms = controller.findRoom(request1);
        System.out.println("requested room: " + listOfAvailableRooms);

        Room userRoom = listOfAvailableRooms.get(1);
        controller.bookRoom(Vladymyr, userRoom);

        controller.registerUser(Vladymyr);
        controller.bookRoom(Vladymyr, userRoom);
        controller.cancelBooking(Vladymyr, userRoom);

    }
}