package ua.opnu;

public class BankAccount {

    double balance;
    double transactionFee;

    // --- TESTS REQUIRE DEFAULT CONSTRUCTOR ---
    public BankAccount() {
        this.balance = 0;
        this.transactionFee = 0;
    }

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
        balance += amount - transactionFee;
    }

    public void withdraw(double amount) {
        balance -= amount + transactionFee;
    }

    // --- TESTS REQUIRE THIS METHOD ---
    public void transfer(BankAccount other, int amount) {
        if (this.balance >= amount + transactionFee) {
            this.withdraw(amount);
            other.deposit(amount);
        }
    }
}
