package race;

import java.util.Random;

public abstract class Race {
  private String type;
  private int hp;     // the amount of health points, hit zero and you are defeated
  private int atk;   // the Attack you have, used for hit damage
  private int def;  // the Defence, affects damage reduction
  private int spd;  // the Speed, affects turn, dodge and crit chance
  
  protected Random randNum = new Random();

   public Race(String type) {
     this.type = type;
   }

   // getters 
   public String getType() {
     return this.type;
   } // getType()
   public int getHp() {
     if(this.hp < 0)
      return 0;
     else 
      return this.hp;
   } // getHp()
   public int getAtk() {
     return this.atk;
   } // getAtk()
   public int getDef() {
     return this.def;
   } // getDef()
   public int getSpd() {
     return this.spd;
   } // getSpd()

   public abstract void specialAbility();

   // setters
   public void setType(String type) {
     this.type = type;
   } // setType()
   public void setHp(int hp) {
     this.hp = hp;
   } // setHP()
   public void setAtk(int atk) {
     this.atk = atk;
   } // setAtk()
   public void setDef(int def) {
     this.def = def;
   } // setDef()
   public void setSpd(int spd) {
     this.spd = spd;
   } // setSpd()

} // class