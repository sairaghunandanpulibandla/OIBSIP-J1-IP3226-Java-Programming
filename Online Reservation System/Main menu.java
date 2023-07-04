import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;

        while (true) {
            if (!loggedIn) {
                System.out.println("------ Welcome to Online Reservation System ------");
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        loggedIn = loginForm();
                        break;
                    case 2:
                        System.out.println("Thank you for using the Online Reservation System. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("------ Online Reservation System Menu ------");
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        reservationForm();
                        break;
                    case 2:
                        cancellationForm();
                        break;
                    case 3:
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }

    public static boolean loginForm() {
        // Implement the login form logic
        // ...

        // Return true if login is successful, false otherwise
        return true;
    }

    public static void reservationForm() {
        // Implement the reservation form logic
        // ...
    }

    public static void cancellationForm() {
        // Implement the cancellation form logic
        // ...
    }
}
