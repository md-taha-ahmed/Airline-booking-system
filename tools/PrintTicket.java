package tools;

import java.io.File;
import java.util.Calendar;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PrintTicket {
    public static void main(String args[]) throws Exception {
        File file = new File("sample.pdf");
        PDDocument document = PDDocument.load(file);
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);
        PDImageXObject pdImage = PDImageXObject.createFromFile(
                "/home/md-taha/Code/java/Airline_booking_system/logo/AMC Travels-logos_black.png", document);
        PDPage page = document.getPage(7);
        PDPageContentStream contents = new PDPageContentStream(document, page);
        contents.drawImage(pdImage, 10, 650);
        contents.close();
        PDDocumentInformation pdd = document.getDocumentInformation();
        pdd.setAuthor("AMC Travels");
        Calendar date = Calendar.getInstance();
        String name = "Md Taha";
        pdd.setTitle("Ticket " + name);
        pdd.setCreationDate(date);
        pdd.setCreator("AMC Travels company");
        document.save("sample.pdf");
        System.out.println("PDF created");
        document.close();
        
    }
}
