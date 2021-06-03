package tools;

import java.util.Scanner;import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Helper {
    public static int getId() {
        Random random = new Random();
        return random.nextInt(Integer.SIZE - 1);
    }

    public final static Scanner scan = new Scanner(System.in);
    public final static ZoneId zoneId = ZoneId.systemDefault();

    public static ZonedDateTime StringToDateFormatter(String input) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withZone(Helper.zoneId);
        ZonedDateTime date = ZonedDateTime.parse(input, format);
        return date;
    }

    public static String dateToStringFormatter(ZonedDateTime input) {
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME.ofPattern("EEE, dd MMM yyyy HH':'mm");
        String date = input.format(formatter);
        return date;
    }

}
