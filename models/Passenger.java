package models;

import java.util.Scanner;
import helper.Helper;

public class Passenger {
    int id;
    String fullName;
    String passportNo;
    int age;
    String nationality;

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Passenger(String fullName, String passportNo, int age, String nationality) {
        this.id = Helper.getId();
        this.fullName = fullName;
        this.passportNo = passportNo;
        this.age = age;
        this.nationality = nationality;
    }

    public boolean setPassengerDetails() {
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
