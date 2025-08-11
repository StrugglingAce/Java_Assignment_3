package race;

public class Elf extends Race {
  private int hp = 90;
  private int atk = 11;
  private int def = 8;
  private int spd = 13;

  public Elf() {
    super("Elf");
    super.setHp(this.hp);
    super.setAtk(this.atk);
    super.setDef(this.def);
    super.setSpd(this.spd);
  }

  public void specialAbility() {
    System.out.println("Elf special ability activated! Boosting speed by 3.");
    this.spd += 3;
  }


  // getters

  // setters

} // class