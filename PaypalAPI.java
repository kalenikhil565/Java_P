public class PaypalAPI {

    public static boolean makePayment(Card card, double money) {

        if (card.getBalance() < money)
            return false;
        else {
            double balance = card.getBalance();
            card.setBalance(balance-money);
            return true;
        }
    }
}
