import java.util.ArrayList;

public class Character {
  private int starRating;
  private String name;
  private int level = 1;
  private int xp = 0;
  private int xpRequired = 100;
  private int health;
  private int defaultHealth;
  private int additionalHealth;
  private int attackDamage;
  private int defaultAttackDamage;
  private int additionalAttackDamage;
  private int defense;
  private int defaultDefense;
  private int additionalDefense;
  private ArrayList<Artifact> artifacts;
  
  public Character(int starRating, String name){
    this.starRating = starRating;
    this.name = name;
    this.xpRequired = xpRequired * starRating;
    this.defaultHealth = (starRating * 10);
    this.defaultAttackDamage = starRating;
    this.defaultDefense = starRating;
  }

  public void addXp(int amount){
    if(xp + amount > xpRequired){
      levelUp(1);
      addXp(xp + amount - xpRequired);
    }
    xp += amount;
  }

  public void levelUp(int amount){
    level += amount;
    for(int i = 0; i < amount; i++){
      xpRequired += xpRequired * (starRating * 0.1);
    }
    defaultHealth += level * ((starRating * 10) * 0.5);
    defaultAttackDamage += level * (starRating * 0.5);
    defaultDefense += level * (starRating * 0.5);
    updateStats();
  }

  public void updateStats(){
    health = defaultHealth + additionalHealth;
    attackDamage = defaultAttackDamage + additionalAttackDamage;
    defense = defaultDefense + additionalDefense;
  }

  public String toString(){
    String stars = "";
    //make fancier star display
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    String moreHealth = "";
    String moreAttackDamage = "";
    String moreDefense = "";
    if(additionalHealth != 0){
      moreHealth = " + " + additionalHealth;
    }

    if(additionalAttackDamage != 0){
      moreAttackDamage = " + " + additionalAttackDamage;
    }

    if(additionalDefense != 0){
      moreDefense = " + " + additionalDefense;
    }

    return name + " " + stars + "\nlevel " + level + "\nxp: " + xp + "/" + xpRequired + "\nhealth: " + defaultHealth + moreHealth  + "\nattack: " + defaultAttackDamage + moreAttackDamage + "\ndefense: " + defaultDefense + moreDefense;
  }
}