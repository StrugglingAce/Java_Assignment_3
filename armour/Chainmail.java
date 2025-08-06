package armour;

public class Chainmail extends Armour {
  private int armourAmount = 75;
  private int dexCost = 25;
  private int armourDurabilityFactor = 12;

  public Chainmail() {
    super("Chainmail");
    super.setArmourAmount(armourAmount);
    super.setDexCost(dexCost);
  }

  // setters
  public void setArmourReduction(int damageAmount) {
    // 10 damage would take away 1 armour points
    this.armourAmount -= damageAmount / armourDurabilityFactor;
  }

} // class