import java.util.ArrayList;

public class Itinerary<E extends Bookable> {

    private E flight_or_hotel;
    private int adults;
    private int children;
    private String fromCity;
    private String toCity;


    Itinerary(){}

    Itinerary(E flight_or_hotel, String fromCity, String toCity, int children, int adults){
        this.flight_or_hotel = flight_or_hotel;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.children = children;
        this.adults = adults;
    }

    public E getFlight_or_hotel(){
        return flight_or_hotel;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }
}
