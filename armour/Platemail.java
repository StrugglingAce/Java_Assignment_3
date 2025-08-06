package armour;

public class Platemail extends Armour {
  // should be a calc with damage NOT a straight protection amount
  private int armourAmount = 125; // 75 - 125 = -50 no damage!
  private int dexCost = 50;
  private int armourDurabilityFactor = 15;

  public Platemail() {
    super("Platemail");
    super.setArmourAmount(armourAmount);
    super.setDexCost(dexCost);
  }

  // setters
  public void setArmourReduction(int damageAmount) {
    // 10 damage would take away 1 armour points
    this.armourAmount -= damageAmount / armourDurabilityFactor;
  }

} // class