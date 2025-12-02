package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount > 0) {
            double total = amount + transactionFee;
            if (balance >= total) {
                balance = balance - total;
                return true;
            }
        }
        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null) return false;
        if (amount > 0) {
            double total = amount + transactionFee;
            if (balance >= total) {
                balance = balance - total;
                receiver.balance = receiver.balance + amount;
                return true;
            }
        }
        return false;
    }
}
