package ua.opnu;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000.0, 5.0);
        System.out.println("Balance: " + acc.getBalance());
        System.out.println("Transaction Fee: " + acc.getTransactionFee());

        acc.deposit(200);
        System.out.println("Balance after deposit: " + acc.getBalance());

        acc.withdraw(150);
        System.out.println("Balance after withdrawal: " + acc.getBalance());

        TimeSpan ts1 = new TimeSpan(2, 30);
        TimeSpan ts2 = new TimeSpan(1, 45);

        ts1.add(ts2);
        System.out.println("Sum of time spans: " + ts1);

        ts1.subtract(ts2);
        System.out.println("Difference of time spans: " + ts1);
    }
}
