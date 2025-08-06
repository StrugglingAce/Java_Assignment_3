
import utility.*;
import warrior.*;
import weapon.*;
import armour.*;

import java.util.Random;

public class Battle {
  // object creation
  private static Random randNum = new Random();
  private static Ink ink = new Ink();
  private static Validator val = new Validator();
  private static Warrior player;
  private static Weapon pWeapon;
  private static Armour pArmour;
  private static Warrior enemy;
  private static Weapon eWeapon;
  private static Armour eArmour;

  // variables
  private static boolean isPlayerTurn = true;
  private static boolean gameOver = false;
  private static int warTypes = 3; // the number of warrior types
  private static int wepTypes = 3; // the number of weapon types
  private static int armTypes = 3; // the number of armour types
  private static int attackTypes = 2; // the number of attack types

  public static void main(String[] args) {
     ink.welcome();
     gameSetup();

     //================================>>
     //=== Main game loop ==>>
     while(!gameOver) {
       if(isPlayerTurn) { // player's turn
         ink.attackMenu();
         int attackType = val.validateAttackPick(attackTypes);
         int damage = pWeapon.strike(attackType, player.getStrength(), player.getDexterity(), pArmour.getDexCost());
         damage -= eArmour.getArmourAmount();

         if(damage > 0) { // hit!
           enemy.reduceHealth(damage);
           // check to see if the enemy is defeated
           if(enemy.getHealth() <= 0) {
             System.out.println("Player Wins!");
             gameOver = true;
           }
         }
         else { // miss!
           // print missed message
         }
         ink.attackResult(damage, player, "Player");
       }
       else { // enemy's turn
         int attackType = randNum.nextInt(attackTypes);
         int damage = eWeapon.strike(attackType, enemy.getStrength(), enemy.getDexterity(), eArmour.getDexCost());
         damage -= pArmour.getArmourAmount();

         if(damage > 0) { // hit!
           player.reduceHealth(damage);
           // check to see if the enemy is defeated
           if(player.getHealth() <= 0) {
             System.out.println("Enemy Wins!");
             gameOver = true;
           }
         }
         else { // miss!
           // print missed message
         }
         ink.attackResult(damage, enemy, "Enemy");
       } 
       isPlayerTurn = !isPlayerTurn; // toggles whos turn it is
     } // while

  } // main()

  ///////////////////////
  // helper methods
  private static void gameSetup() {
    ////////////////////////////
     /// PLAYER CREATION ////////

     //============================================>>
     //=== Warrior selection/creation ==>>
     ink.warriorMenu(); // prints the Warrior selection menu
     int warPick = val.validatePick(warTypes);
     createWarrior("Player", warPick);

     //============================================>>
     //=== Weapon selection/creation ==>>
     ink.weaponMenu(); // prints the Weapon selection menu
     int wepPick = val.validatePick(wepTypes);
     createWeapon("Player", wepPick);

     //============================================>>
     //=== Armour selection/creation ==>>
     ink.armourMenu(); // prints the Armour selection menu
     int armPick = val.validatePick(armTypes);
     createArmour("Player", armPick);

     ///////////////////////////
     /// ENEMY CREATION ////////

     //============================================>>
     //=== Warrior selection/creation ==>>
     warPick = randNum.nextInt(3) + 1;
     createWarrior("Enemy", warPick);

     //============================================>>
     //=== Weapon selection/creation ==>>
     wepPick = randNum.nextInt(3) + 1;
     createWeapon("Enemy", wepPick);

     //============================================>>
     //=== Armour selection/creation ==>>
     armPick = randNum.nextInt(3) + 1;
     createArmour("Enemy", armPick);

     // print the player and enemy stats
     ink.printWarriorStats(player, pWeapon, pArmour, enemy, eWeapon, eArmour);
  }
  private static void createWarrior(String who, int choice) {
    switch (choice) {
      case 1: // human
        if(who.equals("Player"))
          player = new Human();
        else 
          enemy = new Human();
        break;
      case 2: // elf
        if(who.equals("Player"))
          player = new Elf();
        else 
          enemy = new Elf();
        break;
      case 3: // orc
        if(who.equals("Player"))
          player = new Orc();
        else 
          enemy = new Orc();
        break;
    
      default:
        System.out.println("oops!");
        break;
    }
  } // createWarrior()

  private static void createWeapon(String who, int choice) {
    switch (choice) {
      case 1: // dagger
        if(who.equals("Player"))
          pWeapon = new Dagger();
        else
          eWeapon = new Dagger();
        break;
      case 2: // sword
        if(who.equals("Player"))
          pWeapon = new Sword();
        else
          eWeapon = new Sword();
        break;
      case 3: // axe
        if(who.equals("Player"))
          pWeapon = new Axe();
        else
          eWeapon = new Axe();
        break;
    
      default:
        System.out.println("oops!");
        break;
    }
  } // createWeapon()

  private static void createArmour(String who, int choice) {
    switch (choice) {
      case 1: // leather
        if(who.equals("Player"))
          pArmour = new Leather();
        else 
          eArmour = new Leather();
        break;
      case 2: // chainmail
        if(who.equals("Player"))
          pArmour = new Chainmail();
        else 
          eArmour = new Chainmail();
        break;
      case 3: // platemail
        if(who.equals("Player"))
          pArmour = new Platemail();
        else 
          eArmour = new Platemail();
        break;
    
      default:
        System.out.println("oops!");
        break;
    }
  } // createArmour()

} // class