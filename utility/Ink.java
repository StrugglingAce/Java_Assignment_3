package utility;

import warrior.Warrior;
import weapon.*;
import armour.*;

public class Ink {
  // ANSI escape codes
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m"; // not really black
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";

  public Ink() {} // zero-arg constructor

  public void welcome() {
    System.out.println("=================================");
    System.out.println("== Welcome to the Warsim 2025! ==");
    System.out.println("=================================");
  } // welcome()

  public void warriorMenu() {
    System.out.println("\n===============================");
    System.out.println("== Select your warrior...");
    System.out.println("== 1) Human");
    System.out.println("== 2) Elf");
    System.out.println("== 3) Orc");
    System.out.println("===============================\n");
  } // warriorMenu()

  public void weaponMenu() {
    System.out.println("\n===============================");
    System.out.println("== Select your weapon...");
    System.out.println("== 1) Dagger");
    System.out.println("== 2) Sword");
    System.out.println("== 3) Axe");
    System.out.println("===============================\n");
  } // weaponMenu()

  public void armourMenu() {
    System.out.println("\n===============================");
    System.out.println("== Select your armour...");
    System.out.println("== 1) Leather");
    System.out.println("== 2) Chainmail");
    System.out.println("== 3) Platemail");
    System.out.println("===============================\n");
  } // armourMenu()

  public void attackMenu() {
    System.out.println("\n===============================");
    System.out.println("== Choose your attack:");
    System.out.println("== 1) Normal");
    System.out.println("== 2) Heavy");
    // System.out.println("== 3) Ability");
    System.out.println("===============================\n");
  } // attackMenu()

  public void printTurnResults(String attacker, int damage, String defender, Warrior warrior) {
    System.out.printf("%s hits for %d points, %s has %d health remaining...%n",
      attacker, damage, defender, warrior.getHealth());
  }

  public void attackResult(int damage, Warrior warrior, String who) {
    if(damage > 0) {
      System.out.printf(GREEN + "%n%s %s HITS for %d points!%n", who, warrior.getType(), damage);
      System.out.printf("%d health points removed!%n", damage);
      System.out.printf("%d health points remain!%n" + RESET, warrior.getHealth());
      System.out.println();
    }
    else {
      // System.out.println(RED + "This text is red!" + RESET);
      System.out.printf(RED + "%n%s %s MISSES!%n" + RESET, who, warrior.getType());
    }
  } // attackResult()

  public void printWarriorStats(Warrior player, Weapon pWeapon, Armour pArmour,
    Warrior enemy, Weapon eWeapon, Armour eArmour) {
    System.out.println("\n====================================");
    System.out.printf("Player(%s) STATS:%n", player.getType());
    System.out.printf("== Weapon(%s) Armour(%s)%n", pWeapon.getType(), pArmour.getType());
    System.out.printf("== Health      %12d%n", player.getHealth());
    System.out.printf("== Strength    %12d%n", player.getStrength());
    System.out.printf("== Dexterity   %12d%n", player.getDexterity());
    System.out.println("====================================");
    System.out.println("====================================");
    System.out.printf("Enemy(%s) STATS:%n", enemy.getType());
    System.out.printf("== Weapon(%s) Armour(%s)%n", eWeapon.getType(), eArmour.getType());
    System.out.printf("== Health      %12d%n", enemy.getHealth());
    System.out.printf("== Strength    %12d%n", enemy.getStrength());
    System.out.printf("== Dexterity   %12d%n", enemy.getDexterity());
    System.out.println("====================================\n");
  } // printWarriorStats()
   
} // class