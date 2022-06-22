package models;

import java.time.*;
import tools.Helper;

public class Flight {
    int id;
    String flightNo;
    int capacity;
    String from;
    String to;
    String fromCode;
    String toCode;
    LocalDateTime departure;
    LocalDateTime arrival;
    Double price;

    public String getFromCode() {
        return this.fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getToCode() {
        return this.toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public int getId() {
        return id;
    }

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

    public Flight(String flightNo, int capacity, String from, String fromCode, String to, String toCode,
            LocalDateTime departure, LocalDateTime arrival, Double price) {
        this.id = Helper.getId();
        this.flightNo = flightNo;
        this.capacity = capacity;
        this.from = from.toLowerCase().trim();
        this.fromCode = fromCode.toUpperCase().trim();
        this.to = to.toLowerCase().trim();
        this.toCode = toCode.toUpperCase().trim();
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public void DisplayFlightDetail() {
        System.out.println("                                                   Flight's code: " + flightNo);
        System.out.println("                                                   From: " + from + " " + fromCode);
        System.out.println("                                                   To: " + to + " " + toCode);
        System.out.println("                                                   Departure: "
                + Helper.dateToStringFormatter(departure));
        System.out.println(
                "                                                   Arrival: " + Helper.dateToStringFormatter(arrival));
        System.out.println("                                                   Price " + price);
        System.out
                .println("                                                   Number of available tickets: " + capacity);
    }

    public void DisplayFlightDetailInTicket() {
        System.out.println("                                                   Flight's code: " + flightNo);
        System.out.println("                                                   From: " + from + " " + fromCode);
        System.out.println("                                                   To: " + to + " " + toCode);
        System.out.println("                                                   Departure: "
                + Helper.dateToStringFormatter(departure));
        System.out.println(
                "                                                   Arrival: " + Helper.dateToStringFormatter(arrival));
        System.out.println("                                                   Price of the ticket :" + price);
    }

    public void DisplayFlightDetailInEditTicket() {
        System.out.println("Flight's code: " + flightNo);
        System.out.println("From: " + from + " " + fromCode);
        System.out.println("To: " + to + " " + toCode);
        System.out.println("Departure: " + Helper.dateToStringFormatter(departure));
        System.out.println("Arrival: " + Helper.dateToStringFormatter(arrival));
        System.out.println("Price of the ticket :" + price);
    }

    public Boolean bookFlight() {
        if (this.capacity > 0) {
            this.capacity--;
            return true;
        }
        return false;
    }

    public boolean cancelFlight() {
        this.capacity++;
        return true;
    }
}
