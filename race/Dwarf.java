package race;

public class Dwarf extends Race {
  private int hp = 110;
  private int atk = 9;
  private int def = 14;
  private int spd = 8;

  public Dwarf() {
    super("Dwarf");
    super.setHp(this.hp);
    super.setAtk(this.atk);
    super.setDef(this.def);
    super.setSpd(this.spd);
  }

  public void specialAbility() {
    System.out.println("Dwarf special ability activated! Boosting defence by 3.");
      this.def += 3;
  }

  // getters

  // setters

} // class