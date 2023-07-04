import java.sql.*;
import java.util.Scanner;

public class CancellationForm {
    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your PNR number: ");
            String pnrNumber = scanner.nextLine();

            // Retrieve the reservation details based on the PNR number
            String reservationDetails = getReservationDetails(connection, pnrNumber);

            if (reservationDetails != null) {
                System.out.println("Reservation details for PNR " + pnrNumber + ":");
                System.out.println(reservationDetails);
                System.out.print("Are you sure you want to cancel the reservation? (Y/N): ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("Y")) {
                    // Perform cancellation logic
                    cancelReservation(connection, pnrNumber);
                    System.out.println("Reservation canceled successfully!");
                } else {
                    System.out.println("Reservation not canceled.");
                }
            } else {
                System.out.println("Invalid PNR number. Please try again.");
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getReservationDetails(Connection connection, String pnrNumber) {
        try {
            // Prepare the SQL statement
            String sql = "SELECT * FROM reservations WHERE pnr_number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pnrNumber);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has any rows
            if (resultSet.next()) {
                // Retrieve the reservation details
                StringBuilder details = new StringBuilder();
                details.append("PNR Number: ").append(resultSet.getString("pnr_number")).append("\n");
                details.append("Name: ").append(resultSet.getString("name")).append("\n");
                details.append("Train Number: ").append(resultSet.getInt("train_number")).append("\n");
                details.append("Train Name: ").append(resultSet.getString("train_name")).append("\n");
                details.append("Class Type: ").append(resultSet.getString("class_type")).append("\n");
                details.append("Date of Journey: ").append(resultSet.getString("date_of_journey")).append("\n");
                details.append("Source Station: ").append(resultSet.getString("source_station")).append("\n");
                details.append("Destination Station: ").append(resultSet.getString("destination_station")).append("\n");

                return details.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void cancelReservation(Connection connection, String pnrNumber) {
        try {
            // Prepare the SQL statement
            String sql = "DELETE FROM reservations WHERE pnr_number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pnrNumber);

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reservation canceled successfully!");
            } else {
                System.out.println("Failed to cancel the reservation.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
