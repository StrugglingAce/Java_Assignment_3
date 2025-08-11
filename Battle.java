
import utility.*;
import weapon.*;
import armour.*;
import race.*;

import java.util.Random;

public class Battle {
  // object creation
  private static Random randNum = new Random();
  private static Ink ink = new Ink();
  private static Validator val = new Validator();
  private static Race player;
  private static Weapon pWeapon;
  private static Armour pArmour;
  private static Race enemy;
  private static Weapon eWeapon;
  private static Armour eArmour;

  // variables
  private static boolean gameOver = false;
  private static int warTypes = 4; // the number of warrior types
  private static int wepTypes = 4; // the number of weapon types
  private static int armTypes = 4; // the number of armour types
  private static int attackTypes = 4; // the number of attack types
  private static int pAttackDmg = 0; // the total damage done by player
  private static int eAttackDmg = 0; // the total damage done by enemy
  private static int playerHeavyCooldown = 0;
  private static int enemyHeavyCooldown = 0;
  private static int playerSpecialAbility = 0; // for one-time use
  private static int enemySpecialAbility = 0;  // for one-time use
  private static boolean pHit = false;  // if player hit or not
  private static boolean eHit = false;  // if enemy hit or not
  private static boolean pDefend = false;  // for one-time use
  private static boolean eDefend = false;  // for one-time use



  public static void main(String[] args) {
    ink.welcome();
    ink.intro();
    gameSetup();

    //================================>>
    //=== Main game loop ==>>
    while(!gameOver) {
      ink.attackMenu();
      int attackType = val.validateAttackPick(attackTypes);

      switch (attackType) {
        case 1:
          pAttackDmg = attack(player.getAtk(), enemy.getDef(), pWeapon.getAtkBonus(), eArmour.getDefBonus(), player.getSpd(), enemy.getSpd());
          break;
        case 2:
          if (playerHeavyCooldown == 0) {
            pAttackDmg = heavyAttack(player.getAtk(), enemy.getDef(), pWeapon.getAtkBonus(), eArmour.getDefBonus(), player.getSpd(), enemy.getSpd());
            playerHeavyCooldown = 2; //place on cooldown
          }
          else {
            System.out.printf("Heavy attack is on cooldown for %d more turns", playerHeavyCooldown);
            System.out.println("Player uses basic attack instead");
            pAttackDmg = attack(player.getAtk(), enemy.getDef(), pWeapon.getAtkBonus(), eArmour.getDefBonus(), player.getSpd(), enemy.getSpd());
          }
          break;
        case 3:
          System.out.println("Player is defending this turn.");
          pDefend = true;
          pAttackDmg = 0;
          break;
        case 4:
          if (playerSpecialAbility == 0) {
            player.specialAbility();
            System.out.println("Player uses their Special ability.");
            playerSpecialAbility = 1;
            ink.attackMenu();
          }
          else {
            System.out.println("Special ability already used.");
            System.out.println("Player uses basic attack instead");
            pAttackDmg = attack(player.getAtk(), enemy.getDef(), pWeapon.getAtkBonus(), eArmour.getDefBonus(), player.getSpd(), enemy.getSpd());

            ink.attackMenu();;
          }
          break;
         
        default:
          System.out.println("Oops");
        break;
      }

      pAttackDmg = damageCalc(pAttackDmg, eDefend);//calc total dmg

      pHit = outcome(pAttackDmg, pHit); //if player hit or not

      if (pHit) {
        enemy.setHp(enemy.getHp() - pAttackDmg);
      }//reduce enemy hp

      if (enemy.getHp() <= 0 ) {
        gameOver = true;
      }// check player wins

      ink.battleResult(pAttackDmg, "player" , player, enemy, "enemy", pHit);


      int enemyAction = randNum.nextInt(4) + 1;

      switch (enemyAction) {
        case 1:
          eAttackDmg = attack(enemy.getAtk(), player.getDef(), eWeapon.getAtkBonus(), pArmour.getDefBonus(), enemy.getSpd(), player.getSpd());
          break;
        case 2:
          if (enemyHeavyCooldown == 0) {
            eAttackDmg = heavyAttack(enemy.getAtk(), player.getDef(), eWeapon.getAtkBonus(), pArmour.getDefBonus(), enemy.getSpd(), player.getSpd());
            enemyHeavyCooldown = 2;
          }
          else {
            eAttackDmg = attack(enemy.getAtk(), player.getDef(), eWeapon.getAtkBonus(), pArmour.getDefBonus(), enemy.getSpd(), player.getSpd());
          }
          break;
        case 3:
          System.out.println("Enemy is defending this turn.");
          eDefend = true;
          break;
        case 4:
          if (enemySpecialAbility == 0) {
            enemy.specialAbility();
            System.out.println("Enemy uses their Special ability.");
            enemySpecialAbility = 1;
            eAttackDmg = attack(enemy.getAtk(), player.getDef(), eWeapon.getAtkBonus(), pArmour.getDefBonus(), enemy.getSpd(), player.getSpd());
            break;
          }
          else {
            System.out.println("Special ability already used.");
            System.out.println("Enemy uses basic attack instead");
            eAttackDmg = attack(enemy.getAtk(), player.getDef(), eWeapon.getAtkBonus(), pArmour.getDefBonus(), enemy.getSpd(), player.getSpd());
            break;
          }
        default:
          break;
      }

      if (player.getHp() <= 0 ){
        gameOver = true;
      }

      eAttackDmg = damageCalc(eAttackDmg, pDefend);

      eHit = outcome(eAttackDmg, eHit); //if enemy hit or not

      if (eHit) {
        player.setHp(player.getHp() - eAttackDmg);
      }//reduce player hp
 
      ink.battleResult(eAttackDmg, "enemy" , enemy, player, "player", eHit);

      if (player.getHp() <= 0 ){
        gameOver = true;
      }


      if (player.getHp() <= 0 || enemy.getHp() <= 0) {
        gameOver = true;
      }

      if (player.getHp() > enemy.getHp()) {
        System.out.println("Player wins");
      }
      else {
        System.out.println("Enemy wins");
      }

      System.err.println("Restart?");
      



      if (playerHeavyCooldown > 0) {
        playerHeavyCooldown--;
      }
      if (enemyHeavyCooldown > 0) {
        enemyHeavyCooldown--;
      }
    } // while


  } // main()

