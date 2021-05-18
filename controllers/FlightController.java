package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.Flight;
import models.Ticket;
import tools.Helper;
import tools.Validation;

public class FlightController {
    ArrayList<Flight> flightList = new ArrayList<Flight>();
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public void addFlight() {
        System.out.println("Enter the flight Number:");
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
        Validation.validateDateTime(ArrivalScanner);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(ArrivalScanner, format);
        LocalDateTime arrival = date;
        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        String departureScanner = Helper.scan.nextLine();
        Validation.validateDateTime(departureScanner);
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        date = LocalDateTime.parse(departureScanner, format);
        LocalDateTime departure = date;
        System.out.println("Enter the price ");
        var price = Helper.scan.nextDouble();
        flightList.add(new Flight(flightNo, capacity, from, to, arrival, departure, price));

    }

    public void deleteFlight() {
        int index;
        displayFlightsDetails();
        System.out.println("Enter the number of the flight that you want to delete:");
        index = Helper.scan.nextInt();
        var deleted = flightList.remove(index - 1);
        System.out.println("the deleted flight:");
        deleted.DisplayFlightDetail();

    }

    public void displayFlightsDetails() {
        int index = 1;
        System.out.println("********************************************************************");
        for (Flight flight : flightList) {
            System.out.println(index + ":-");
            flight.DisplayFlightDetail();
            index++;
            System.out.println("********************************************************************");

        }
    }
}
