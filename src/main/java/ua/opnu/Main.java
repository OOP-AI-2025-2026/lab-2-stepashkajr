package ua.opnu;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Serhii", 1000.0);

        System.out.println("Власник: " + acc.getOwner());
        System.out.println("Баланс: " + acc.getBalance());

        acc.deposit(500.0);
        System.out.println("Після депозиту 500: " + acc.getBalance());

        acc.setTransactionFee(50.0);
        boolean success = acc.withdraw(200.0);
        System.out.println("Спроба зняти 200 з комісією 50: " + (success ? "успішно" : "не успішно"));
        System.out.println("Баланс після зняття: " + acc.getBalance());
    }
}
