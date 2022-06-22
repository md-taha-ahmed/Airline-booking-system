package controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import models.Flight;
import models.Passenger;
import models.Ticket;
import tools.Helper;
import tools.Validation;
import java.util.InputMismatchException;

public class BookingController {
    ArrayList<Flight> flightList = new ArrayList<Flight>();
    ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

    public void addFlight() {
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Enter the flight's Code:");
        Helper.scan.nextLine();
        String flightNo = Helper.scan.nextLine().toUpperCase().trim();

        System.out.println("Enter the capacity of the flight ");
        int capacity = Helper.scan.nextInt();

        System.out.println("Enter from where the flight will go ");
        Helper.scan.nextLine();
        String from = Helper.scan.nextLine().toLowerCase().trim();

        System.out.println("Enter from where the flight will go in airport code");
        String fromCode = Helper.scan.nextLine().toUpperCase().trim();

        System.out.println("Enter to where the flight will go");
        String to = Helper.scan.nextLine().toLowerCase().trim();

        System.out.println("Enter to where the flight will go in airport code");
        String toCode = Helper.scan.nextLine().toUpperCase().trim();

        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        String ArrivalScanner = Helper.scan.nextLine().trim();
        LocalDateTime arrival = Helper.StringToDateTimeFormatter(Validation.validateDateTime(ArrivalScanner));

        System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
        String departureScanner = Helper.scan.nextLine().trim();
        LocalDateTime departure = Helper.StringToDateTimeFormatter(Validation.validateDateTime(departureScanner));

        System.out.println("Enter the price of the ticket");
        var price = Helper.scan.nextDouble();

        flightList.add(new Flight(flightNo, capacity, from, fromCode, to, toCode, arrival, departure, price));

    }

