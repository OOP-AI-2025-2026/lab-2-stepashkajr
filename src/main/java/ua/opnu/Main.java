package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкт BankAccount
        BankAccount acc = new BankAccount(1000.0, 5.0);

        // Виводимо баланс і комісію
        System.out.println("Balance: " + acc.getBalance());
        System.out.println("Transaction Fee: " + acc.getTransactionFee());

        // Приклад використання TimeSpan
        TimeSpan ts1 = new TimeSpan(2, 30, 15); // 2 години, 30 хв, 15 сек
        TimeSpan ts2 = new TimeSpan(1, 45, 50); // 1 година, 45 хв, 50 сек

        // Додаємо час
        TimeSpan sum = ts1.add(ts2);
        System.out.println("Sum of time spans: " + sum);

        // Віднімаємо час
        TimeSpan diff = ts1.subtract(ts2);
        System.out.println("Difference of time spans: " + diff);
    }
}
