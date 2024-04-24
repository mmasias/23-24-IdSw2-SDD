package Models;

import Enums.TimesOfDay;

public class Time {

  private TimesOfDay timeOfDay;
  private int currentTime;

  public void advanceTime() {
    int minutes = currentTime % 100;
    int hours = currentTime / 100;

    minutes += 15;
    if (minutes >= 60) {
      hours++;
      minutes = 0;
    }

    if (hours > 23) {
      hours = 0;
    }

    currentTime = hours * 100 + minutes;
  }

  //TODO: No se usa el método setTimeOfDay
  public void setTimeOfDay(int currentTime) {
    if (currentTime >= 600 || currentTime <= 1200) {
      this.timeOfDay = TimesOfDay.Morning;
    } else if (currentTime >= 1215 || currentTime <= 1600) {
      this.timeOfDay = TimesOfDay.Afternoon;
    } else if (currentTime >= 1615 || currentTime <= 2200) {
      this.timeOfDay = TimesOfDay.Evening;
    } else {
      this.timeOfDay = TimesOfDay.Night;
    }
  }

  //TODO: No se usa el método resetDay
  public void resetDay() {
    if (currentTime > 2345) {
      currentTime = 0;
    }
  }

  public TimesOfDay getTimeOfDay() {
    return timeOfDay;
  }

  public int getCurrentTime() {
    return currentTime;
  }
}
