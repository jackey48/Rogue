/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
/**
 *
 * @author msull1
 */
public class PlayerStats extends Stats{
    int currentExp;
    int maxExp;
    int level;
    
    public PlayerStats(String n, int mh, int d, int a) {
        super(n, mh, d, a);
        currentExp = 0;
        maxExp = 20;
        level = 1;
     }
    
    public int getCurrentExp() {
        return currentExp;
    }
  
    public int getMaxExp() {
        return maxExp;
    }
    
    public int getLevel() {
        return level;
    }
       
    public void setAttack(int bonus) {
        attack+=bonus;
    }
    
    public void combat(Stats bad1, Events events) {
        bad1.loseHealth(events.damage(getAttack(), bad1.getDefence()));
        if (bad1.currentHealth < 0) {
            bad1.loseHealth(bad1.currentHealth);
        }
    }
    
    public void gainExp(int e) {
        currentExp += e;
        while (currentExp >= maxExp) {
            currentExp -= maxExp;
            gainLevel();
        }
    }
    
    public void gainLevel() {
        level++;
        maxExp = (level * 10) + 10 ;
        LevelUp dialog = new LevelUp(null, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        int selection = dialog.getSelection();
        switch (selection) {
            case(1) :
                maxHealth+=10;
                break;
            case(2) :
                attack++;
                break;
            case(3) :
                defence++;
                break;
        }
    }
}
