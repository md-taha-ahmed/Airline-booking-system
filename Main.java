import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import helper.*;
import models.Flight;
import models.Passenger;
import models.Ticket;
import models.controllers.BookingController;

public class Main {
    public static void main(String[] args) {
        Byte choice;
        BookingController controller = new BookingController();

        //
        for (;;) {
            System.out.println("*********** Welcome to the flight ticket purchase system!************");
            System.out.println();
            System.out.println("*********************************************************************");
            System.out.println("**************************** 1. List all flights ********************");
            System.out.println("**************************** 2. Add flight **************************");
            System.out.println("**************************** 3. Query by destination ****************");
            System.out.println("**************************** 4. Delete flight************************");
            System.out.println("**************************** 5. Update flight************************");
            System.out.println("**************************** 6. Ticketing system*********************");
            System.out.println("**************************** 7. Refund system************************");
            System.out.println("**************************** 8. Exit the system**********************");
            System.out.println("*********************************************************************");
            System.out.print("Please select the serial number to be operated:");
            choice = Helper.scan.nextByte();

            switch (choice) {
                case 1:
                    // System.out.println("List all flights");
                    controller.displayFlightsDetails();
                    break;
                case 2:
                    controller.addFlight();
                    // flightList.add(Flight().SetFlightDetail());
                    break;
                case 3:

                    System.out.println("Enter the timing of arrival in format: yyyy-MM-dd HH:mm");
                    Helper.scan.nextLine();
                    String ArrivalScanner = Helper.scan.nextLine();
                    LocalDateTime date = Helper.validateDateTime(ArrivalScanner);
                    System.out.println(date);

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
