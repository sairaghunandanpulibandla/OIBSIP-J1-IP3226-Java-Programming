import java.util.Scanner;

public class LoginForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your login id: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check login credentials
        if (validateLogin(loginId, password)) {
            System.out.println("Login successful!");
            // Proceed to the main system
            // ...
        } else {
            System.out.println("Invalid login credentials. Please try again.");
        }
    }

    public static boolean validateLogin(String loginId, String password) {
        // Perform validation logic, e.g., check against a database
        // Return true if the login credentials are valid, false otherwise
        // ...
    }
}
