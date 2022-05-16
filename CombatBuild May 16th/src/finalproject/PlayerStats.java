/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author msull1
 */
public class PlayerStats extends Stats{
    int currentExp;
    int maxExp;
    
    public PlayerStats(String n, int mh, int d, int a) {
        super(n, mh, d, a);
        currentExp = 0;
        maxExp = 20;
     }
    
    public int getCurrentExp() {
        return currentExp;
    }
  
    public int getMaxExp() {
        return maxExp;
    }
    
    public void combat(Stats bad1, Events events) {
        bad1.loseHealth(events.damage(getAttack(), bad1.getDefence()));
        if (bad1.currentHealth < 0) {
            bad1.loseHealth(bad1.currentHealth);
        }
    }
}
