package warrior;

public class Dwarf extends Warrior {
   private int minHealth = 200;
   private int healthBonus = 60;
   private int minStrength = 50;
   private int strengthBonus = 50;
   private int minDexterity = 50;
   private int dexterityBonus = 20;

   public Dwarf() {
      super("Dwarf");
      super.setHealth(super.randNum.nextInt(this.healthBonus) + this.minHealth);
      super.setStrength(super.randNum.nextInt(this.strengthBonus) + this.minStrength);
      super.setDexterity(super.randNum.nextInt(this.dexterityBonus) + this.minDexterity);
   }
}
