package weapon;

public class Dagger extends Weapon {
  private int atkBonus = 1;
  private int spdModifier = 3;

  public Dagger() {
    super("Dagger");
    super.setAtkBonus(atkBonus);
    super.setSpdModifier(spdModifier);
  } // constructor
  
} // class