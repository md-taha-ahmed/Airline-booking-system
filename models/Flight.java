package models;

import java.time.*;
import helper.Helper;

public class Flight {
    int id;
    String flightNo;
    int capacity;
    String from;
    String to;
    LocalDateTime departure;
    LocalDateTime arrival;
    Double price;

    public String getFlightNo() {
        return this.flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getDeparture() {
        return this.departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return this.arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Flight(String flightNo, int capacity, String from, String to, LocalDateTime departure, LocalDateTime arrival,
            Double price) {
        this.id = Helper.getId();
        this.flightNo = flightNo;
        this.capacity = capacity;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;

    }

    public void DisplayFlightDetail() {
        System.out.println("flight No: " + flightNo);
        System.out.println("from: " + from);
        System.out.println("to: " + to);
        System.out.println("departure: " + departure);
        System.out.println("Arrival: " + arrival);
        System.out.println("No.available tickets");

    }

}
