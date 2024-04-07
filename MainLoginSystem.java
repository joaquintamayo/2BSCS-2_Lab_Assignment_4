import java.util.Scanner;

public class MainLoginSystem {
    private static final int maxLoginTries = 3;
    private static final String validPassword = "password";
    
    private static int loginTries = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (loginTries <  maxLoginTries) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            try {
                login(password);
                System.out.println("Login Successful!");
                break; 
            } catch (InvalidPasswordException e) {
                System.out.println("Invalid Password. Please try again.\n");
            } catch (MaxLoginTriesException e) {
                System.out.println("Maximum login attempts exceeded. Please try again later.");
                break; 
            }

            loginTries++;
        }

        scanner.close();
    }

    private static void login(String password) throws InvalidPasswordException, MaxLoginTriesException {
        if (!password.equals(validPassword)) {
            if (loginTries >= maxLoginTries - 1) {
                throw new MaxLoginTriesException("Maximum login attempts exceeded.");
            } else {
                throw new InvalidPasswordException("Invalid Password.");
            }
        }
    }
}