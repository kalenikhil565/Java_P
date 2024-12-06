public class StripeCreditCard extends Card{

    StripeCreditCard(){}

    StripeCreditCard(String user_full_name,String address, String phone_number, int cvv, double balance){
        super("Stripe",user_full_name,address,phone_number,cvv,balance);
    }
}
