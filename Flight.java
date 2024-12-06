public abstract class Flight implements Bookable {

    private String airlineName;
    private String fromDate;
    private String toDate;
    private double cost;

    Flight(){}

    Flight(String airlineName, String fromDate, String toDate, double cost){

        this.airlineName = airlineName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.cost = cost;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getToDate() {
        return toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public double getCost() {
        return cost;
    }

    public static void bookFlight(User user, Flight flight, String fromCity, String toCity, int adults, int children){
        if(flight.getAirlineName().equals("Turkish Airline"))
            TurkishFlightsAPI.bookFlight(user,flight,fromCity,toCity,adults,children);

        else if(flight.getAirlineName().equals("AirCanada Airline"))
            AirCanadaAPI.bookFlight(user,flight,fromCity,toCity,adults,children);
    }
}
