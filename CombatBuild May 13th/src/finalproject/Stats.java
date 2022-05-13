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
public class Stats {

  Random rand = new Random();
  Scanner in = new Scanner(System.in);
  String name;
  int maxHealth;
  int currentHealth;
  int currentExp;
  int maxExp;
  int defence;
  int attack;
  
  public Stats(String n, int mh, int d, int a) {
    name = n;
    maxHealth = mh;
    currentHealth = maxHealth;
    currentExp = 0;
    maxExp = 20;
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
  
  public int getCurrentExp() {
      return currentExp;
  }
  
  public int getMaxExp() {
      return maxExp;
  }
  
  public int getDefence() {
    return defence;
  }

  public int getAttack() {
    return attack;
  } 
   
  public void loseHealth(int ow) {
    currentHealth -= ow;
  }
}

