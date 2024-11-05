import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        ExamService examService = new ExamService();

        System.out.println("Welcome to Online Examination System");

        // Login
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (userService.login(username, password)) {
            System.out.println("Login Successful!");

            boolean exit = false;
            while (!exit) {
                System.out.println("\nMenu:");
                System.out.println("1. Update Profile");
                System.out.println("2. Change Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter new profile info: ");
                        String newProfile = scanner.nextLine();
                        userService.updateProfile(newProfile);
                        break;
                    case 2:
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        userService.changePassword(newPassword);
                        break;
                    case 3:
                        System.out.println("Starting exam...");
                        examService.startExam(30); // Start with a 30-second timer
                        break;
                    case 4:
                        userService.logout();
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }
}
