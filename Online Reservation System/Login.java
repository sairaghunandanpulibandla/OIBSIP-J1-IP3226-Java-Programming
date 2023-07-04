import java.sql.*;

public class LoginForm {
    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your login id: ");
            String loginId = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Check login credentials
            if (validateLogin(connection, loginId, password)) {
                System.out.println("Login successful!");
                // Proceed to the main system
                // ...
            } else {
                System.out.println("Invalid login credentials. Please try again.");
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean validateLogin(Connection connection, String loginId, String password) {
        try {
            // Prepare the SQL statement
            String sql = "SELECT * FROM users WHERE login_id = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, loginId);
            statement.setString(2, password);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has any rows
            if (resultSet.next()) {
                return true; // Login credentials are valid
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Login credentials are invalid
    }
}
