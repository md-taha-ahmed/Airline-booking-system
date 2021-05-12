package models;

import java.time.*;

import helper.Helper;

public class Flight {
    int id;
    int capacity;
    String from;
    String to;
    LocalDateTime departure;
    LocalDateTime arrival;
    Double price;

    public Flight(int capacity, String from, String to, LocalDateTime departure, LocalDateTime arrival, Double price) {
        this.id = Helper.getId();
        this.capacity = capacity;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;

    }

    public void DisplayFlightDetail() {
        System.out.println("flight no: " + id);
        System.out.println("from: " + from);
        System.out.println("to: " + to);
        System.out.println("departure: " + departure);
        System.out.println("Arrival: " + arrival);

    }
}
