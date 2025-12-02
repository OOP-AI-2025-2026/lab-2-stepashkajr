package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        }
        if (minutes < 0) {
            hours -= (Math.abs(minutes) + 59) / 60;
            minutes = 60 - (Math.abs(minutes) % 60);
            if (minutes == 60) minutes = 0;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // --- TESTS REQUIRE THIS ---
    public void add(TimeSpan other) {
        this.hours += other.hours;
        this.minutes += other.minutes;
        normalize();
    }

    // --- TESTS REQUIRE THIS ---
    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    // --- TEST EXPECTS THIS NAME ---
    public void addTimeSpan(TimeSpan span) {
        add(span);
    }

    // --- TESTS REQUIRE THIS ---
    public void subtract(TimeSpan other) {
        this.hours -= other.hours;
        this.minutes -= other.minutes;
        normalize();
    }

    // --- TESTS REQUIRE THIS ---
    public void subtract(int hours, int minutes) {
        this.hours -= hours;
        this.minutes -= minutes;
        normalize();
    }

    // --- TESTS REQUIRE ---
    public double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    // --- TESTS REQUIRE ---
    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // --- TESTS REQUIRE ---
    public void scale(int factor) {
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
        normalize();
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}
