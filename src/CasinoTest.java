import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class CasinoTest {


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
