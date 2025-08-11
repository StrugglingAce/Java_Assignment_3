package race;

public class Human extends Race {
  private int hp = 100;    // min amount a Human warrior starts with
  private int atk = 10; 
  private int def = 10;
  private int spd = 10;

  public Human() {
    super("Human");
    super.setHp(this.hp);
    super.setAtk(this.atk);
    super.setDef(this.def);
    super.setSpd(this.spd);
  }

  public void specialAbility() {
    System.out.println("Human special ability activated! Boosting attack, defence and speed by 1.");
      this.atk += 1;
      this.def += 1;
      this.spd += 1;
  }
  
  // getters

  // setters

} // class