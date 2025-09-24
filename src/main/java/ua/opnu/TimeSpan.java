package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan() {
        this(0, 0);
    }

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
        if (addHours < 0 || addMinutes < 0) throw new IllegalArgumentException();
        int total = getTotalMinutes() + addHours * 60 + addMinutes;
        hours = total / 60;
        minutes = total % 60;
    }

    public void addTimeSpan(TimeSpan span) {
        if (span == null) throw new IllegalArgumentException();
        add(span.getHours(), span.getMinutes());
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        if (span == null) throw new IllegalArgumentException();
        int diff = getTotalMinutes() - span.getTotalMinutes();
        if (diff < 0) throw new IllegalArgumentException();
        hours = diff / 60;
        minutes = diff % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) throw new IllegalArgumentException();
        int total = getTotalMinutes() * factor;
        hours = total / 60;
        minutes = total % 60;
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSpan)) return false;
        TimeSpan ts = (TimeSpan) o;
        return this.hours == ts.hours && this.minutes == ts.minutes;
    }

    @Override
    public int hashCode() {
        return hours * 31 + minutes;
    }
}