  ///////////////////////
  // helper methods
  private static void gameSetup() {
    ////////////////////////////
     /// PLAYER CREATION ////////

     //============================================>>
     //=== Warrior selection/creation ==>>
     ink.raceMenu(); // prints the Warrior selection menu
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
     warPick = randNum.nextInt(4) + 1;
     createWarrior("Enemy", warPick);

     //============================================>>
     //=== Weapon selection/creation ==>>
     wepPick = randNum.nextInt(4) + 1;
     createWeapon("Enemy", wepPick);

     //============================================>>
     //=== Armour selection/creation ==>>
     armPick = randNum.nextInt(4) + 1;
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
      case 4: // orc
        if(who.equals("Player"))
          player = new Dwarf();
        else 
          enemy = new Dwarf();
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
      case 4: // Warhammer
        if(who.equals("Player"))
          pWeapon = new Warhammer();
        else
          eWeapon = new Warhammer();
        break;
    
      default:
        System.out.println("oops!");
        break;
    }
  } // createWeapon()

  private static void createArmour(String who, int choice) {
    switch (choice) {
      case 1: // Robe
        if(who.equals("Player"))
          pArmour = new Robe();
        else 
          eArmour = new Robe();
        break;
      case 2: // leather
        if(who.equals("Player"))
          pArmour = new Leather();
        else 
          eArmour = new Leather();
        break;
      case 3: // chainmail
        if(who.equals("Player"))
          pArmour = new Chainmail();
        else 
          eArmour = new Chainmail();
        break;
      case 4: // platemail
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

  private static int attack(int attackerAtk, int defenderDef, int attackerWeapon, int defenderArmour, int attackerSpd, int defenderSpd) {
    int baseAtk = attackerAtk + attackerWeapon;
    int finalAtk = 0;

    int critChance = (attackerSpd - defenderSpd) * 2;
    if (critChance < 5) {
      critChance = 5;
    }
    if (critChance > 50) {
      critChance = 50;
    }
    boolean isCrit = false;
    int chance = randNum.nextInt(100) + 1;
    if (chance < critChance) {
      isCrit = true;
    }
    else {
      isCrit = false;
    }

    if (isCrit) {
      baseAtk *= 2;
    }

    int dodgeChance = (defenderSpd - attackerSpd) * 2;
    if (dodgeChance < 5) {
      dodgeChance = 5;
    }
    if (dodgeChance > 50) {
      dodgeChance = 50;
    }
    boolean dodged = false;
    int dodgeRoll = randNum.nextInt(100) + 1;
    if (dodgeRoll < dodgeChance) {
      dodged = true;
    }
    else {
      dodged = false;
    }

    if (dodged) {
      baseAtk = 0;
    }

    finalAtk = baseAtk - (defenderDef + defenderArmour);
    if (finalAtk < 0) {
      finalAtk = 0;
    }
    return finalAtk;
  }

  private static int heavyAttack(int attackerAtk, int defenderDef, int attackerWeapon, int defenderArmour, int attackerSpd, int defenderSpd) {
    int baseAtk = attackerAtk + attackerWeapon + 7; // heavy atk has a magic variable of 7 for now to make its damage higher than basic attack
    int finalAtk = 0;

    int critChance = (attackerSpd - defenderSpd) * 2;
    if (critChance < 5) {
      critChance = 5;
    }
    if (critChance > 50) {
      critChance = 50;
    }
    boolean isCrit = false;
    int chance = randNum.nextInt(100) + 1;
    if (chance < critChance) {
      isCrit = true;
    }
    else {
      isCrit = false;
    }

    if (isCrit) {
      baseAtk *= 2;
    }

    int dodgeChance = (defenderSpd - attackerSpd) * 2;
    if (dodgeChance < 5) {
      dodgeChance = 5;
    }
    if (dodgeChance > 50) {
      dodgeChance = 50;
    }
    boolean dodged = false;
    int dodgeRoll = randNum.nextInt(100) + 1;
    if (dodgeRoll < dodgeChance) {
      dodged = true;
    }
    else {
      dodged = false;
    }

    if (dodged) {
      baseAtk = 0;
    }

    finalAtk = baseAtk - (defenderDef + defenderArmour);
    if (finalAtk < 0) {
      finalAtk = 0;
    }
    return finalAtk;
  }

  public static int damageCalc(int dmgDealt, boolean isDefending) {
    if (dmgDealt > 0) {
      if (isDefending) {
        dmgDealt /= 2;
        if (dmgDealt < 0) {
          dmgDealt = 0;
        }
        return dmgDealt;
      }
    }
    else {
      return dmgDealt;
    }
    return dmgDealt;
  }

  public static boolean outcome(int attackDmg, boolean hit) {
    if (attackDmg > 0) {
      hit = true;
      return hit;
    }
    else {
      hit = false;
      return hit;
    }
  }

} // class