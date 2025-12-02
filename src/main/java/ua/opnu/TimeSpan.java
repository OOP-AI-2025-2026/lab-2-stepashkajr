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
        int total = hours * 60 + minutes;
        if (total < 0) total = 0;

        hours = total / 60;
        minutes = total % 60;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // ==== REQUIRED BY TEST ====

    public void add(TimeSpan other) {
        this.hours += other.hours;
        this.minutes += other.minutes;
        normalize();
    }

    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void addTimeSpan(TimeSpan span) {
        add(span);
    }

    public void subtract(TimeSpan other) {
        this.hours -= other.hours;
        this.minutes -= other.minutes;
        normalize();
    }

    public void subtract(int hours, int minutes) {
        this.hours -= hours;
        this.minutes -= minutes;
        normalize();
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void scale(int factor) {
        int total = getTotalMinutes() * factor;
        hours = total / 60;
        minutes = total % 60;
        normalize();
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}

