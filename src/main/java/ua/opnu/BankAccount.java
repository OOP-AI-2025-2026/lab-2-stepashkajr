ppackage ua.opnu;

public class BankAccount {
    private double balance;
    private double transactionFee;

    public BankAccount(double balance, double transactionFee) {
        this.balance = balance;
        this.transactionFee = transactionFee;
    }

    public double getBalance() {
        return balance;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount - transactionFee;
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount + transactionFee <= balance) {
            balance -= amount + transactionFee;
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
}
