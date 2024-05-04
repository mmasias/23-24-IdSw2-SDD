package Models;

import Enums.TimesOfDay;

// (Veronika)
// TODO: #34 Refactor the class to improve method naming conventions and better differentiate between precise and imprecise time representations.
// TODO: #35 Implement initialization logic to set both preciseTime and impreciseTime correctly when a new Time object is instantiated.
// TODO: #36 Change method name from setTimeOfDay to updateImpreciseTime to more accurately describe its functionality.
// TODO: #37 Rename getCurrentTime to getPreciseTime to better differentiate it from the imprecise time representation.

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

  //TODO: Properly implement the reseting of the preciseTime after midnight
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
