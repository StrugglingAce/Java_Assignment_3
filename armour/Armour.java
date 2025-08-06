package armour;

public abstract class Armour {
  private String type;
  private int armourAmount;
  private int dexCost;

  public Armour(String type) {
    this.type = type;
  } // contructor

  // getters
  public String getType() {
    return this.type;
  }
  public int getArmourAmount() {
    return this.armourAmount;
  }
  public int getDexCost() {
    return this.dexCost;
  }

  // setters
  public void setType(String type) {
    this.type = type;
  }
  public void setArmourAmount(int armourAmount) {
    this.armourAmount = armourAmount;
  }
  public void setDexCost(int dexCost) {
    this.dexCost = dexCost;
  }
  public abstract void setArmourReduction(int damageAmount);

} // class 