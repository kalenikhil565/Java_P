public abstract class Hotel implements Bookable{

    protected String hotel_name;
    protected String room_type;
    protected double cost;
    protected String fromDate;
    protected String toDate;

    Hotel(){}

    Hotel(String hotel_name,String room_type,double cost, String fromDate, String toDate){

        this.hotel_name = hotel_name;
        this.room_type = room_type;
        this.cost = cost;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getRoom_type(){
        return room_type;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public String getHotel_name(){
        return hotel_name;
    }

    public static void bookHotel(User user, Hotel hotel, String city, String country, int adults, int children){
        if(hotel.getHotel_name().equals("Hilton Hotel"))
            HiltonAPI.bookRoom(user,hotel,city,country,adults,children);
        else
            MarriottAPI.bookRoom(user,hotel,city,country,adults,children);
    }
}
