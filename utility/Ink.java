package utility;

import weapon.*;
import armour.*;
import race.Race;
import java.util.Random;

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
    System.out.println("== Welcome to the " + BLUE +"Battlegrounds ==" + RESET);
    System.out.println("=================================");
  } // welcome()

  public void intro() {
    System.out.println("=================================");
    System.out.println("Four mighty races stand at the edge of glory...");
    System.out.println("Humans - resilient and adaptable warriors");
    System.out.println("Elves - swift and precise");
    System.out.println("Orcs - fierce brutes, unmatched in raw strength");
    System.out.println("Dwarves - stout defenders, armored like mountains\n");
    System.out.println("");

    System.out.println("The crowd roars as the gates creak open...");
    System.out.println("The sand beneath your feet is stained with the victories — and defeats — of countless champions.");
    System.out.println("Choose your race... and claim your place in the legend!");
    System.out.println("=================================");
  }

  public void raceMenu() {
    System.out.println("\n===============================");
    System.out.println("== Select your race...");
    System.out.println("== 1) Human");
    System.out.println("== 2) Elf");
    System.out.println("== 3) Orc");
    System.out.println("== 4) Dwarf");
    System.out.println("===============================\n");
  } // warriorMenu()

  public void weaponMenu() {
    System.out.println("\n===============================");
    System.out.println("== Select your weapon...");
    System.out.println("== 1) Dagger");
    System.out.println("== 2) Sword");
    System.out.println("== 3) Axe");
    System.out.println("== 4) Warhammer");
    System.out.println("===============================\n");
  } // weaponMenu()

  public void armourMenu() {
    System.out.println("\n===============================");
    System.out.println("== Select your armour...");
    System.out.println("== 1) Robe");
    System.out.println("== 2) Leather");
    System.out.println("== 3) Chainmail");
    System.out.println("== 4) Platemail");
    System.out.println("===============================\n");
  } // armourMenu()

  public void attackMenu() {
    System.out.println("\n===============================");
    System.out.println("== Choose your attack:");
    System.out.println("== 1) Basic Attack");
    System.out.println("== 2) Heavy");
    System.out.println("== 3) Defend");
    System.out.println("== 4) Special Ability");
    System.out.println("===============================\n");
  } // attackMenu()

  public void battleResult(int dmg, String attacker, Race aRace, Race dRace, String defender, boolean hit) {
    Random randomNum = new Random();
    int ranVar = randomNum.nextInt(4) + 1;
    if (hit) {
      switch (ranVar) {
        case 1:
          System.out.printf("%n %s %s slashes the %s %s for %d damage. That hit shook the battlefield!", attacker, aRace.getType(), defender, dRace.getType(), dmg);
          break;
        case 2:
          System.out.printf("%n %s %s swings at the %s %s for %d damage. A devastating blow lands cleanly!", attacker, aRace.getType(), defender, dRace.getType(), dmg);
          break;
        case 3:
          System.out.printf("%n %s %s relentlessly attacks the %s %s for %d damage. The attacks connects with brutal force!", attacker, aRace.getType(), defender, dRace.getType(), dmg);
          break;
        case 4:
          System.out.printf("%n %s %s elegantly hits the %s %s for %d damage. A precise strike right to the target!", attacker, aRace.getType(), defender, dRace.getType(), dmg);
          break;
      
        default:
          System.out.printf(GREEN + "%s %s HITS %s %S for %d damage.%n", attacker, aRace.getType(), defender, dRace.getType(), dmg);
          break;
      } 
      System.out.printf("%n%d health points removed!%n", dmg);
      System.out.printf("%s has %d health points remaining!%n" + RESET, defender, dRace.getHp());
      System.out.println();
    }
    else {
      switch (ranVar) {
        case 1:
          System.out.printf(RED + "%n%s %s MISSES! The attack whiffs through the air!%n" + RESET, attacker, aRace.getType());
          break;
        case 2:
          System.out.printf(RED + "%n%s %s MISSES! The strike misses by a hair's breadth!%n" + RESET, attacker, aRace.getType());
          break;
        case 3:
          System.out.printf(RED + "%n%s %s MISSES! The blow sails harmlessly past!%n" + RESET, attacker, aRace.getType());
          break;
        case 4:
          System.out.printf(RED + "%n%s %s MISSES! Were they even trying to hit the target?%n" + RESET, attacker, aRace.getType());
          break;
        default:
          System.out.printf(RED + "%n%s %s MISSES!%n" + RESET, attacker, aRace.getType());
          break;
      }  
    }
  } //battleResult


  public void printWarriorStats(Race player, Weapon pWeapon, Armour pArmour,
    Race enemy, Weapon eWeapon, Armour eArmour) {
    System.out.println("\n====================================");
    System.out.printf("Player(%s) STATS:%n", player.getType());
    System.out.printf("== Weapon(%s) Armour(%s)%n", pWeapon.getType(), pArmour.getType());
    System.out.printf("== Hp    %12d%n",player.getHp() + pArmour.getHpBonus());
    System.out.printf("== Atk   %12d%n", player.getAtk() + pWeapon.getAtkBonus());
    System.out.printf("== Def   %12d%n", player.getDef() + pArmour.getDefBonus());
    System.out.printf("== Spd   %12d%n", player.getSpd() + pWeapon.getSpdModifier() + pArmour.getSpdModifier());
    System.out.println("====================================");
    
    System.out.println("====================================");
    System.out.printf("Enemy(%s) STATS:%n", enemy.getType());
    System.out.printf("== Weapon(%s) Armour(%s)%n", eWeapon.getType(), eArmour.getType());
    System.out.printf("== Hp    %12d%n", enemy.getHp() + eArmour.getHpBonus());
    System.out.printf("== Atk   %12d%n", enemy.getAtk() + eWeapon.getAtkBonus());
    System.out.printf("== Def   %12d%n", enemy.getDef() + eArmour.getDefBonus());
    System.out.printf("== Spd   %12d%n", enemy.getSpd() + eWeapon.getSpdModifier() + eArmour.getSpdModifier());
    System.out.println("====================================\n");
  } // printWarriorStats()
   
} // class