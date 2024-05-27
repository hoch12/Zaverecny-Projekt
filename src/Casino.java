import java.util.InputMismatchException;
import java.util.Scanner;

public class Casino {


    // The users money for starting, winning, and bankrupt balances
    private static final int STARTING_BALANCE = 1000;
    private static final int WINNING_BALANCE = 100000;
    private static final int BANKRUPT_BALANCE = 0;

    private User user;
    private Scanner scanner;


     // Constructor for the Casino class.
     // Initializes the user with a starting balance and sets up the scanner for input.

    public Casino() {
        this.user = new User(STARTING_BALANCE);
        this.scanner = new Scanner(System.in);
    }


     // Starts the casino application.
     // Displays a menu for the user to choose a game to play or to check their balance.
     // The loop continues until the user wins, goes bankrupt, or chooses to exit.

    public void start() {
        System.out.println("-----------------------WELCOME TO THE CASINO!-----------------------");
        System.out.println();
        while (user.getBalance() < WINNING_BALANCE && user.getBalance() > BANKRUPT_BALANCE) {
            System.out.println("Choose a game to play: 1. Roulette");
            System.out.println("                       2. BlackJack");
            System.out.println("                       3. Horse Racing");
            System.out.println("                       4. Balance");
            System.out.println("                       5. Exit");
            System.out.println();

            // Get the users choice from the menu
            int choice = getUserChoice();

            if (choice == 5) {
                // If user chooses to exit
                System.out.println("Thank you for playing in our Casino.");
                break;
            } else if (choice == 4) {
                // If user chooses to check their balance
                System.out.println("Your current balance is $" + user.getBalance());
            } else {
                // If user chooses a game to play
                Game game = GameFactory.createGame(choice);
                if (game != null) {
                    game.play(user, scanner);
                } else {
                    System.out.println("Invalid choice! Try again.");
                }
            }
        }

        // Check if the user has won or gone bankrupt and give him a message about it
        if (user.getBalance() >= WINNING_BALANCE) {
            System.out.println("CONGRATULATIONS! You won $100,000!");
        } else if (user.getBalance() <= BANKRUPT_BALANCE) {
            System.out.println("YOU WENT BANKRUPT! Better luck next time. ;)");
        }
    }


     // Gets the users choice from the menu.
     // Checks the choice is a valid number between 1 and 5.
    private int getUserChoice() {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                scanner.next(); // Clear invalid input
            }
        }
        return choice;
    }
}
