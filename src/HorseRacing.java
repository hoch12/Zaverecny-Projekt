import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class has the implementation of the Horse Racing game
 * It is extended from the abstract class Game
 * It allows the user to choose a horse and place a bet and then randomly chooses the winning horse
 */
public class HorseRacing extends Game {


    @Override
    public void play(User user, Scanner scanner) {
        System.out.println();
        System.out.println("WELCOME to Horse Racing!");
        System.out.println();
        System.out.println("Choose a horse (1-5): ");
        System.out.println();

        /**
         * Get the users chosen horse number (1-5)
         */
        int chosenHorse = getBetType(scanner, 5);

        /**
         * Get the bet amount from the user
         */
        int betAmount = getBetAmount(user, scanner);

        Random random = new Random();

        /**
         * Randomly determine the winning horse (1-5)
         */
        int winningHorse = random.nextInt(5) + 1;

        /**
         * Check if the users chosen horse is the winning horse
         */
        if (chosenHorse == winningHorse) {
            /**
             * User wins, multiply bet amount by 5 and adjust users balance
             */
            user.adjustBalance(betAmount * 5);
            System.out.println();
            System.out.println("YOUR HORSE WON!");
            System.out.println();
        } else {
            /**
             * User loses, subtracts bet amount from users balance
             */
            user.adjustBalance(-betAmount);
            System.out.println("YOUR HORSE LOST! Winning horse was: " + winningHorse);
        }
    }


    /**
     * Gets the users choice for a bet type
     * Ensures the choice is within the valid range (1 to maxChoice)
     * @param scanner
     * @param maxChoice
     * @return
     */

    private int getBetType(Scanner scanner, int maxChoice) {
        int choice = -1;
        while (choice < 1 || choice > maxChoice) {
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option.");
                scanner.next(); // Clear invalid input
            }
        }
        return choice;
    }


    /**
     * Gets the bet amount from the user
     * Ensures the bet amount is a valid number and does not exceed the users balance
     * @param user
     * @param scanner
     * @return
     */
    private int getBetAmount(User user, Scanner scanner) {
        int betAmount = 0;
        while (true) {
            try {
                System.out.println("Enter your bet amount: ");
                betAmount = scanner.nextInt();
                if (betAmount > user.getBalance()) {
                    System.out.println("Insufficient funds! Try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid amount.");
                /**
                 * Clear invalid input
                 */
                scanner.next();
            }
        }
        return betAmount;
    }
}