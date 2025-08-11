package weapon;

public class Axe extends Weapon {
  private int atkBonus = 5;
  private int spdModifier = -1;

  public Axe() {
    super("Axe");
    super.setAtkBonus(atkBonus);
    super.setSpdModifier(spdModifier);
  } // constructor

} // class