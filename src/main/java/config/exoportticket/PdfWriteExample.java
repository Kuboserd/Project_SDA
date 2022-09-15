package config.exoportticket;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import tickets.Ticket;
import users.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfWriteExample {
    private static final String FILE_NAME = "C:\\Users\\glowa\\IdeaProjects\\SDA-java\\SDA Java PL\\Java Podstawy\\Zadania\\task16\\build\\tmp\\ticket.pdf";
    private static User user;

    public PdfWriteExample(User user) {
        this.user = user;
    }

    public void writeUsingPDF(Ticket ticket) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            //open
            document.open();

            Paragraph pTicket = new Paragraph("Ticket");
            pTicket.setAlignment(Element.ALIGN_CENTER);
            document.add(pTicket);

            Paragraph pOwner = new Paragraph("Owner:" + user.getName() + " " + user.getSurname());
            document.add(pOwner);

            Paragraph pFrom = new Paragraph("From: " + ticket.getFlight().getOrigin());
            document.add(pFrom);

            Paragraph pTo = new Paragraph("To: " + ticket.getFlight().getDestination());
            document.add(pTo);

            Paragraph pDepartureTime = new Paragraph("Departure time: " + ticket.getFlight().getDepartureTime());
            document.add(pDepartureTime);

            Paragraph pArrivalTime = new Paragraph("Arrival time: " + ticket.getFlight().getArrivalTime());
            document.add(pArrivalTime);


            /*Paragraph p2 = new Paragraph();
            p2.add(ticket.getFlight().getDestination()); //no alignment

            document.add(p2);*/

            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);

            document.add(new Paragraph(ticket.getPrice()+"", f));

            //close
            document.close();

            System.out.println("Done");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<Ticket> getUserTicket(){
        return user.getTicketList();
    }

    //private String getAirpotName
}