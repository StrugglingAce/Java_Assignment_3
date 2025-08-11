package weapon;

import java.util.Random;

public abstract class Weapon {
  private String type;
  private int atkBonus;   // base damage of the weapon
  private int spdModifier;  // how much the weapons slows a player down (dex cost) 
  protected Random randNum = new Random();
  
  public Weapon(String type) {
    this.type = type;
  } // constructor()

  // getters
  public String getType() {
    return this.type;
  } // getType()
  public int getAtkBonus() {
    return this.atkBonus;
  } // getDamageAmount()
  public int getSpdModifier() {
    return this.spdModifier;
  } // getSpdModifier()
  
  // setters
  public void setType(String type) {
    this.type = type;
  } // setType()
  public void setAtkBonus(int atkBonus) {
    this.atkBonus = atkBonus;
  } // setDamageAmount()
  public void setSpdModifier(int spdModifier) {
    this.spdModifier = spdModifier;
  } // set spd modifier
   
} // class