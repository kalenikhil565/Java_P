public class Card {
    private String card_name;
    private String user_full_name;
    private String address;
    private String phone_number;
    private int cvv;
    private double balance;

    Card(){}

    Card(String card_name,String user_full_name,String address,String phone_number,int cvv,double balance){
        this.card_name = card_name;
        this.user_full_name = user_full_name;
        this.address = address;
        this.phone_number = phone_number;
        this.cvv = cvv;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return card_name+"\n"+user_full_name+" "+address+" "+phone_number+"\nCvv: "+cvv+" Balance: "+balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getCard_name(){
        return card_name;
    }

    public static boolean makePayment(Card card, double money){

        if(card.card_name.equals("PayPal"))
           return PaypalAPI.makePayment(card,money);

        else
           return StripeAPI.makePayment(card,money);
    }

    public String getUser_full_name(){
        return user_full_name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number(){
        return phone_number;
    }

    public int getCvv(){
        return cvv;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setUser_full_name(String user_full_name) {
        this.user_full_name = user_full_name;
    }
}
