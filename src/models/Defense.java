package models;

public class Defense {
  private double accuracy;

  public Defense() {
    this.accuracy = 0.8;
  }

  public double getAccuracy() {
    return this.accuracy;
  }

  public int defend(int incomingDamage) {
    if (Math.random() <= this.accuracy) {
      return incomingDamage - 5;
    } else {
      return incomingDamage;
    }
  }
}