    public void displayFlightsDetails() {
        int index = 1;
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        for (Flight flight : flightList) {
            System.out.println("                                                 " + index + "-");
            flight.DisplayFlightDetail();
            index++;
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------");
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
        System.out.print("Enter the number of the flight that you want to book:");
        int index = Helper.scan.nextInt();
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        if (!flightList.get(index - 1).bookFlight()) {
            System.out.println("No seat is available please select different flight!!!");
            return;
        }
        System.out.println("Enter the details of the passenger:\n");
        var passenger = addPassenger();
        ticketList.add(new Ticket(passenger, flightList.get(index - 1)));

        System.out.println("Do you want to print the ticket? (please Type yes/y if you want to print or no/n if not)");
        String input = Helper.scan.nextLine().toLowerCase().trim();
        if (input.equals("yes") || input.equals("y")) {
            ticketList.get(ticketList.size() - 1).printTicketToPdf();
        }

    }

    public void displayTickets() {
        int index = 1;
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        for (Ticket ticket : ticketList) {
            System.out.println("                                                  " + index + "-");
            ticket.displayDetails();
            index++;
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void cancelTicket() {
        int index;
        displayTickets();
        System.out.print("Enter the number of the ticket that you want to cancel it:");
        index = Helper.scan.nextInt();
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        var d = getFlightIndexById(ticketList.get(index - 1).flight.getId());
        var deleted = ticketList.remove(index - 1);
        System.out.println("                                                   the deleted ticket:");
        deleted.displayDetails();
        flightList.get(d).cancelFlight();
    }

    public void deleteFlight() {
        int index;
        displayFlightsDetails();
        System.out.print("Enter the number of the flight that you want to delete it:");
        index = Helper.scan.nextInt();
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        var deleted = flightList.remove(index - 1);
        System.out.println("                                                -------------------------------------");
        System.out.println("                                                   the deleted flight:");
        System.out.println("                                                -------------------------------------");
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

    public void searchForFlight() throws ParseException {
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Enter from where that flight you want to book:");
        Helper.scan.nextLine();
        String from = Helper.scan.nextLine();

        System.out.println("Enter to where that flight you want to book:");
        String to = Helper.scan.nextLine();

        System.out.println("Enter the timing of flight in format: yyyy-MM-dd");
        String time = Helper.scan.nextLine().trim();
        LocalDate date = Helper.StringToDateFormatter(Validation.validateDate(time));

        Boolean flag = true;

        for (Flight flight : flightList) {
            if ((flight.getFrom().equals(from.toLowerCase().trim()) && flight.getTo().equals(to.toLowerCase().trim())
                    && flight.getDeparture().toLocalDate().equals(date))
                    || (flight.getFromCode().equals(from.toUpperCase().trim())
                            && flight.getToCode().equals(to.toUpperCase().trim())
                            && flight.getDeparture().toLocalDate().equals(date))
                    || (flight.getFromCode().equals(from.toUpperCase().trim())
                            && flight.getTo().equals(to.toLowerCase().trim())
                            && flight.getDeparture().toLocalDate().equals(date))
                    || (flight.getFrom().equals(from.toLowerCase().trim())
                            && flight.getToCode().equals(to.toUpperCase().trim())
                            && flight.getDeparture().toLocalDate().equals(date))) {
                flight.DisplayFlightDetail();
                System.out.println(
                        "                                                -------------------------------------");
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Not Found!!!");
        }

    }

    public void printTicket() {
        displayTickets();
        System.out.print("Enter the number of the ticket:");
        int index = Helper.scan.nextInt();
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        var d = getFlightIndexById(ticketList.get(index - 1).flight.getId());
        ticketList.get(d).printTicketToPdf();

    }

    public void editFlight() {
        displayFlightsDetails();
        System.out.println("Enter the number of the flight that you want to edit it ");
        int index = Helper.scan.nextInt();
        index = index - 1;
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Write (edit) if You want edit or click Enter button if  don't need to edit");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Flight's code: " + flightList.get(index).getFlightNo());
        Helper.scan.nextLine();
        String flightNoCheck = Helper.scan.nextLine();
        flightNoCheck = flightNoCheck.toLowerCase().trim();
        if (flightNoCheck.equals("edit")) {
            System.out.println("Please Enter the new flight's code");
            String flightNo = Helper.scan.nextLine();
            flightList.get(index).setFlightNo(flightNo);
            System.out.println("Done...");
        }

        System.out.println("From: " + flightList.get(index).getFrom());
        String fromCheck = Helper.scan.nextLine();
        fromCheck = fromCheck.toLowerCase().trim();
        if (fromCheck.equals("edit")) {
            System.out.println("Please Enter the new source city");
            String from = Helper.scan.nextLine();
            flightList.get(index).setFrom(from);
            System.out.println("Done...");
        }

        System.out.println("From (airport code): " + flightList.get(index).getFromCode());
        String fromCodeCheck = Helper.scan.nextLine();
        fromCodeCheck = fromCodeCheck.toLowerCase().trim();
        if (fromCodeCheck.equals("edit")) {
            System.out.println("Please Enter the new airport code ");
            String fromCode = Helper.scan.nextLine();
            flightList.get(index).setFromCode(fromCode);
            System.out.println("Done...");
        }

        System.out.println("To: " + flightList.get(index).getTo());
        String toCheck = Helper.scan.nextLine();
        toCheck = toCheck.toLowerCase().trim();
        if (toCheck.equals("edit")) {
            System.out.println("Please Enter the new distention city");
            String to = Helper.scan.nextLine();
            flightList.get(index).setTo(to);
            System.out.println("Done...");
        }

        System.out.println("To (airport code): " + flightList.get(index).getToCode());
        String toCodeCheck = Helper.scan.nextLine();
        toCodeCheck = toCodeCheck.toLowerCase().trim();
        if (toCodeCheck.equals("edit")) {
            System.out.println("Please Enter the new airport code");
            String toCode = Helper.scan.nextLine();
            flightList.get(index).setToCode(toCode);
            System.out.println("Done...");
        }

        System.out.println("Departure: " + Helper.dateToStringFormatter(flightList.get(index).getDeparture()));
        String departureCheck = Helper.scan.nextLine();
        departureCheck = departureCheck.toLowerCase().trim();
        if (departureCheck.equals("edit")) {
            System.out.println("Please Enter the new departure time in format yyyy-MM-dd HH:mm");
            String departureScanner = Helper.scan.nextLine();
            LocalDateTime departure = Helper.StringToDateTimeFormatter(Validation.validateDateTime(departureScanner));
            flightList.get(index).setDeparture(departure);
            System.out.println("Done...");
        }

        System.out.println("Arrival: " + Helper.dateToStringFormatter(flightList.get(index).getArrival()));
        String arrivalCheck = Helper.scan.nextLine();
        arrivalCheck = arrivalCheck.toLowerCase().trim();
        if (arrivalCheck.equals("edit")) {
            System.out.println("Please Enter the new arrival time in format yyyy-MM-dd HH:mm");
            String arrivalScanner = Helper.scan.nextLine();
            LocalDateTime arrival = Helper.StringToDateTimeFormatter(Validation.validateDateTime(arrivalScanner));
            flightList.get(index).setArrival(arrival);
            System.out.println("Done...");
        }

        System.out.println("Price " + flightList.get(index).getPrice());
        String priceCheck = Helper.scan.nextLine();
        priceCheck = priceCheck.toLowerCase().trim();
        if (priceCheck.equals("edit")) {
            System.out.println("Please Enter the new price");
            double price = Helper.scan.nextDouble();
            flightList.get(index).setPrice(price);
            System.out.println("Done...");
        }

        System.out.println("Capacity: " + flightList.get(index).getCapacity());
        String capacityCheck = Helper.scan.nextLine();
        capacityCheck = capacityCheck.toLowerCase().trim();
        if (capacityCheck.equals("edit")) {
            System.out.println("Please Enter the new capacity of the flight");
            int capacity = Helper.scan.nextInt();
            flightList.get(index).setCapacity(capacity);
            System.out.println("Done...");
        }

    }

    public void editTicket() {
        displayTickets();
        System.out.println("Enter the number of the ticket");
        int index = Helper.scan.nextInt();
        index = index - 1;
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Write (edit) if You want edit or click Enter button if  don't need to edit");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("-------------------------------------");
        System.out.println("   Passenger details: ");
        System.out.println("-------------------------------------");

        System.out.println("Full name: " + ticketList.get(index).passenger.getName());
        Helper.scan.nextLine();
        String nameCheck = Helper.scan.nextLine();
        nameCheck = nameCheck.toLowerCase().trim();
        if (nameCheck.equals("edit")) {
            System.out.println("Please Enter the new name");
            String name = Helper.scan.nextLine();
            ticketList.get(index).passenger.setFullName(name);
            System.out.println("Done...");
        }

        System.out.println("Passport No: " + ticketList.get(index).passenger.getPassportNo());
        String passportNoCheck = Helper.scan.nextLine();
        passportNoCheck = passportNoCheck.toLowerCase().trim();
        if (passportNoCheck.equals("edit")) {
            System.out.println("Please Enter the new Passport number");
            String passportNo = Helper.scan.nextLine();
            ticketList.get(index).passenger.setPassportNo(passportNo);
            System.out.println("Done...");
        }

        System.out.println("Nationality: " + ticketList.get(index).passenger.getNationality());
        String nationalityCheck = Helper.scan.nextLine();
        nationalityCheck = nationalityCheck.toLowerCase().trim();
        if (nationalityCheck.equals("edit")) {
            System.out.println("Please Enter the new nationality");
            String nationality = Helper.scan.nextLine();
            ticketList.get(index).passenger.setNationality(nationality);
            System.out.println("Done...");
        }

        System.out.println("Age: " + ticketList.get(index).passenger.getAge());
        String ageCheck = Helper.scan.nextLine();
        ageCheck = ageCheck.toLowerCase().trim();
        if (ageCheck.equals("edit")) {
            System.out.println("Please Enter the new age");
            int age = Helper.scan.nextInt();
            ticketList.get(index).passenger.setAge(age);
            System.out.println("Done...");
        }

        System.out.println("-------------------------------------");
        System.out.println("   Flight details: ");
        System.out.println("-------------------------------------");

        ticketList.get(index).flight.DisplayFlightDetailInEditTicket();
        Helper.scan.nextLine();
        String flightCheck = Helper.scan.nextLine();
        flightCheck = flightCheck.toLowerCase().trim();
        if (flightCheck.equals("edit")) {
            displayFlightsDetails();
            System.out.println("Please Enter the new flight number");
            int flightNo = Helper.scan.nextInt();
            ticketList.get(index).setFlight(flightList.get(flightNo - 1));
            System.out.println("Done...");
        }

    }

    public static int vi(int input) {

        try {

        } catch (Exception iException) {
            // TODO: handle exception
        }
        // if (input == (int) input) {
        // return input;
        // } else {
        // System.out.println("plz enter integer");
        // int i= Helper.scan.nextInt();
        // vi(i);
        // }
        return 6;
    }
}
