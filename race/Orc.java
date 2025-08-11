package race;

public class Orc extends Race {
  private int hp = 120;    // min amount a Human warrior starts with
  private int atk = 13; 
  private int def = 12;
  private int spd = 7;

  public Orc() {
    super("Orc");
                                         // 0 - 59          + 200 = 200 to 259
    super.setHp(this.hp);
    super.setAtk(this.atk);
    super.setDef(this.def);
    super.setSpd(this.spd);
  }

  public void specialAbility() {
    System.out.println("Orc special ability activated! Boosting attack by 3.");
    this.atk += 3;
  }

  // getters

  // setters

} // class