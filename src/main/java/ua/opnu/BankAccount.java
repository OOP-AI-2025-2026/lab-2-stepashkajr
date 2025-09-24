package ua.opnu;

public class BankAccount {

    private String owner;
    private double balance;
    private double transactionFee;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.transactionFee = 0.0;
    }

    public BankAccount() {
        this.owner = "";
        this.balance = 0.0;
        this.transactionFee = 0.0;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public void transfer(BankAccount other, int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            other.balance += amount;
        } else {
            System.out.println("Not enough money for transfer");
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount + transactionFee) {
            balance -= amount + transactionFee;
            return true;
        }
        return false;
    }
}
