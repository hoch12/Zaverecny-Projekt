import java.util.Scanner;

/**
 * Abstract class for implementation of the games to be extended with
 */
public abstract class Game {

    /**
     * Starts the game and lets user use the scanner
     * @param user
     * @param scanner
     */
    public abstract void play(User user, Scanner scanner);
}
