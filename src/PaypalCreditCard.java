public class PaypalCreditCard extends Card{

    PaypalCreditCard(){}

    PaypalCreditCard(String user_full_name,String address, String phone_number, int cvv, double balance){
        super("PayPal",user_full_name,address,phone_number,cvv,balance);
    }

}
