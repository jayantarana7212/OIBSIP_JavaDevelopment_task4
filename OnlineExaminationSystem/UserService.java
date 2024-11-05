import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    private User loggedInUser;

    public UserService() {
        // Pre-defined users
        users.put("user1", new User("user1", "password1", "Profile for user1"));
        users.put("user2", new User("user2", "password2", "Profile for user2"));
    }

    // Login method
    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            return true;
        }
        return false;
    }

    // Update Profile method
    public void updateProfile(String newProfile) {
        if (loggedInUser != null) {
            loggedInUser.setProfile(newProfile);
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Please log in first.");
        }
    }

    // Change Password method
    public void changePassword(String newPassword) {
        if (loggedInUser != null) {
            loggedInUser.setPassword(newPassword);
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Please log in first.");
        }
    }

    // Logout method
    public void logout() {
        loggedInUser = null;
        System.out.println("Logged out successfully!");
    }

    // Get logged-in user
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
