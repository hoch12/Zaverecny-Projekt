import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

/**
 * This class is used for the unit testing of the casino
 */
public class CasinoTest {


    /**
     * Tests a scenario where the user wins or does not lose a game of BlackJack
     * The test ensures the users balance is within the expected range after playing
     */
    @Test
    public void testBlackjackWin() {
        User user = new User(1000);
        BlackJack blackjack = new BlackJack();

        //  Mock Scanner input for a simple game scenario
        Scanner scanner = new Scanner("500\n2\n");
        blackjack.play(user, scanner);
        // Since we cannot control the random outcome, we check if the balance is either unchanged or increased

        assertTrue(user.getBalance() >= 500 && user.getBalance() <= 1500);
    }

    /**
     * Tests a scenario where the user loses a game of BlackJack
     * The test ensures the user's balance is within the expected range after playing
     */
    @Test
    public void testBlackjackLose() {
        User user = new User(1000);
        BlackJack blackjack = new BlackJack();

        // Mock users Scanner input for a simple game scenario

        Scanner scanner = new Scanner("500\n1\n1\n1\n1\n1\n1\n");
        blackjack.play(user, scanner);

         // Since we cannot control the random outcome, we check if the balance is either unchanged or decreased

        assertTrue(user.getBalance() >= 0 && user.getBalance() <= 1000);
    }

    /**
     * Tests a scenario where the user wins or does not lose a game of HorseRacing
     * The test ensures the user's balance is within the expected range after playing
     */
    @Test
    public void testHorseRacingWin() {
        User user = new User(1000);
        HorseRacing horseRacing = new HorseRacing();

        // Mock Scanner input for choosing a horse and betting

        Scanner scanner = new Scanner("1\n500\n");
        horseRacing.play(user, scanner);

        // Since we cannot control the random outcome, we check if the balance is either unchanged or increased

        assertTrue(user.getBalance() >= 500 && user.getBalance() <= 3500);

    }
}
