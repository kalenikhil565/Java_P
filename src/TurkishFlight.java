public class TurkishFlight extends Flight{

    TurkishFlight(){

    }

    TurkishFlight(String airlineName, String fromDate, String toDate, double cost){
        super("Turkish Airline",fromDate, toDate, cost);
    }

    public String toString(){
        return getAirlineName()+" From date "+getFromDate()+" To date "+getToDate()+" Cost "+getCost();
    }
}
