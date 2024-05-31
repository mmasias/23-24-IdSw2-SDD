public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public void incrementTime() {
        this.minute++;
        if (this.minute >= 60) {
            this.minute = 0;
            this.hour++;
        }
    }

    public String getCurrentTime() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }

    public int getMinute() {
        return this.minute;
    }
}
