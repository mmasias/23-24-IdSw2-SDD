package models;

public class Attack {

  private int damage;
  private double accuracy;
  private boolean hasHit;

  public Attack(int damage, double accuracy) {
    this.damage = damage;
    this.accuracy = accuracy;
    this.hasHit = false;
  }

  public int getDamage() {
    return this.damage;
  }

  public double getAccuracy() {
    return this.accuracy;
  }

  public boolean hasHit() {
    return this.hasHit;
  }

  public int attack() {
    if (Math.random() <= this.accuracy) {
      this.hasHit = true;
      return this.damage;
    } else {
      this.hasHit = false;
      return 0;
    }
  }

}