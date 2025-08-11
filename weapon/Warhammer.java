package weapon;

public class Warhammer extends Weapon {
  private int atkBonus = 7;
  private int spdModifier = -3;
  // private int hitChance = 50;

  public Warhammer() {
    super("Warhammer");
    super.setAtkBonus(atkBonus);
    super.setSpdModifier(spdModifier);
  } // constructor

}