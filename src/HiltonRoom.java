public class HiltonRoom extends Hotel{

    HiltonRoom(){}

    HiltonRoom(String hotel_name,String room_type, double cost, String fromDate, String toDate){
        super(hotel_name,room_type,cost,fromDate,toDate);
    }

    public String toString(){
        return "Hilton Hotel, Room Type : "+ room_type +" From date : "+ fromDate
                +" to date : "+toDate+" Price per night : "+cost;
    }
}
