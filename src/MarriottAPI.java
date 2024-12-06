import java.util.*;

public class MarriottAPI {
    private static final ArrayList<MariottRoom> rooms = new ArrayList<>();
    static {
        rooms.add(new MariottRoom("Marriott Hotel","City view",300,"1-2-2024","15-2-2024"));
        rooms.add(new MariottRoom("Marriott Hotel","Private view",400,"30-2-2024","15-4-2024"));
        rooms.add(new MariottRoom("Marriott Hotel","Duplex view",200,"10-2-2024","15-2-2024"));
    }

    public static ArrayList<MariottRoom> getRooms(){
        return rooms;
    }

    public static void bookRoom(User user,Hotel hotel,String fromCity, String toCity, int children, int adults){
        Itinerary<Hotel> iti = new Itinerary<>(hotel, fromCity, toCity, adults, children);
        user.add(iti);
    }
}
