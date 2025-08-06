package weapon;

public class Sword extends Weapon {
  private int baseDamage = 55;
  private int baseDexterityCost = 25;
  private int hitChance = 65;

  public Sword() {
    super("Sword");
    super.setDamageAmount(baseDamage);
    super.setDexterityCost(baseDexterityCost);
  } // constructor

  // strike
  public int strike(int attackType, int strength, int dexterity, int dexCost) {
    int damageAmount = 0;
    int roll = super.randNum.nextInt(100) + 1; 
    // 50 10 = 40
    roll -= dexterity / 10; // player dexterity hit chance is increased
    roll += this.baseDexterityCost / 10; // weapon dexterityCost hit chance reduced
    roll += dexCost / 10; // armour dexCost hit chance reduced
    
    // System.out.println("Roll: " + roll);
    
    if(roll <= this.hitChance) { // hit
      damageAmount = this.baseDamage + (super.randNum.nextInt(strength / 10) + 3) + 3;
      // System.out.println("Damage: " + damageAmount);
    }
    else { // miss
      // do nothing
    }

    return damageAmount;
  } // strike
  
} // class