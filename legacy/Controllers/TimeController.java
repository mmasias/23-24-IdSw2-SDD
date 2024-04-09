package Controllers;

import Models.Time;
import Utils.TimesOfDay;

public class TimeController {
    private final Time time;

    public TimeController(Time time) {
        this.time = time;
    }


    public void advanceTime(int minutes) {
        int newTime = time.getCurrentTime() + minutes;
        int hours = newTime / 100;
        int mins = newTime % 100;

        if (mins >= 60) {
            hours += mins / 60;
            mins = mins % 60;
        }

        hours = hours % 24;
        newTime = hours * 100 + mins;

        time.setCurrentTime(newTime);
        updateTimesOfDay();
    }

    public void resetTime() {
        time.setCurrentTime(0);
        updateTimesOfDay();
    }

    private void updateTimesOfDay() {
        int currentTime = time.getCurrentTime();
        if (currentTime >= 0 && currentTime < 600) {
            time.setTimeOfDay(TimesOfDay.Night);
        } else if (currentTime >= 600 && currentTime < 1200) {
            time.setTimeOfDay(TimesOfDay.Morning);
        } else if (currentTime >= 1200 && currentTime < 1800) {
            time.setTimeOfDay(TimesOfDay.Afternoon);
        } else if (currentTime >= 1800 && currentTime <= 2359) {
            time.setTimeOfDay(TimesOfDay.Evening);
        }
    }
}

