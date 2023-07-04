import java.util.Scanner;

public class CancellationForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PNR number: ");
        String pnrNumber = scanner.nextLine();

        // Retrieve the reservation details based on the PNR number
        String reservationDetails = getReservationDetails(pnrNumber);

        if (reservationDetails != null) {
            System.out.println("Reservation details for PNR " + pnrNumber + ":");
            System.out.println(reservationDetails);
            System.out.print("Are you sure you want to cancel the reservation? (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                // Perform cancellation logic
                cancelReservation(pnrNumber);
                System.out.println("Reservation canceled successfully!");
            } else {
                System.out.println("Reservation not canceled.");
            }
        } else {
            System.out.println("Invalid PNR number. Please try again.");
        }
    }

    public static String getReservationDetails(String pnrNumber) {
        // Retrieve the reservation details from the database based on the PNR number
        // Return the reservation details as a string
        // ...
    }

    public static void cancelReservation(String pnrNumber) {
        // Perform cancellation logic for the reservation associated with the given PNR number
        // ...
    }
}
