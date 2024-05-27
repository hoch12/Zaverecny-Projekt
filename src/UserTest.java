import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // Tests if the balance is correctly adjusted when the user wins money
    // The initial balance is $1000. After winning $500, the balance should be $1500
    @Test
    public void testAdjustBalanceWin() {
        User user = new User(1000);
        user.adjustBalance(500);
        assertEquals(1500, user.getBalance());
    }

    // Tests if the balance is correctly adjusted when the user loses money
    // The initial balance is $1000. After losing $300, the balance should be $700
    @Test
    public void testAdjustBalanceLose() {
        User user = new User(1000);
        user.adjustBalance(-300);
        assertEquals(700, user.getBalance());
    }

    // Tests if the balance is correctly adjusted when the user loses all their money
    // The initial balance is $1000. After losing $1000, the balance should be $0
    @Test
    public void testAdjustBalanceBankrupt() {
        User user = new User(1000);
        user.adjustBalance(-1000);
        assertEquals(0, user.getBalance());
    }
}
