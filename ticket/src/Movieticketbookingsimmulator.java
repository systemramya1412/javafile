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

class SeatingArrangement {
    private int rows = 5;  // Number of rows
    private int columns = 10;  // Number of columns
    private String[][] seats;

    // Constructor to initialize the seating arrangement
    public SeatingArrangement() {
        seats = new String[rows][columns];
        // Initialize seats, e.g., "B1", "B2", ..., "E10"
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = String.format("%c%d", i + 'B', j + 1);
            }
        }
    }

    public void displaySeatingArrangement(String date, String showTime) {
        System.out.println("Seating Arrangement for " + date + " " + showTime + ":\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean isSeatAvailable(String seatNumber) {
       
        return true; 
    }
}

class Ticket {
    private String date;
    private String showTime;
    private String  seatNumber;
    private double amount;
    private String status;
   private  int numberofticket;
    public double calculateAmount() {
        
     double amount=100.0;
       amount=amount*numberofticket;
    	return amount;  // Simplified logic for demonstration
    }
}

class BookingStatus {
    public void checkBookingStatus() {
        // Implement logic to check and display booking status
    }
}

public class Movieticketbookingsimmulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User frontDesk = new User();
        SeatingArrangement seatingArrangement = new SeatingArrangement();
        BookingStatus bookingStatus = new BookingStatus();

        // Front desk login
        frontDesk.login(scanner);

        while (true) {
            System.out.println("\n1. View Seating Arrangement");
            System.out.println("2. Book Ticket");
            System.out.println("3. Check Booking Status");
            System.out.println("4. Update Password");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // View Seating Arrangement
                    seatingArrangement.displaySeatingArrangement("date", "showTime");
                    break;

                case 2:
                    // Book Ticket
                    bookTicket(scanner, seatingArrangement);
                    break;

                case 3:
                    // Check Booking Status
                    bookingStatus.checkBookingStatus();
                    break;

                case 4:
                    // Update Password
                    frontDesk.updatePassword(scanner);
                    break;

                case 5:
                    // Exit the application
                    System.out.println("Exiting Movie Ticket Booking Simulator. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookTicket(Scanner scanner, SeatingArrangement seatingArrangement) {
    	System.out.println("Enter booking date: ");
        String date = scanner.nextLine();
        System.out.println("Enter show time: ");
        String showTime = scanner.nextLine();

        // Display seating arrangement
        seatingArrangement.displaySeatingArrangement(date, showTime);

        System.out.println("Enter seat number (e.g., B1, B2, B6 or B1-B5): ");
        String seatNumber = scanner.nextLine();

        // Check seat availability
        if (seatingArrangement.isSeatAvailable(seatNumber)) {
            Ticket ticket = new Ticket();
            ticket.calculateAmount();  // You can implement this method based on your pricing logic

            System.out.println("Amount to be paid: $" + ticket.calculateAmount());

            System.out.println("Enter 'Y' to confirm booking, 'N' to cancel: ");
            String confirmation = scanner.nextLine().toUpperCase();

            if (confirmation.equals("Y")) {
                // Confirm the booking
                // Implement logic to update the booking status and store the ticket details
                System.out.println("Booking confirmed. Thank you!");
            } else {
                System.out.println("Booking canceled.");
            }
        } else {
            System.out.println("Selected seat is not available. Please choose another seat.");
        }
    }
}
