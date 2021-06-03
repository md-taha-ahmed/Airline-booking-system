package controllers;

import java.time.ZonedDateTime;
import java.util.ArrayList;
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
        System.out.println("Enter from where the flight will go in airport code");
        String fromCode = Helper.scan.nextLine();
        System.out.println("Enter to where the flight will go");
        String to = Helper.scan.nextLine();
        System.out.println("Enter to where the flight will go in airport code");
        String toCode = Helper.scan.nextLine();
        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        String ArrivalScanner = Helper.scan.nextLine().trim();
        ZonedDateTime arrival = Helper.StringToDateFormatter(Validation.validateDateTime(ArrivalScanner));
        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        String departureScanner = Helper.scan.nextLine().trim();
        ZonedDateTime departure = Helper.StringToDateFormatter(Validation.validateDateTime(departureScanner));
        System.out.println("Enter the price ");
        var price = Helper.scan.nextDouble();
        flightList.add(new Flight(flightNo, capacity, from, fromCode, to, toCode, arrival, departure, price));

    }

    public void displayFlightsDetails() {
        int index = 1;
        System.out.println("*********************************************************************");
        for (Flight flight : flightList) {
            System.out.println(index + ":-");
            flight.DisplayFlightDetail();
            index++;
            System.out.println("*********************************************************************");
        }
    }

    private Passenger addPassenger() {
        System.out.println("Enter the Passenger Name :");
        Helper.scan.nextLine();
        String fullName = Helper.scan.nextLine();
        System.out.println("Enter the Passenger's passport :");
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
        System.out.println("--------------------------------------------------------------------");
        for (Ticket ticket : ticketList) {
            System.out.println(index + ":-");
            ticket.displayDetails();
            index++;
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public void cancelTicket() {
        int index;
        displayTickets();
        System.out.println("Enter the number of the ticket that you want to delete:");
        index = Helper.scan.nextInt();
        var d = getFlightIndexById(ticketList.get(index - 1).flight.getId());
        var deleted = ticketList.remove(index - 1);
        System.out.println("the deleted ticket:");
        deleted.displayDetails();
        flightList.get(d).cancelFlight();
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

    private int getFlightIndexById(int input) {
        int index = -1;
        for (Flight flight : flightList) {
            var id = flight.getId();

            if (id == input) {
                index = flightList.indexOf(flight);

            }
        }
        return index;
    }

    public void searchForFlight() {
        System.out.println(
                "please select only one format to pass the name of city (Airport code or the real name of the city )  ");
        System.out.println("Enter from where that flight you want to book:");
        Helper.scan.nextLine();
        String from = Helper.scan.nextLine();
        System.out.println("Enter to where that flight you want to book:");
        String to = Helper.scan.nextLine();
        System.out.println("Enter the timing of flight in format: yyyy-MM-dd HH:mm");
        String time = Helper.scan.nextLine().trim();
        ZonedDateTime date = Helper.StringToDateFormatter(Validation.validateDateTime(time));
        for (Flight flight : flightList) {
            if ((flight.getFrom().equals(from.toLowerCase().trim()) && flight.getTo().equals(to.toLowerCase().trim())
                    && flight.getArrival().equals(date))
                    || (flight.getFromCode().equals(from.toUpperCase().trim())
                            && flight.getToCode().equals(to.toUpperCase().trim())
                            && flight.getArrival().equals(date))) {
                System.out.println("Found!!!");
                flight.DisplayFlightDetail();
                return;
            }
        }
        System.out.println("Not Found!!!");
    }

    public void printTicket() {
        displayTickets();
        System.out.println("Enter the number of the ticket");
        int index = Helper.scan.nextInt();
        var d = getFlightIndexById(ticketList.get(index - 1).flight.getId());
        ticketList.get(d).printTicketToPdf();

    }
}
