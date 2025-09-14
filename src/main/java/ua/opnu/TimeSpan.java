package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Hours and minutes must be non-negative");
        }
        this.hours = hours + minutes / 60;
        this.minutes = minutes % 60;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        int totalMinutes = this.minutes + minutes;
        this.hours += hours + totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void addTimeSpan(TimeSpan timespan) {
        add(timespan.hours, timespan.minutes);
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        int totalMinutes1 = getTotalMinutes();
        int totalMinutes2 = span.getTotalMinutes();
        int result = totalMinutes1 - totalMinutes2;
        if (result < 0) {
            throw new IllegalArgumentException("Resulting TimeSpan cannot be negative");
        }
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor < 0) {
            throw new IllegalArgumentException("Scale factor must be non-negative");
        }
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    @Override
    public String toString() {
        return String.format("%d hours %d minutes", hours, minutes);
    }
}
