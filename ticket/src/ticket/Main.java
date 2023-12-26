package ticket;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public void login(Scanner scanner) {
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();
    }

    public void updatePassword(Scanner scanner) {
        System.out.println("Enter new password: ");
        String newPassword = scanner.nextLine();
        password = newPassword;
        System.out.println("Password updated successfully.");
    }
}

class Ticket {
    private int ticketid;
    private int price;
    private static int availableTickets;

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getAvailableTickets() {
        return availableTickets;
    }

    public static void setAvailableTickets(int availableTickets) {
        if (availableTickets >= 0) {
            Ticket.availableTickets = availableTickets;
        } else {
            System.out.println("Invalid number of available tickets. Setting to 0.");
            Ticket.availableTickets = 0;
        }
    }

    public int calculateTicketCost(int nooftickets) {
        if (nooftickets > 0 && nooftickets <= availableTickets) {
            int totalAmount = nooftickets * price;
            availableTickets -= nooftickets;
            return totalAmount;
        } else {
            return -1;
        }
    }
}

public class Main {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);

        System.out.println("Enter no of bookings:");
        int noOfBookings = sc.nextInt();

        System.out.println("Enter the available tickets:");
        int availableTickets = sc.nextInt();
        Ticket.setAvailableTickets(availableTickets);

        for (int i = 0; i < noOfBookings; i++) {
            Ticket ticket = new Ticket();

            System.out.println("Enter the ticketid:");
            ticket.setTicketid(sc.nextInt());

            System.out.println("Enter the price:");
            ticket.setPrice(sc.nextInt());

            System.out.println("Enter the no of tickets:");
            int noOfTickets = sc.nextInt();

            int totalAmount = ticket.calculateTicketCost(noOfTickets);

            if (totalAmount != -1) {
                System.out.println("Available tickets: " + Ticket.getAvailableTickets());
                System.out.println("Total amount:" + totalAmount);
                System.out.println("Available ticket after booking:" + Ticket.getAvailableTickets());
            } else {
                System.out.println("Tickets not available for booking.");
            }
        }

        sc.close();
    }

	}


