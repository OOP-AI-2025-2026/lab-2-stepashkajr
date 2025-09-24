package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid hours or minutes");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int addHours, int addMinutes) {
        if (addHours < 0 || addMinutes < 0 || addMinutes > 59) {
            throw new IllegalArgumentException("Invalid hours or minutes to add");
        }
        int totalMinutes = getTotalMinutes() + addHours * 60 + addMinutes;
        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;
    }

    public void addTimeSpan(TimeSpan span) {
        add(span.getHours(), span.getMinutes());
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        int diff = getTotalMinutes() - span.getTotalMinutes();
        if (diff < 0) {
            throw new IllegalArgumentException("Cannot subtract larger timespan");
        }
        hours = diff / 60;
        minutes = diff % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be > 0");
        }
        int totalMinutes = getTotalMinutes() * factor;
        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}
