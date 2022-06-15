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
  Boolean[] statusEffect = {false, false};
  
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
  
    //Checks status effects with both starting as false.
    //Applied to stats class so both enemies and player has independent version of the it
    public void statusCheck(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox) {
        for (int i = 0; i < 2; i++){
            if (statusEffect[i] == true){
                switch(i){
                    case 0:
                        /* buff = (int)(attack * 0.3);
                        if (buff < 0) {
                            buff = 1;
                        }   
                        break; */
                    case 1:
                        temp = player.currentHealth;
                        loseHealth((int)(maxHealth * 0.02 + 0.6));
                        eventTextBox.append(name +" is on fire and takes "+(temp - player.getCurrentHealth())+" damage! \n");
                        break;
                }      
            }
        }
    }
}