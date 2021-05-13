package models.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import helper.Helper;
import models.Flight;
import models.Ticket;

public class BookingController {
    ArrayList<Flight> flightList = new ArrayList<Flight>();
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    Scanner scan = new Scanner(System.in);

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
        scan.nextLine();
        var flightNo = scan.nextLine();
        System.out.println("Enter from where the flight will go ");
        var from = scan.nextLine();
        System.out.println("Enter to where the flight will go");
        var to = scan.nextLine();
        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        scan.nextLine();
        // 2 String ArrivalScanner = scan.nextLine();
        // LocalDateTime date = validateDateTime(ArrivalScanner);
        // var arrival = date;
        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        scan.nextLine();
        // String departureScanner = scan.nextLine();
        // date = validateDateTime(departureScanner);
        // var departure = date;
        flightList.add(new Flight(flightNo, 5, from, to, LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 4, 6, 30), 2352.6));

    }

    public void displayFlightsDetails() {
        System.out.println("********************************************************************");
        for (Flight flight : flightList) {
            flight.DisplayFlightDetail();
            System.out.println("********************************************************************");

        }

    }

}
