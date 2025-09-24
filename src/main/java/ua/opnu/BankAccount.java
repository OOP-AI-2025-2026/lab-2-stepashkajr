package ua.opnu;

public class BankAccount {
    private double balance;
    private double transactionFee;
    private String owner;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        this.transactionFee = 0.0;
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public double getTransactionFee() { return transactionFee; }
    public void setTransactionFee(double transactionFee) { this.transactionFee = transactionFee; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount + transactionFee <= balance) {
            balance -= (amount + transactionFee);
            return true;
        }
        return false;
    }
}
