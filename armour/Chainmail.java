package armour;

public class Chainmail extends Armour {
  private int defBonus = 4;
  private int hpBonus = 15;
  private int spdModifier = -1;

  public Chainmail() {
    super("Chainmail");
    super.setDefBonus(defBonus);
    super.setHpBonus(hpBonus);
    super.setSpdModifier(spdModifier);
  }

  // setters

} // class