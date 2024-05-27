import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Roulette extends Game{


    /**
     * Implementation of the Roulette game
     * Allows the user to place bets and calculates the outcome of the game
     * @param user
     * @param scanner
     */
    @Override
    public void play(User user, Scanner scanner) {
        System.out.println();
        System.out.println("WELCOME to Roulette!");
        System.out.println();
        System.out.println("Place your bet: 1. Red/Black");
        System.out.println("                2. Odd/Even");
        System.out.println("                3. Single number");
        System.out.println();

        /**
         * Get the type of bet from the user
         */
        int betType = getBetType(scanner);
        /**
         * Get the bet amount from the user
         */
        int betAmount = getBetAmount(user, scanner);

        /**
         * Generate a random number between 0 and 36
         */
        Random random = new Random();
        int result = random.nextInt(37);

        switch (betType) {
            case 1 -> {
                System.out.println("Choose: 1. Red");
                System.out.println("        2. Black");
                System.out.println();

                /**
                 * Get the color choice from the user
                 */
                int color = getBetType(scanner);
                // Check if the user wins based on the color bet
                if ((color == 1 && result % 2 == 1) || (color == 2 && result % 2 == 0)) {
                    // Adjust balance if the user wins
                    user.adjustBalance(betAmount);
                    System.out.println();
                    System.out.println("YOU WIN!");
                    System.out.println();
                } else {
                    // Adjust balance if the user loses
                    user.adjustBalance(-betAmount);
                    System.out.println();
                    System.out.println("YOU LOST!");
                    System.out.println();
                }
            }

            /**
             * Implementation of the Odd/Even bet
             */
            case 2 -> {
                System.out.println("Choose: 1. Odd");
                System.out.println("        2. Even");
                System.out.println();
                // Get the parity choice from the user
                int parity = getBetType(scanner);
                // Check if the user wins based on the parity bet
                if ((parity == 1 && result % 2 == 1) || (parity == 2 && result % 2 == 0)) {
                    // Adjust balance if the user wins
                    user.adjustBalance(betAmount);
                    System.out.println();
                    System.out.println("YOU WIN!");
                    System.out.println();
                } else {
                    // Adjust balance if the user loses
                    user.adjustBalance(-betAmount);
                    System.out.println();
                    System.out.println("YOU LOST!");
                    System.out.println();
                }
            }

            /**
             * Implementation of the single number bet
             */
            case 3 -> {
                System.out.println("Choose a number (0-36): ");
                // Get the number choice from the user
                int number = getBetType(scanner);
                // Check if the user wins based on the number bet
                if (number == result) {
                    // Adjust balance if the user wins (payout is 35 times the won bet)
                    user.adjustBalance(betAmount * 35);
                    System.out.println();
                    System.out.println("YOU WIN!");
                    System.out.println();
                } else {
                    // Adjust balance if the user loses
                    user.adjustBalance(-betAmount);
                    System.out.println();
                    System.out.println("YOU LOST!");
                    System.out.println();
                }
            }
        }
    }


    /**
     * Gets the type of bet the user wants to place
     * @param scanner
     * @return
     */
    private int getBetType(Scanner scanner) {
        int betType = -1;
        // Ensure bet type is valid
        while (betType < 1 || betType > 36) {
            try {
                betType = scanner.nextInt();
                // Exception for invalid input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option.");
                // Clear invalid input
                scanner.next();
            }
        }
        return betType;
    }


    /**
     * Gets the amount the user wants to bet
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
                // Check if user has sufficient funds
                if (betAmount > user.getBalance()) {
                    System.out.println("Insufficient funds. Try again.");
                } else {
                    break;
                }
                // Exception for invalid input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                // Clear invalid input
                scanner.next();
            }
        }
        return betAmount;
    }
}
