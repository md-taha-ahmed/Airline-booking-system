package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validation {
    public static String validateDateTime(String input) {
        String temp;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            format.parse(input);
            return input;
        } catch (ParseException e) {
            String newInput;
            System.out.println(
                    "You've Entered an  invalid date and time format please Enter the date and time in this format yyyy-MM-dd HH:mm ");
            System.out.print("");
            newInput = Helper.scan.nextLine();
            temp = validateDateTime(newInput);
        }
        return temp;
    }

    public static String validateDate(String input) {
        String temp;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.parse(input);
            return input;
        } catch (ParseException e) {
            String newInput;
            System.out.println(
                    "You've Entered an  invalid date and time format please Enter the date and time in this format yyyy-MM-dd");
            System.out.print("");
            newInput = Helper.scan.nextLine();
            temp = validateDate(newInput);
        }
        return temp;
    }

    public static boolean intIsEmpty(int input) {
        int number = -1;
        number = input;
        if (number == -1) {
            return true;
        } else {
            return false;
        }
    }

    

}
