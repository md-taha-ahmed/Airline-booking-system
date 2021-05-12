package models;
import java.util.Scanner;

import helper.Helper;

public class Passenger {
    int id;
    String fullName;
    String passportNo;
    int age;
    String nationality;

    public Passenger(String fullName, String passportNo, int age, String nationality) {
        this.id = Helper.getId();
        this.fullName = fullName;
        this.passportNo = passportNo;
        this.age = age;
        this.nationality = nationality;
    }
    public  boolean setPassengerDetails(){
        Scanner in = new Scanner(System.in);
        return true;
    }


    public void displayPassengerDetails() {
        System.out.println("Full name: " + fullName);
        System.out.println("passport No: " + passportNo);
        System.out.println("age: " + age);
        System.out.println("Nationality: " + nationality);

    }
}
