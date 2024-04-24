package Models;

import Utils.TimesOfDay;

public class Time {
    private TimesOfDay timeOfDay;
    private int currentTime;

    public TimesOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(TimesOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}
