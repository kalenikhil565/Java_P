import java.util.*;

public class AirCanadaAPI {

    private static final ArrayList<AirCanada> flights = new ArrayList<>();
    static {
        flights.add(new AirCanada("AirCanada Airline","20-12-2024", "21-12-2024", 300));
        flights.add(new AirCanada("AirCanada Airline","22-11-2024", "23-11-2024", 350));
        flights.add(new AirCanada("AirCanada Airline","24-5-2024", "25-5-2024", 250));
    }

    public static ArrayList<AirCanada> getFlights(){
        return flights;
    }

    public static void bookFlight(User user,Flight flight, String fromCity, String toCity, int children, int adults){
        Itinerary<Flight> iti = new Itinerary<>(flight, fromCity, toCity, adults, children);
        user.add(iti);
    }
}
