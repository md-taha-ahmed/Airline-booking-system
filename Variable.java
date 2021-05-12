import java.util.Scanner;

public class Variable {
    Scanner in = new Scanner(System.in);
    String id, start, distance, flight_date, class_level, passenger_name, passenger_visa;
    int capacity, price, passenger_passport;

    public Variable(String id, int capacity, String start, String distance, String flight_date, String class_level,
            int price) {

        this.id = id;
        this.capacity = capacity;
        this.start = start;
        this.distance = distance;
        this.flight_date = flight_date;
        this.class_level = class_level;
        this.price = price;
    }

    public String passenger_details_domestic(String passenger_name, int passenger_passport) {
        this.passenger_name = passenger_name;
        this.passenger_passport = passenger_passport;
       return "";
    }

    public void get_passenger_details_international() {
        System.out.print("Enter your name :");
        passenger_name = in.next();
        System.out.print("Enter your Passport :");
        passenger_passport = in.nextInt();
        System.out.print("Enter your Visa :");
        passenger_visa = in.next();
    }
}