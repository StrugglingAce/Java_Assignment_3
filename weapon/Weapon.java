package weapon;

import java.util.Random;

public abstract class Weapon {
  private String type;
  private int damageAmount;   // base damage of the weapon
  private int dexterityCost;  // how much the weapons slows a player down (dex cost) 
  protected Random randNum = new Random();
  
  public Weapon(String type) {
    this.type = type;
  } // constructor()

  // getters
  public String getType() {
    return this.type;
  } // getType()
  public int getDamageAmount() {
    return this.damageAmount;
  } // getDamageAmount()
  public int getDexterityCost() {
    return this.dexterityCost;
  } // getDexterityCost()
  
  // abstract for a method is polymorphism! many forms!
  public abstract int strike(int attackType, int strength, int dexterity, int dexCost);

  // setters
  public void setType(String type) {
    this.type = type;
  } // setType()
  public void setDamageAmount(int damageAmount) {
    this.damageAmount = damageAmount;
  } // setDamageAmount()
  public void setDexterityCost(int dexterityCost) {
    this.dexterityCost = dexterityCost;
  } // setDexterityCost()
   
} // class