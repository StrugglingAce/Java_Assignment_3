package armour;

public class Leather extends Armour {
  private int armourAmount = 30;
  private int dexCost = 5;
  private int armourDurabilityFactor = 10;

  public Leather() {
    super("Leather");
    super.setArmourAmount(armourAmount);
    super.setDexCost(dexCost);
  }

  // setters
  public void setArmourReduction(int damageAmount) {
    // 10 damage would take away 1 armour points
    this.armourAmount -= damageAmount / armourDurabilityFactor;
  }

} // class