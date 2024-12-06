public class AirCanada extends Flight{

    AirCanada(){
    }

    AirCanada(String airlineName, String fromDate, String toDate, double cost){
        super("AirCanada Airline", fromDate, toDate, cost);
    }

    public String toString(){
        return getAirlineName()+" From date "+getFromDate()+" To date "+getToDate()+" Cost "+getCost();
    }
}
