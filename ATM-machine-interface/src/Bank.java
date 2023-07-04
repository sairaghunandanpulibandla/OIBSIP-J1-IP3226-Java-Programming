import java.util.ArrayList;

public class Bank {

    private ArrayList<User> users;
    private User currentUser;

    public Bank() {
        this.users = new ArrayList<>();
        this.currentUser = null;
        // add some initial test users
        users.add(new User("50199", "9154", "Sairaghunandan", "Pulibandla", 1000.0));
        users.add(new User("98662", "9849", "Lakshmi", "Syamala", 500.0));
    }

    public boolean authenticateUser(String userID, String userPIN) {
        for (User user : users) {
            if (user.getUserID().equals(userID) && user.authenticate(userPIN)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUserByID(String userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
}