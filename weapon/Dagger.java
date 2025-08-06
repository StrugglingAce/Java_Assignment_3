package weapon;

public class Dagger extends Weapon {
  private int baseDamage = 35;
  private int baseDexterityCost = 10;
  private int hitChance = 80;

  public Dagger() {
    super("Dagger");
    super.setDamageAmount(baseDamage);
    super.setDexterityCost(baseDexterityCost);
  } // constructor

  // strike
  public int strike(int attackType, int strength, int dexterity, int dexCost) {
    int damageAmount = 0;
    int roll = super.randNum.nextInt(100) + 1; 
    roll -= dexterity / 10;
    roll -= this.baseDexterityCost / 10; // weapon dexterity cost
    roll += dexCost / 10; // armour dexterity cost
    
    if(roll <= this.hitChance) { // hit
      damageAmount = this.baseDamage + (super.randNum.nextInt(strength / 10) + 1);
    }
    else { // miss
      // do nothing
    }

    return damageAmount;
  } // strike
  
} // class