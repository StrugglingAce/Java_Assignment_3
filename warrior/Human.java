package warrior;

public class Human extends Warrior {
  private int minHealth = 200;    // min amount a Human warrior starts with
  private int healthBonus = 60;  // the bonus or extra range for the health stat
  private int minStrength = 50; 
  private int strengthBonus = 50;  
  private int minDexterity = 50;
  private int dexterityBonus = 20;

  public Human() {
    super("Human");
                                         // 0 - 59          + 200 = 200 to 259
    super.setHealth(super.randNum.nextInt(this.healthBonus) + this.minHealth);
    super.setStrength(super.randNum.nextInt(this.strengthBonus) + this.minStrength);
    super.setDexterity(super.randNum.nextInt(this.dexterityBonus) + this.minDexterity);
  }

  // getters

  // setters

} // class