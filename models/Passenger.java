package models;

import tools.Helper;

public class Passenger {
    int id;
    String name;
    String passportNo;
    int age;
    String nationality;

    public String getName() {
        return this.name;
    }

    public void setFullName(String fullName) {
        this.name = fullName;
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
        this.name = fullName;
        this.passportNo = passportNo;
        this.age = age;
        this.nationality = nationality;
    }

    public void DisplayPassengerDetails() {
        System.out.println("                                                   Full name: " + name);
        System.out.println("                                                   Passport No: " + passportNo);
        System.out.println("                                                   Age: " + age);
        System.out.println("                                                   Nationality: " + nationality);
    }

}
