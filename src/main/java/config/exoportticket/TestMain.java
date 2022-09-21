package config.exoportticket;

import entity.tickets.Ticket;
import entity.users.User;

public class TestMain {
    public static void main(String[] args) {
        User user = new User("Seba","Glo","glo@gmail.com","abc","987654321");
        PdfWriteExample pdfWriteExample = new PdfWriteExample(user);
        Ticket ticket = new Ticket(user, 500);
        pdfWriteExample.writeUsingPDF(ticket);
    }
}
