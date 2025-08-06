package warrior;

import java.util.Random;

public abstract class Warrior {
  private String type;
  private int health;     // the amount of health points, hit zero and you are defeated
  private int strength;   // the strength you have, used for hit damage bonus
  private int dexterity;  // affects the chance to hit, higher dex = higher hit chance
  // dexterity here is skill of a player, it increase their hit chance
  
  protected Random randNum = new Random();

   public Warrior(String type) {
     this.type = type;
   }

   // getters 
   public String getType() {
     return this.type;
   } // getType()
   public int getHealth() {
     if(this.health < 0)
      return 0;
     else 
      return this.health;
   } // getHealth()
   public int getStrength() {
     return this.strength;
   } // getStrength()
   public int getDexterity() {
     return this.dexterity;
   } // getDexterity()

   // setters
   public void setType(String type) {
     this.type = type;
   } // setType()
   public void setHealth(int health) {
     this.health = health;
   } // setHealth()
   public void setStrength(int strength) {
     this.strength = strength;
   } // setStrength()
   public void setDexterity(int dexterity) {
     this.dexterity = dexterity;
   } // setDexterity()

   // takes health away from warrior
   public void reduceHealth(int damageAmount) {
     this.health -= damageAmount;
   }
} // class