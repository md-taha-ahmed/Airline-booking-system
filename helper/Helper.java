package helper;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

public class Helper {
    public static int getId() {
        Random random = new Random();
        return random.nextInt(Integer.SIZE - 1);
    }

    public static final Scanner scan = new Scanner(System.in);

    public static LocalDateTime validateDateTime(String inputTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime temp;
        if (!inputTimeString.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")){
            System.out.println("Invalid time string: " + inputTimeString);
       } 
        // try {
        //     LocalDateTime.parse(inputTimeString, formatter);

        // } catch (DateTimeParseException | NullPointerException e) {
        //     System.out.println(inputTimeString
        //             + "is  Invalid  Date and time format please Enter the date and time in this format yyyy-MM-dd HH:mm ");
        //     // Helper.scan.nextLine();
        //     inputTimeString = Helper.scan.nextLine();
        //     System.out.println(inputTimeString);
        //     validateDateTime(in);
        // }
        temp = LocalDateTime.parse(inputTimeString, formatter);
        return temp;

    }
}
