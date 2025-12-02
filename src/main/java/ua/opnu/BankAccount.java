package ua.opnu;

public class BankAccount {

    public double balance;         // TEST EXPECTS PUBLIC
    public double transactionFee;  // TEST EXPECTS PUBLIC

    // TEST REQUIRES DEFAULT CONSTRUCTOR
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

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount - transactionFee;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount + transactionFee > balance) return false;
        balance -= (amount + transactionFee);
        return true;
    }

    // TEST REQUIRES transfer(BankAccount, int)
    public boolean transfer(BankAccount other, int amount) {
        if (withdraw(amount)) {
            other.deposit(amount);
            return true;
        }
        return false;
    }
}
