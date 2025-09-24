package ua.opnu;

public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee;

    public BankAccount(String name, double balance) {
        if (balance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double fee) {
        if (fee < 0) throw new IllegalArgumentException("Fee cannot be negative");
        this.transactionFee = fee;
    }

    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) return;
        double totalDeduction = amount + transactionFee;
        if (totalDeduction <= balance) {
            balance -= totalDeduction;
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) return;
        double totalDeduction = amount + transactionFee;
        if (totalDeduction <= balance) {
            balance -= totalDeduction;
            receiver.deposit(amount);
        }
    }

    @Override
    public String toString() {
        return name + " : " + balance + " uah";
    }
}
