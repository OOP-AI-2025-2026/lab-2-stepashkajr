package ua.opnu;

import java.util.Arrays;

public class Student {
    private final String name;
    private final int year;
    private final String[] courses;
    private int courseCount;
    private static final int MAX_COURSES = 50;

    public Student(String name, int year) {
        this.name = (name == null || name.isEmpty()) ? "Unknown" : name;
        this.year = (year < 1 || year > 4) ? 1 : year;
        this.courses = new String[MAX_COURSES];
        this.courseCount = 0;
    }

    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) return;
        if (courseCount >= MAX_COURSES) return;
        courses[courseCount++] = courseName;
    }

    public void dropAll() {
        // очищаємо тільки заповнену частину масиву
        Arrays.fill(courses, 0, courseCount, null);
        courseCount = 0;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getTuition() {
        return year * 20000;
    }

    public String[] getCourses() {
        // Тут немає ручного копіювання — використано стандартний метод
        return Arrays.copyOf(courses, courseCount);
    }
