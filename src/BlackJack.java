import java.util.*;

/**
 * This class is used for the implementation of the game Blackjack for the user to play
 * It extends from the abstract class Game and haves the same rules just like in the normal casino
 */
public class BlackJack extends Game{


    /**
     * Starts the blackjack game
     * @param user
     * @param scanner
     */
    @Override
    public void play(User user, Scanner scanner) {
        System.out.println();
        System.out.println("WELCOME to BlackJack!");
        System.out.println();

        // Get the bet amount from the user
        int betAmount = getBetAmount(user, scanner);

        // Array for initialization of hands for player
        List<Integer> playerHand = new ArrayList<>();
        // Array for initialazation of hands for dealer
        List<Integer> dealerHand = new ArrayList<>();

        Random random = new Random();

        //  Add two random cards to players hand
        playerHand.add(random.nextInt(11) + 1);
        playerHand.add(random.nextInt(11) + 1);

        //  Add two random cards to dealers hand
        dealerHand.add(random.nextInt(11) + 1);
        dealerHand.add(random.nextInt(11) + 1);

        boolean playerBusted = false;
        boolean dealerBusted = false;

        //  Shows the cards in hands
        System.out.println("Your hand: " + playerHand);
        System.out.println("Dealer's visible card: " + dealerHand.get(0));

        //  Players gets to choose to hit or stand
        while (true) {
            System.out.println("Choose: 1. Hit");
            System.out.println("        2. Stand");
            System.out.println();
            int choice = getBetType(scanner);

            //  If player chooses to hit, adds a card to players hand
            if (choice == 1) {
                playerHand.add(random.nextInt(11) + 1);
                System.out.println("Your hand: " + playerHand);

                //  Check if player has busted
                if (calculateHandValue(playerHand) > 21) {
                    playerBusted = true;
                    break;
                }
            } else {
                break;
            }
        }

        //  Dealers turn to draw cards until hand value is at least 17
        while (calculateHandValue(dealerHand) < 17) {
            dealerHand.add(random.nextInt(11) + 1);
        }

        //  Check if dealer has busted
        if (calculateHandValue(dealerHand) > 21) {
            dealerBusted = true;
        }

        //  Determining the outcome of the played game
        if (playerBusted) {
            user.adjustBalance(-betAmount);
            System.out.println();
            System.out.println("You busted! DEALER WINS.");
            System.out.println();
        } else if (dealerBusted || calculateHandValue(playerHand) > calculateHandValue(dealerHand)) {
            System.out.println();
            System.out.println("YOU WIN!");
            System.out.println();
            user.adjustBalance(betAmount);
        } else {
            user.adjustBalance(-betAmount);
            System.out.println();
            System.out.println("DEALER WINS.");
            System.out.println();
        }

        //  Shows final hands of user and dealer
        System.out.println("Your final hand: " + playerHand);
        System.out.println("Dealer's final hand: " + dealerHand);
    }


    /**
     *  Calculates the value of cards
     */
    private int calculateHandValue(List<Integer> hand) {
        int value = 0;
        int aceCount = 0;

        for (int card : hand) {
            if (card == 1) {
                aceCount++;
                value += 11;
            } else if (card >= 10) {
                value += 10;
            } else {
                value += card;
            }
        }

        //  Adjust value if there are aces and the total value exceeds 21
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }


     /**
      *  Gets the users choice for the bet type (hit or stand)
      */
    private int getBetType(Scanner scanner) {
        int choice = -1;

        //  Check if its a valid input from the user
        while (choice < 1 || choice > 2) {
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option.");
                // Clear invalid input
                scanner.next();
            }
        }

        return choice;
    }


     /**
      *  Gets the bet amount from the user
      */
    private int getBetAmount(User user, Scanner scanner) {
        int betAmount = 0;

        //  Ensure the bet amount is valid and within the users balance
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
                // Clear invalid input
                scanner.next();
            }
        }

        return betAmount;
    }
}
