package ua.opnu;


public class TimeSpan {

    private int hours;
    private int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours < 0  minutes < 0  minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0  minutes < 0  minutes > 59)
            return;
        int totalMinutes = this.getTotalMinutes() + hours * 60 + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        int totalMinutes = this.getTotalMinutes() + timespan.getTotalMinutes();
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    double getTotalHours() {
        return this.hours + this.minutes / 60.0;
    }

    int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    void subtract(TimeSpan span) {
        int total1 = this.getTotalMinutes();
        int total2 = span.getTotalMinutes();

        if (total2 > total1) {
            return;
        }

        int newTotal = total1 - total2;
        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            return;
        }

        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }
}

