/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *
 * @author msull1
 */
public class Stats {
  String name;
  int maxHealth;
  int currentHealth;
  int defence;
  int attack;
  int temp;
  
  public Stats(String n, int mh, int d, int a) {
    name = n;
    maxHealth = mh;
    currentHealth = maxHealth;
    defence = d;
    attack = a;
  }

    public String getName(){
  return name;
}
  
  public int getMaxHealth() {
    return maxHealth;
  }

  public int getCurrentHealth() {
    return currentHealth;
  }
  
  public int getDefence() {
    return defence;
  }

  public int getAttack() {
    return attack;
  } 
   
  public void setCurrentHealth(){
    currentHealth = maxHealth;
  }
    
  public void loseHealth(int ow) {
    currentHealth -= ow;
  }
  
  public void gainHealth(int heal) {
      currentHealth += heal;
      if (currentHealth > maxHealth) {
          currentHealth = maxHealth;
      }
  }
}

