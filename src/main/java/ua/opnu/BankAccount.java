package ua.opnu;

public class BankAccount {

    public double balance;
    public double transactionFee;

    public BankAccount() {
        this.balance = 0;
        this.transactionFee = 0;
    }

    public BankAccount(double balance, double transactionFee) {
        this.balance = balance;
        this.transactionFee = transactionFee;
    }

    // OPTIONAL, safe for tests
    public double getBalance() {
        return balance;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        double total = amount + transactionFee;

        if (total > balance) return false;

        balance -= total;
        return true;
    }

    public boolean transfer(BankAccount other, double amount) {
        if (amount <= 0) return false;

        double total = amount + transactionFee;

        if (total > balance) return false;

        balance -= total;
        other.balance += amount;

        return true;
    }
}
