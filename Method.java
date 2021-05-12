import java.util.Scanner;

public class Method {

    static public void list_all_flights() {
        System.out.println("flight1\n" + "flight2");
    }
 
    static public void book_ticket() {
        int choice;
        Scanner in = new Scanner(System.in);
        System.out.println("Select which flight you want to book");
        list_all_flights();
        choice = in.nextInt();
        System.out.println("please Enter your details");
    }
}
