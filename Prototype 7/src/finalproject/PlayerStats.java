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
    int currentExp; //Increases when an enemy is defeated
    int maxExp; //When currentExp >= maxExp the player levels up, increases both their and enemy strength
    int level; //Player level
    int[][] position;
    int positionX;
    int positionY;
    int length;
    int width;
    int healthLevel = 0; //Times "health" has been selected for level up bonus
    
    public PlayerStats(String n, int mh, int d, int a, int[][] map, int CoordsX, int CoordsY, int length, int width) {
        super(n, mh, d, a);
        currentExp = 0;
        maxExp = 10;
        level = 1;
        position = map;
        positionX = CoordsX;
        positionY = CoordsY;
        this.length = length;
        this.width = width;
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
    
    public int getX(int mapValue){
        int printedLocation = mapValue%(width*10);
        return printedLocation;
    }
    
    public int getY(int mapValue, int X){
        int printedLocation = (mapValue - X)/width;
        return printedLocation;
    }
    
    public void setMap(int[][] newMap){
        position = newMap;
    }
    
    public void setPosX(int CoordsX) {
        positionX = CoordsX;
    }
    
    public void setPosY(int CoordsY) {
        positionY = CoordsY;
    }
    
    public void setAttack(int bonus) {
        attack+=bonus;
    }
    
    public void setDefence(int bonus) {
        defence+=bonus;
    }
    
    public void combat(Stats bad1, Events events) {
        bad1.loseHealth(events.damage(getAttack() + buff, bad1.getDefence()));
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
        maxExp = (level * level) + 10; //increases exp needed for next level up
        LevelUp dialog = new LevelUp(null, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        int selection = dialog.getSelection();
        switch (selection) {
            case(1) :
                healthLevel++;
                break;
            case(2) :
                attack++;
                break;
            case(3) :
                defence++;
                break;
        }
        int temp = maxHealth;
        maxHealth = ((level + healthLevel) * (level)) + 20;
        currentHealth += (maxHealth - temp); //Gain current health = to max health gained
    }
}
