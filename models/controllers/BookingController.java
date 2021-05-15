package models.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import helper.Helper;
import models.Flight;
import models.Ticket;

public class BookingController {
    ArrayList<Flight> flightList = new ArrayList<Flight>();
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public BookingController() {
        flightList.add(new Flight("K12", 10, "london", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60));
        flightList.add(new Flight("SUD520", 10, "jeddah", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60));
        flightList.add(new Flight("BL405", 10, "new york", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60));
        flightList.add(new Flight("L900", 10, "new york", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60));
    }

    public void addFlight() {
        System.out.println("Enter the flight ID:");
        Helper.scan.nextLine();
        String flightNo = Helper.scan.nextLine();
        System.out.println("Enter the capacity");
        int capacity = Helper.scan.nextInt();
        System.out.println("Enter from where the flight will go ");
        Helper.scan.nextLine();
        String from = Helper.scan.nextLine();
        System.out.println("Enter to where the flight will go");
        String to = Helper.scan.nextLine();
        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        String ArrivalScanner = Helper.scan.nextLine();
        Helper.validateDateTime(ArrivalScanner);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(ArrivalScanner, format);
        LocalDateTime arrival = date;
        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        // Helper.scan.nextLine();
        String departureScanner = Helper.scan.nextLine();
        Helper.validateDateTime(departureScanner);
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        date = LocalDateTime.parse(departureScanner, format);
        LocalDateTime departure = date;
        System.out.println("Enter the price ");
        var price = Helper.scan.nextDouble();
        flightList.add(new Flight(flightNo, capacity, from, to, arrival, departure, price));

    }

    public void displayFlightsDetails() {
        System.out.println("********************************************************************");
        for (Flight flight : flightList) {
            flight.DisplayFlightDetail();
            System.out.println("********************************************************************");

        }

    }

}
