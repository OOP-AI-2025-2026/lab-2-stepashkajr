package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // === Перевірка BankAccount ===
        BankAccount acc1 = new BankAccount("Deniza", 1000);
        BankAccount acc2 = new BankAccount("Kateryna", 500);

        System.out.println(acc1.name + " баланс: " + acc1.getBalance());
        System.out.println(acc2.name + " баланс: " + acc2.getBalance());

        acc1.deposit(200);
        System.out.println("Після депозиту: " + acc1.getBalance());

        acc1.withdraw(100);
        System.out.println("Після зняття: " + acc1.getBalance());

        acc1.transfer(acc2, 300);
        System.out.println("Після переводу:");
        System.out.println(acc1.name + " баланс: " + acc1.getBalance());
        System.out.println(acc2.name + " баланс: " + acc2.getBalance());

        // === Перевірка Student ===
        Student student = new Student("Oleh", 2);
        student.addCourse("Mathematics");
        student.addCourse("Programming");
        student.addCourse("History");

        System.out.println(student.getName() + ": кількість дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());

        // Виклик getCourses()
        String[] courses = student.getCourses();
        System.out.println(student.getName() + ": перелік дисциплін:");
        for (String course : courses) {
            System.out.println(" - " + course);
        }

        // Виклик dropAll()
        student.dropAll();
        System.out.println(student.getName() + ": після dropAll - " + student.getCourseCount());

        // === Перевірка TimeSpan ===
        TimeSpan span1 = new TimeSpan(2, 30);
        TimeSpan span2 = new TimeSpan(1, 45);

        span1.addTimeSpan(span2);
        System.out.println("Після додавання: " + span1.getHours() + " год " + span1.getMinutes() + " хв");

        System.out.println("Загалом годин: " + span1.getTotalHours());
        System.out.println("Загалом хвилин: " + span1.getTotalMinutes());

        span1.subtract(new TimeSpan(1, 15));
        System.out.println("Після віднімання: " + span1.getHours() + " год " + span1.getMinutes() + " хв");

        span1.scale(2);
        System.out.println("Після збільшення у 2 рази: " + span1.getHours() + " год " + span1.getMinutes() + " хв");
    }
}
