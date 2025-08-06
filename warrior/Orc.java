package warrior;

public class Orc extends Warrior {
  private int minHealth = 280;    // min amount a Orc warrior starts with
  private int healthBonus = 100;  // the bonus or extra range for the health stat
  private int minStrength = 150; 
  private int strengthBonus = 80;  
  private int minDexterity = 20;
  private int dexterityBonus = 30;

  public Orc() {
    super("Orc");
                                         // 0 - 99          + 280 = 280 to 379
    super.setHealth(super.randNum.nextInt(this.healthBonus) + this.minHealth);
    super.setStrength(super.randNum.nextInt(this.strengthBonus) + this.minStrength);
    super.setDexterity(super.randNum.nextInt(this.dexterityBonus) + this.minDexterity);
  }

  // getters

  // setters
  
} // class