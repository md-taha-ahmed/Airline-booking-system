package helper;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Helper {
    public static int getId() {
        Random random = new Random();
        return random.nextInt(Integer.SIZE - 1);
    }

    static Scanner scan = new Scanner(System.in);

    public static void validateDateTime(String input) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            format.parse(input);
        } catch (ParseException e) {
            String newInput;
            newInput = scan.nextLine();
            System.out.println(
                    "You've Entered an  invalid date and time format please Enter the date and time in this format yyyy-MM-dd HH:mm ");
            validateDateTime(newInput);
        }
    }
}
