package ua.opnu;

public class BankAccount {
    private double balance;
    private double transactionFee;

    public BankAccount(double balance, double transactionFee) {
        this.balance = balance;
        this.transactionFee = transactionFee;
    }

   
    public BankAccount(double balance) {
        this(balance, 0);
    }

   
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    
    public void deposit(double amount) {
        balance += amount;
    }

   
    public boolean withdraw(double amount) {
        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            return true;
        } else {
            return false;
        }
    }
}
