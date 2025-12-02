package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(TimeSpan other) {
        this.hours += other.hours;
        this.minutes += other.minutes;
        normalize();
    }

    public void subtract(TimeSpan other) {
        this.hours -= other.hours;
        this.minutes -= other.minutes;
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
        if (hours < 0) hours = 0;
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}
