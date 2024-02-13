package models;

public class Potion {
  private int healAmount;

  public Potion() {
    this.healAmount = 20;
  }

  public int getHealAmount() {
    return this.healAmount;
  }

  public int heal(int actualLife) {
    return actualLife + this.healAmount;
  }

}
