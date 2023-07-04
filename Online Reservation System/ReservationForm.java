import java.util.Scanner;

public class ReservationForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Assume train name is fetched automatically based on the train number
        String trainName = getTrainName(trainNumber);

        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();

        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();

        System.out.print("Enter source station: ");
        String sourceStation = scanner.nextLine();

        System.out.print("Enter destination station: ");
        String destinationStation = scanner.nextLine();

        // Insert the reservation details into the database
        insertReservation(name, trainNumber, trainName, classType, dateOfJourney, sourceStation, destinationStation);

        System.out.println("Reservation successfully made!");
    }

    public static String getTrainName(int trainNumber) {
        // Fetch the train name based on the train number from the database
        // Return the train name
        // ...
    }

    public static void insertReservation(String name, int trainNumber, String trainName,
                                        String classType, String dateOfJourney,
                                        String sourceStation, String destinationStation) {
        // Insert the reservation details into the database
        // ...
    }
}
