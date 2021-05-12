package helper;

import java.util.Scanner;

import java.util.Random;

public class Helper {
    public static int getId() {
        Random random = new Random();
        return random.nextInt();
    }

    public static final Scanner scan = new Scanner(System.in);
}
