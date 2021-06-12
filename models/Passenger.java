package models;

import tools.Helper;

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

    public void DisplayPassengerDetails() {
        System.out.println("                                                   Full name: " + fullName);
        System.out.println("                                                   Passport No: " + passportNo);
        System.out.println("                                                   Age: " + age);
        System.out.println("                                                   Nationality: " + nationality);
    }

}
