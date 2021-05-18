package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.Flight;
import models.Passenger;
import models.Ticket;
import tools.Helper;
import tools.Validation;

public class BookingController {
    ArrayList<Flight> flightList = new ArrayList<Flight>();
    ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

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

    private Passenger addPassenger() {
        System.out.println("Enter the Passenger Name :");
        Helper.scan.nextLine();
        String fullName = Helper.scan.nextLine();
        System.out.println("Enter the Passenger's passport :");
        // Helper.scan.nextLine();
        String passportNo = Helper.scan.nextLine();
        System.out.println("Enter the passenger's age");
        int age = Helper.scan.nextInt();
        System.out.println("Enter Passenger's nationality ");
        Helper.scan.nextLine();
        String nationality = Helper.scan.nextLine();
        Passenger passenger = new Passenger(fullName, passportNo, age, nationality);
        return passenger;

    }

    public void bookTicket() {
        displayFlightsDetails();
        System.out.println("Enter the number of the flight that you want to book:");
        int index = Helper.scan.nextInt();
        if (!flightList.get(index - 1).bookFlight()) {
            System.out.println("No seat is available please select different flight!!!");
            return;
        }
        System.out.println("Enter the details of the passenger:");
        var passenger = addPassenger();
        ticketList.add(new Ticket(passenger, flightList.get(index - 1)));
    }

    public void displayTickets() {
        int index = 1;
        System.out.println("********************************************************************");
        for (Ticket ticket : ticketList) {
            System.out.println(index + ":-");
            ticket.displayDetails();
            index++;
            System.out.println("********************************************************************");

        }
    }

}
