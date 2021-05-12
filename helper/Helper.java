package helper;

import java.util.Scanner;

import java.util.Random;

public class Helper {
    public static int getId() {
        Random random = new Random();
        return random.nextInt(Integer.SIZE - 1);
    }

    public static final Scanner scan = new Scanner(System.in);
}
