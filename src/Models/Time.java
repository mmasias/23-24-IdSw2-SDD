package Models;

import Enums.ImpreciseTime;
public class Time {
  private ImpreciseTime impreciseTime;
  private int preciseTime;
  public Time() {
    this.impreciseTime = ImpreciseTime.Morning;
    initializeTime();
  }
  private void initializeTime() {
    setPreciseTime(600);
    updateImpreciseTime(getPreciseTime());
  }
  protected void advanceTime() {
    int currentMinutes = getPreciseTime() % 100;
    int currentHours = getPreciseTime() / 100;

    currentMinutes += 15;

    if (currentMinutes >= 60) {
      currentHours++;
      currentMinutes -= 60;
    }

    if (currentHours > 23) {
      currentHours = 0;
    }

    setPreciseTime(currentHours * 100 + currentMinutes);
    updateImpreciseTime(getPreciseTime());
  }
  private void updateImpreciseTime(int currentTime) {
    if (currentTime >= 600 && currentTime < 1200) {
      this.impreciseTime = ImpreciseTime.Morning;
    } else if (currentTime >= 1200 && currentTime < 1615) {
      this.impreciseTime = ImpreciseTime.Afternoon;
    } else if (currentTime >= 1615 && currentTime < 2200) {
      this.impreciseTime = ImpreciseTime.Evening;
    } else {
      this.impreciseTime = ImpreciseTime.Night;
    }
  }

  public ImpreciseTime getImpreciseTime() {
    return impreciseTime;
  }
  private int getPreciseTime() {
    return preciseTime;
  }
  private void setPreciseTime(int preciseTime) {
    this.preciseTime = preciseTime;
  }
  public String getPreciseTimeFormatted() {
    int hours = getPreciseTime() / 100;
    int minutes = getPreciseTime() % 100;
    return String.format("%02d:%02d", hours, minutes);
  }

}
