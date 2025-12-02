package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", 3);
        s.addCourse("Biology");
        s.addCourse("Chemistry");
        s.addCourse("Computer Science");
        s.addCourse("English");

        System.out.println("Student: " + s.getName());
        System.out.println("Number of courses: " + s.getCourseCount());
        System.out.println("Year of study: " + s.getYear());
        System.out.println("Tuition paid: " + s.getTuition() + " UAH");
    }
}
