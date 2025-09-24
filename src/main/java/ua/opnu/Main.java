package ua.opnu;

public class Main {
    public static void main(String[] args) {
        
        BankAccount acc = new BankAccount(1000.0, 5.0);
        System.out.println("Balance: " + acc.getBalance());
        System.out.println("Transaction Fee: " + acc.getTransactionFee());

        TimeSpan ts1 = new TimeSpan(2, 30); 
        TimeSpan ts2 = new TimeSpan(1, 45); 
        
        ts1.add(ts2.getHours(), ts2.getMinutes());
        System.out.println("Sum of time spans: " + ts1);

        ts1.subtract(ts2.getHours(), ts2.getMinutes());
        System.out.println("Difference of time spans: " + ts1);
    }
}
