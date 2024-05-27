public class GameFactory {

    /**
     * Creates and returns a game code based on the users choice
     * @param choice
     * @return
     */
    public static Game createGame(int choice) {
        return switch (choice) {
            case 1 -> new Roulette();
            case 2 -> new BlackJack();
            case 3 -> new HorseRacing();
            default -> null;
        };

    }
}
