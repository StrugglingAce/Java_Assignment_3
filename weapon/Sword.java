package weapon;

public class Sword extends Weapon {
  private int atkBonus = 3;
  private int spdModifier = 1;

  public Sword() {
    super("Sword");
    super.setAtkBonus(atkBonus);
    super.setSpdModifier(spdModifier);
  } // constructor

  // strike
  
} // class