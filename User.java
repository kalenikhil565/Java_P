import java.util.ArrayList;

public class User {
    private String full_name;
    private String username;
    private String password;
    private String email;
    private PaypalCreditCard card1;
    private StripeCreditCard card2;

    private ArrayList<Itinerary<? extends Bookable>> bookedItems ;
    private double totalCost ;

    public User(){
        bookedItems = new ArrayList<>();
        totalCost = 0.0 ;
    }

    public User(String full_name, String username, String password, String email,
                PaypalCreditCard card1, StripeCreditCard card2){
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card1 = card1;
        this.card2 = card2;
        bookedItems = new ArrayList<>();
        totalCost = 0.0;
    }

    public String getFull_name(){
        return full_name;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2(){
        return card2;
    }

    public void setCard1(PaypalCreditCard card1) {
        this.card1 = card1;
    }

    public void setCard2(StripeCreditCard card2) {
        this.card2 = card2;
    }

    public void add(Itinerary ite){
        bookedItems.add(ite);
        totalCost += ite.getFlight_or_hotel().getCost();
    }

    public void list(){
        for(Itinerary<? extends Bookable> ite : bookedItems){
            System.out.println(ite.getFlight_or_hotel().toString());
            System.out.println("From: "+ite.getFromCity());
            System.out.println("to: "+ite.getToCity());
            System.out.println("Adults: "+ite.getAdults()+" children: "+ite.getChildren());
            System.out.println("-----------------------------");
        }

        System.out.println("Total cost: "+totalCost);
    }

    public double getTotalCost(){
        return totalCost;
    }

    public void removeFromTotalCost(int cnt){

        while(cnt > 0){

            int size = bookedItems.size();
            Itinerary<? extends Bookable> ite = bookedItems.get(size-1);

            totalCost -= ite.getFlight_or_hotel().getCost();

            bookedItems.remove(ite);
            --cnt;
        }
    }
}
