/**
 * This class is used for to write a message for user if any errors happen
 */
public class GameException extends Exception{

    /**
     * Writes a message for an exception
     * @param message
     */
    public GameException(String message) {
        super(message);
    }
}
