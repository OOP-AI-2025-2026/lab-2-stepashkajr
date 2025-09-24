package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int hours, int minutes) {
        setTime(hours, minutes);
    }

    private void setTime(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
            return;
        }
        int totalMinutes = hours * 60 + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int addHours, int addMinutes) {
        if (addHours < 0 || addMinutes < 0) return; 
        int totalMinutes = getTotalMinutes() + addHours * 60 + addMinutes;
        setTime(totalMinutes / 60, totalMinutes % 60);
    }

    public void addTimeSpan(TimeSpan span) {
        if (span == null) return;
        add(span.getHours(), span.getMinutes());
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        if (span == null) return;
        int diff = getTotalMinutes() - span.getTotalMinutes();
        if (diff < 0) return; 
        setTime(diff / 60, diff % 60);
    }

    public void scale(int factor) {
        if (factor <= 0) return; 
        int totalMinutes = getTotalMinutes() * factor;
        setTime(totalMinutes / 60, totalMinutes % 60);
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}

