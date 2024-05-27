/**
 * This class represents the user in the casino
 */
public class User {

    /**
     * The balance of the user
     */
    private int balance;


    public User(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * Adjusts the users balance by a specified amount
     * Winning the bet increase the balance, losing the bet decreases it
     * @param amount
     */
    public void adjustBalance(int amount) {
        balance += amount;
    }
}
