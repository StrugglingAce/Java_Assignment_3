package armour;

public class Robe extends Armour {
  private int defBonus = 0;
  private int hpBonus = 5;
  private int spdModifier = 3;

  public Robe() {
    super("Robe");
    super.setDefBonus(defBonus);
    super.setHpBonus(hpBonus);
    super.setSpdModifier(spdModifier);
  }

  // setters

} // class