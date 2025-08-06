package warrior;

public class Elf extends Warrior {
  private int minHealth = 220;    // min amount a Elf warrior starts with
  private int healthBonus = 80;  // the bonus or extra range for the health stat
  private int minStrength = 40; 
  private int strengthBonus = 30;  
  private int minDexterity = 200;
  private int dexterityBonus = 100;

  public Elf() {
    super("Elf");
                                         // 0 - 79          + 220 = 220 to 279
    super.setHealth(super.randNum.nextInt(this.healthBonus) + this.minHealth);
    super.setStrength(super.randNum.nextInt(this.strengthBonus) + this.minStrength);
    super.setDexterity(super.randNum.nextInt(this.dexterityBonus) + this.minDexterity);
  }

  // getters

  // setters
  
} // class