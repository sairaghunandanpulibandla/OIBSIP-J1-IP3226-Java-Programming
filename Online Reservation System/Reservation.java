import java.sql.*;
import java.util.Scanner;

public class ReservationForm {
    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter train number: ");
            int trainNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Assume train name is fetched automatically based on the train number
            String trainName = getTrainName(connection, trainNumber);

            System.out.print("Enter class type: ");
            String classType = scanner.nextLine();

            System.out.print("Enter date of journey: ");
            String dateOfJourney = scanner.nextLine();

            System.out.print("Enter source station: ");
            String sourceStation = scanner.nextLine();

            System.out.print("Enter destination station: ");
            String destinationStation = scanner.nextLine();

            // Insert the reservation details into the database
            insertReservation(connection, name, trainNumber, trainName, classType, dateOfJourney, sourceStation, destinationStation);

            System.out.println("Reservation successfully made!");

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getTrainName(Connection connection, int trainNumber) {
        try {
            // Prepare the SQL statement
            String sql = "SELECT train_name FROM trains WHERE train_number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, trainNumber);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has any rows
            if (resultSet.next()) {
                return resultSet.getString("train_name"); // Return the
