package armour;

public class Leather extends Armour {
  private int defBonus = 2;
  private int hpBonus = 10;
  private int spdModifier = 1;

  public Leather() {
    super("Leather");
    super.setDefBonus(defBonus);
    super.setHpBonus(hpBonus);
    super.setSpdModifier(spdModifier);
  }

  // setters

} // class