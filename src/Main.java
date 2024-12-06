import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);

    static Map<String, String> usernames_passwords = new HashMap<>();
    static {
        usernames_passwords.put("shahd","123");
    }
    static ArrayList<User> users = new ArrayList<>();
    static {
        users.add(new User("Shahd Mahmoud Muhammed","shahd","123", "shahd@gmail.com",
                new PaypalCreditCard("Shahd Mahmoud Muhammed","Alexandria","01202468259",4587,500),
                new StripeCreditCard("Shahd Mahmoud Muhammed","Alexandria","01202468259",4587,1000))) ;

    }

    public static void main(String[] args) {

            while (true) {
                try {
                    System.out.println("Menu:");
                    System.out.println("\t\t1: Login");
                    System.out.println("\t\t2: Signup");

                    System.out.println("Enter number in range 1-2: ");
                    int choice = input.nextInt();

                    if (choice == 1)
                        login();
                    else if (choice == 2)
                        signup();
                    else
                        System.out.println("Wrong input. Try again");
                }
                catch (InputMismatchException ex){
                    System.out.println("Invalid input. Try again");
                    input.nextLine();
                }
            }
    }

    public static void login(){

        System.out.println("Enter username and password : ");
        String username = input.next();
        String password = input.next();

        if(!usernames_passwords.containsKey(username)){

            System.out.println("The user does not exist. Do you want to sign up ? Y/N");
            String choice = input.next();

            if(choice.equals("Y"))
                signup();
            else if(choice.equals("N"))
                return;
            else
                System.out.println("Wrong input. Try again.");
        }

        else if(usernames_passwords.get(username).equals(password)) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    userView(user);
                }
            }
        }

        else{
            System.out.println("Password is incorrect. Try again");
        }

    }

    public static void signup(){
        input.nextLine();

        System.out.println("Enter the following information: ");

        System.out.print("Full name: ");
        String full_name = input.nextLine();

        System.out.print("Username: ");
        String user_name = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        System.out.print("E-mail: ");
        String email = input.nextLine();

        System.out.println("Which card do you want to add? :");
        System.out.println("1- PayPal\n2- Stripe");

        int card_num = input.nextInt();
        input.nextLine();

        System.out.println("Enter the following information of your card: ");

        System.out.println("Address: ");
        String address = input.nextLine();

        System.out.println("Phone number: ");
        String phone_number = input.nextLine();

        System.out.println("CVV: ");
        int cvv = input.nextInt();

        input.nextLine();

        System.out.println("Balance: ");
        double balance = input.nextDouble();

        input.nextLine();

        PaypalCreditCard card1 ;
        StripeCreditCard card2 ;

        card1 = (card_num == 1 ? new PaypalCreditCard(full_name,address,phone_number,cvv,balance) : null);
        card2 = (card_num == 2 ? new StripeCreditCard(full_name,address,phone_number,cvv,balance) : null);

        users.add(new User(full_name,user_name,password,email,card1,card2)) ;
        usernames_passwords.put(user_name,password);

        System.out.println("Registration Successful !");

        for(int i = 0 ; i < 30 ; ++i)
            System.out.print("*");
        System.out.println();
    }

    public static void userView(User user){

        while(true) {
            try {
                System.out.println("**********************************************");

                System.out.printf("Hello %s | User View\n", user.getFull_name());
                System.out.println("Menu:");
                System.out.println("\t\t1: View Profile");
                System.out.println("\t\t2: Make Itinerary");
                System.out.println("\t\t3: List my itineraries");
                System.out.println("\t\t4: Logout");

                int choice = input.nextInt();

                if (choice == 1) {
                   viewProfile(user);
                } else if (choice == 2) {
                    makeItinerary(user);
                } else if (choice == 3) {
                    user.list();
                } else if (choice == 4) {
                    break;
                } else {
                    System.out.println("Wrong input. Try again");
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid input. Try again");
                input.nextLine();
            }
        }
    }

    public static void viewProfile(User user){
        System.out.println("Full name: " + user.getFull_name());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());

        if(user.getCard1() != null)
          System.out.println("Card 1 details: " + user.getCard1().toString());

        if(user.getCard2() != null)
          System.out.println("Card 2 details: " + user.getCard2().toString());

        System.out.println("- - - - - - - - - - - - - - - - -") ;

        System.out.println("Do you want to add a card? Y/N");

        input.nextLine();

        String choice = input.nextLine();

            if (choice.equals("Y")) {

                if (user.getCard2() != null && user.getCard1() != null)
                    System.out.println("You already have the two supported cards");

                else{

                    System.out.println("Enter the following information: ");
                    System.out.println("Phone number associated with the card: ");
                    String phone = input.nextLine();

                    System.out.println("Address: ");
                    String address = input.nextLine();

                    System.out.println("CVV: ");
                    int cvv = input.nextInt();

                    System.out.println("Balance: ");
                    double balance = input.nextDouble();

                    input.nextLine();

                    Card card;
                    if(user.getCard1() == null) {
                        card = new PaypalCreditCard(user.getFull_name(), address, phone, cvv, balance);
                        user.setCard1((PaypalCreditCard) card);
                    }

                    else {
                        card = new StripeCreditCard(user.getFull_name(), address, phone, cvv, balance);
                        user.setCard2((StripeCreditCard) card);
                    }

                    System.out.println("Card is added successfully !");
                }
            }
            else if (choice.equals("N"))
                return ;

            else {
                System.out.println("Wrong input. Try again");
            }
    }

    public static <E> void makeItinerary(User user){

        int itinerary_cnt = 0;

        while(true) {

            System.out.println("Menu:");
            System.out.println("\t\t1: Add Flight");
            System.out.println("\t\t2: Add Hotel");
            System.out.println("\t\t3: Done");
            System.out.println("\t\t4: Cancel");

            int choice = input.nextInt();

            if (choice == 1) {
                addFlight(user);
                ++itinerary_cnt;
            } else if (choice == 2) {
                addHotel(user);
                ++itinerary_cnt;
            }
            else if (choice == 3) {

                if (payment(user))
                    System.out.println("Transaction is successful");

                else {
                    System.out.println("Transaction failed");

                    user.removeFromTotalCost(itinerary_cnt);
                }

                break;
            }

            else if (choice == 4) {
                user.removeFromTotalCost(itinerary_cnt);
                System.out.println("Reservations are cancelled");
                break;
            }

        }
    }

    public static <E> void addFlight(User user){

        input.nextLine();

        try {
            System.out.print("Enter from (city): ");
            String fromCity = input.nextLine();

            System.out.print("Enter to (city): ");
            String toCity = input.nextLine();

            System.out.print("Enter from (date): ");
            String fromDate = input.nextLine();

            System.out.print("Enter to (date): ");
            String toDate = input.nextLine();

            System.out.print("Enter number of adults and children :");
            int adults = input.nextInt();
            int children = input.nextInt();

            ArrayList<TurkishFlight> flights = TurkishFlightsAPI.getFlights();

            for (TurkishFlight flight : flights) {
                System.out.print("Airline: ");
                System.out.println(flight.getAirlineName());
                System.out.print("Departure date : " + flight.getFromDate() + " ");
                System.out.print("Arrival date : " + flight.getToDate() + " ");
                System.out.println("Cost : " + flight.getCost());
            }

            ArrayList<AirCanada> flights2 = AirCanadaAPI.getFlights();

            for (AirCanada flight : flights2) {
                System.out.print("Airline: ");
                System.out.println(flight.getAirlineName());
                System.out.print("Departure date : " + flight.getFromDate() + " ");
                System.out.print("Arrival date : " + flight.getToDate() + " ");
                System.out.println("Cost : " + flight.getCost());
            }

            System.out.print("Enter the number of your choice: ");
            int choice = input.nextInt();

            input.nextLine();

            Flight chosenFlight;

            if (choice <= flights.size()) {
                chosenFlight = flights.get(choice - 1);
            } else {
                chosenFlight = flights2.get(choice - flights.size() - 1);
            }

            Flight.bookFlight(user,chosenFlight, fromCity, toCity, adults, children);
        }
        catch (InputMismatchException ex){
            System.out.println("Invalid input. Try again");
            input.nextLine();
        }
    }

    public static <E> void addHotel(User user){

        input.nextLine();

        try {
            System.out.print("Enter city: ");
            String city = input.nextLine();

            System.out.print("Enter country: ");
            String country = input.nextLine();

            System.out.print("Enter from (date): ");
            String fromDate = input.nextLine();

            System.out.print("Enter to (date): ");
            String toDate = input.nextLine();

            System.out.print("Enter number of adults and children :");
            int adults = input.nextInt();
            int children = input.nextInt();

            ArrayList<HiltonRoom> Hilton = HiltonAPI.getRooms();

            for (HiltonRoom room : Hilton) {

                System.out.print("Hotel : " + room.getHotel_name() + " ");
                System.out.print("Room type: " + room.room_type + " ");
                System.out.print("Price per night: " + room.cost + " ");
                System.out.print("From date: " + room.getFromDate() + " ");
                System.out.println("to date: " + room.getToDate());
            }

            ArrayList<MariottRoom> Marriott = MarriottAPI.getRooms();

            for (MariottRoom room : Marriott) {
                System.out.print("Hotel : " + room.getHotel_name() + " ");
                System.out.print("Room type: " + room.room_type + " ");
                System.out.print("Price per night: " + room.cost + " ");
                System.out.print("From date: " + room.getFromDate() + " ");
                System.out.println("to date: " + room.getToDate());
            }

            System.out.print("Enter the number of your choice: ");
            int choice = input.nextInt();

            input.nextLine();

            Hotel chosenHotel;

            if (choice <= Hilton.size())
                chosenHotel = Hilton.get(choice - 1);
            else
                chosenHotel = Marriott.get(choice - Hilton.size() - 1);

            Hotel.bookHotel(user,chosenHotel, city, country, adults, children);
        }
        catch (InputMismatchException ex){
            System.out.println("Invalid input. Try again");
            input.nextLine();
        }
    }

    public static <E> boolean payment(User user){

        System.out.println("Choose payment method from your cards : ");

        int cnt = 0 ;
        if(user.getCard1() != null) {
            ++cnt;
            System.out.printf("%d: %s\n",cnt, user.getCard1().getCard_name());
        }

        if(user.getCard2() != null) {
            ++cnt;
            System.out.printf("%d: %s\n",cnt, user.getCard2().getCard_name());
        }

        int card_number = input.nextInt();
        input.nextLine();

        boolean status;
        if(cnt == 2){
            if(card_number == 1){
                status = Card.makePayment(user.getCard1(),user.getTotalCost());
            }
            else{
                status =  Card.makePayment(user.getCard2(),user.getTotalCost());
            }
        }

        else{
            status = Card.makePayment(user.getCard1(),user.getTotalCost());
        }

        return status;
    }

}