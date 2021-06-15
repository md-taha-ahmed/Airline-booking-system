package models;

import tools.Helper;
import java.time.LocalDateTime;
import java.util.Calendar;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Ticket {
    int id;
    public Passenger passenger;
    public Flight flight;

    public Passenger getPassenger() {
        return this.passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Ticket(Passenger passenger, Flight flight) {
        this.id = Helper.getId();
        this.flight = flight;
        this.passenger = passenger;
    }

    public void displayDetails() {
        System.out.println("                                                -------------------------------------");
        System.out.println("                                                   Flight details: ");
        System.out.println("                                                -------------------------------------");
        flight.DisplayFlightDetailInTicket();
        System.out.println("                                                -------------------------------------");
        System.out.println("                                                   Passenger details: ");
        System.out.println("                                                -------------------------------------");
        passenger.DisplayPassengerDetails();

    }

    public void printTicketToPdf() {
        try {
            LocalDateTime date = LocalDateTime.now();
            String line = "-----------------------------------------------------";
            PDDocument document = new PDDocument();
            PDPage blankPage = new PDPage();
            document.addPage(blankPage);
            PDImageXObject pdImage = PDImageXObject.createFromFile("logo/AMC Travels-logos_black.png", document);
            PDPage page = document.getPage(0);
            PDPageContentStream contents = new PDPageContentStream(document, page);
            contents.drawImage(pdImage, 220, 660);
            PDDocumentInformation pdd = document.getDocumentInformation();
            pdd.setAuthor("AMC Travels");
            Calendar pdfDate = Calendar.getInstance();
            pdd.setTitle("Ticket " + passenger.name);
            pdd.setCreationDate(pdfDate);
            pdd.setCreator("AMC Travels company");
            contents.beginText();
            contents.setFont(PDType1Font.COURIER_BOLD, 18);
            contents.newLineAtOffset(20, 660);
            contents.setLeading(23.5f);
            contents.showText("Date: " + Helper.dateToStringFormatter(date) + "         Ticket ID :" + this.id);
            contents.newLine();
            contents.showText(line);
            contents.newLine();
            contents.showText("Name: " + " " + passenger.name);
            contents.newLine();
            contents.showText("Password Number: " + " " + passenger.passportNo);
            contents.newLine();
            contents.showText("Age: " + passenger.age);
            contents.newLine();
            contents.showText("Nationality :" + " " + passenger.nationality);
            contents.newLine();
            contents.showText("Flight Number :" + " " + flight.flightNo);
            contents.newLine();
            contents.showText("From :" + " " + this.flight.from + " " + this.flight.fromCode);
            contents.newLine();
            contents.showText("To :" + " " + this.flight.to + " " + this.flight.toCode);
            contents.newLine();
            contents.showText("Price :" + " " + this.flight.price);
            contents.newLine();
            contents.showText("Time of the arrival :" + " " + Helper.dateToStringFormatter(this.flight.arrival));
            contents.newLine();
            contents.showText("Time of the departure :" + " " + Helper.dateToStringFormatter(this.flight.departure));
            contents.newLine();
            contents.showText(line);
            contents.newLine();
            contents.setFont(PDType1Font.COURIER_BOLD, 22);
            contents.showText("Important information :");
            contents.setFont(PDType1Font.COURIER_BOLD, 18);
            contents.newLine();
            contents.newLine();
            contents.showText("Baggage:");
            contents.setFont(PDType1Font.COURIER_BOLD, 16);
            contents.newLine();
            contents.showText("- Cabin Baggage Allowance Domestic: Hand/ Cabin baggage of");
            contents.newLine();
            contents.showText("maximum 7 kg. ");
            contents.setFont(PDType1Font.COURIER_BOLD, 18);
            contents.newLine();
            contents.showText("Check-In:");
            contents.setFont(PDType1Font.COURIER_BOLD, 16);
            contents.newLine();
            contents.showText("- Airport check-in counters will open two hours prior to the");
            contents.newLine();
            contents.showText("scheduled departure time. Passengers are encouraged to report");
            contents.newLine();
            contents.showText("at the Airport between 1-2 hours prior to the scheduled");
            contents.newLine();
            contents.showText("departure time.");
            contents.setFont(PDType1Font.COURIER_BOLD, 18);
            contents.newLine();
            contents.showText("Cancellations and Rescheduling: ");
            contents.setFont(PDType1Font.COURIER_BOLD, 16);
            contents.newLine();
            contents.showText("- Changes/cancellation in the bookings can be made only up to");
            contents.newLine();
            contents.showText("2 hours prior to scheduled departure time (4 hours in case of ");
            contents.newLine();
            contents.showText("international travel).");
            contents.endText();
            contents.close();
            document.save("Tickets/" + passenger.name + "_" + this.id + ".pdf");
            System.out.println("Your ticket saved at" + "Tickets/" + passenger.name + "_" + this.id + ".pdf");
            document.close();
        } catch (Exception e) {
            System.out.println("The ticket couldn't be printed due: ");
            System.out.println(e.getMessage());
        }
    }
}
