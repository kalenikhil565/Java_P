import java.util.*;

public class HiltonAPI {

    private static final ArrayList<HiltonRoom> rooms = new ArrayList<>();
    static {
        rooms.add(new HiltonRoom("Hilton Hotel","Double",300,"1-2-2024","15-2-2024"));
        rooms.add(new HiltonRoom("Hilton Hotel","Double",400,"30-2-2024","15-4-2024"));
        rooms.add(new HiltonRoom("Hilton Hotel","Single",200,"10-2-2024","15-2-2024"));
    }

    public static ArrayList<HiltonRoom> getRooms(){
        return rooms;
    }

    public static void bookRoom(User user,Hotel hotel,String fromCity, String toCity, int children, int adults){
        Itinerary<Hotel> iti = new Itinerary<>(hotel, fromCity, toCity, adults, children);
        user.add(iti);
    }
}
