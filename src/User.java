public class User {

    // The balance of the user
    private int balance;


    public User(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    //Adjusts the user's balance by a specified amount
    //Positive amounts increase the balance, negative amounts decrease it
    public void adjustBalance(int amount) {
        balance += amount;
    }
}
