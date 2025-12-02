package ua.opnu;

public class BankAccount {

    public double balance;
    public double transactionFee;

    // DEFAULT CONSTRUCTOR (required by tests)
    public BankAccount() {
        this.balance = 0;
        this.transactionFee = 0;
    }

    public BankAccount(double balance, double transactionFee) {
        this.balance = balance;
        this.transactionFee = transactionFee;
    }

    // deposit: INVALID if amount <= 0
    public boolean deposit(double amount) {
        if (amount <= 0) return false;

        balance += amount;
        return true;
    }

    // withdraw: INVALID if amount <= 0 OR insufficient funds
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        double total = amount + transactionFee;

        if (total > balance) return false;

        balance -= total;
        return true;
    }

    // transfer: INVALID if amount <= 0 OR insufficient funds
    public boolean transfer(BankAccount other, double amount) {
        if (amount <= 0) return false;

        double total = amount + transactionFee;

        if (total > balance) return false;

        // withdraw from first account
        balance -= total;

        // deposit to other WITHOUT applying other.transactionFee
        other.balance += amount;

        return true;
    }
}
