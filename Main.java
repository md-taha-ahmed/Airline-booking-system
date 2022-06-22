import com.google.gson.Gson;
import controllers.BookingController;
import tools.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Byte choice;
        BookingController controller = Storage.loadData();
        for (;;) {
            System.out.println("");
            System.out.println(
                    "####################################### Welcome to the flight ticket purchase system! ########################################");
            System.out.println();
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 1. List All Flights -------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 2. Add Flight -------------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 3. Edit A Flight  ---------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 4. Delete Flight ----------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 5. Search For A flight ----------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 6. Book A Ticket ----------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 7. Edit A Ticket ----------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 8. List All Ticket --------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 9. Print A Ticket  --------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 10. Cancel A Ticket -------------------------------------------------------");
            System.out.println(
                    "-------------------------------------------------- 11. Exit The System And Save ----------------------------------------------");
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Please select the serial number to be operated:");
            choice = Helper.scan.nextByte();
            switch (choice) {
                case 1:
                    controller.displayFlightsDetails();
                    break;
                case 2:
                    controller.addFlight();
                    break;
                case 3:
                    controller.editFlight();
                    break;
                case 4:
                    controller.deleteFlight();
                    break;
                case 5:
                    controller.searchForFlight();
                    break;
                case 6:
                    controller.bookTicket();
                    break;
                case 7:
                    controller.editTicket();
                    break;
                case 8:
                    controller.displayTickets();
                    break;
                case 9:
                    controller.printTicket();
                    break;
                case 10:
                    controller.cancelTicket();
                    break;
                case 11:
                    Gson gson = new Gson();
                    String data = gson.toJson(controller);
                    if (Storage.savingData(data)) {
                        System.out.println("Success...");

                        return;
                    } else {
                        System.out.println("Something went wrong !!! plz try again...");

                        break;
                    }
                default:
                    System.out.println("You've enter the wrong number!!!");
                    break;
            }

        }

    }

}
