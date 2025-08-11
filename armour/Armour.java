package armour;

public abstract class Armour {
  private String type;
  private int defBonus;
  private int hpBonus;
  private int spdModifier;

  public Armour(String type) {
    this.type = type;
  } // contructor

  // getters
  public String getType() {
    return this.type;
  }
  public int getDefBonus() {
    return this.defBonus;
  }
  public int getHpBonus() {
    return this.hpBonus;
  }
  public int getSpdModifier() {
    return this.spdModifier;
  }

  // setters
  public void setType(String type) {
    this.type = type;
  }
  public void setDefBonus(int defBonus) {
    this.defBonus = defBonus;
  }
  public void setHpBonus(int hpBonus) {
    this.hpBonus = hpBonus;
  }
  public void setSpdModifier(int spdModifier) {
    this.spdModifier = spdModifier;
  }

} // class 