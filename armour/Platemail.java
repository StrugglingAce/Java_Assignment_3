package armour;

public class Platemail extends Armour {
  // should be a calc with damage NOT a straight protection amount
  private int defBonus = 6;
  private int hpBonus = 20;
  private int spdModifier = -3;

  public Platemail() {
    super("Platemail");
    super.setDefBonus(defBonus);
    super.setHpBonus(hpBonus);
    super.setSpdModifier(spdModifier);
  }

} // class