import java.time.LocalDateTime;
import java.util.ArrayList;

import helper.*;
import models.Flight;
import models.Passenger;
import models.Ticket;

public class Main {
    public static void main(String[] args) {
        // Variable flight1 = new Variable("K112", 600, "Aden", "Sanaa", "2020-05-05",
        // "1st class", 17000);
        // Variable flight2 = new Variable("K534", 600, "Los Angeles", "New York",
        // "2020-06-17", "economy", 50000);
        Byte choice;
        ArrayList<Flight> flightList = new ArrayList<Flight>();
        flightList.add(new Flight(10, "london", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60));
        flightList.add(new Flight(10, "jeddah", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60));

        flightList.add(new Flight(10, "new york", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60));
        Flight flight = new Flight(10, "new york", "BLR", LocalDateTime.of(2021, 3, 4, 6, 30),
                LocalDateTime.of(2021, 3, 5, 6, 30), 1200.60);
        Passenger passenger = new Passenger("fullName", "passportNo", 19, "yemen");
        Ticket ticket = new Ticket(passenger, flight);
        //
        for (;;) {
            System.out.println(
                    "*************************** Welcome to the flight ticket purchase system!*****************************************************");
            System.out.println();
            System.out.println(
                    "******************************************************************************************************************************");
            System.out.println(
                    "**************************** 1. List all flights ********************************************");
            System.out.println("**************************** 2. Inquire by departure time ***************************");
            System.out.println("**************************** 3. Query by destination *****************************");
            System.out.println("**************************** 4. Delete flight********************************");
            System.out.println("****************************5. Update flight********************************");
            System.out.println("****************************6. Ticketing system********************************");
            System.out.println("****************************7. Refund system********************************");
            System.out.println("**************************** 8. Exit the system********************************");
            System.out.println("********************************************************************");
            System.out.print("Please select the serial number to be operated:");
            choice = Helper.scan.nextByte();

            switch (choice) {
                case 1:
                    // System.out.println("List all flights");
                    for (Flight flight1 : flightList) {
                        flight1.DisplayFlightDetail();
                        System.out.println("********************************************************************");

                    }

                    break;
                case 2:
                    System.out.println("Inquire by departure time");
                    break;
                case 3:
                    System.out.println("Query by destination");
                    break;
                case 4:
                    System.out.println("Delete flight");
                    break;
                case 5:
                    System.out.println("Update flight");
                    break;
                case 6:
                    System.out.println("Ticketing system");
                    break;
                case 7:
                    System.out.println("Refund system");
                    break;
                case 8:
                    return;

                default:
                    System.out.println("You've enter the wrong number!!!");
                    break;
            }

        }

    }
}
