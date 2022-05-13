/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.util.Random;
/**
 *
 * @author msull1
 */
public class Events {
    Random rand = new Random();
     
    public int damaged(int dam, int def) { //dam is from attacker, def from target
        int damage = dam;
        if (damage > def) { 
            return (dam - def); 
        }
        else {
            return 0;
        }
    }
    
    public int attack(int attack) {
        int max = (int)(attack * 1.2);
        int min = (int)(attack * 0.8);
        if (rand.nextInt(20) == 0) {
            System.out.print("Critical Hit!");
            return 2*(rand.nextInt(max - min) + min);
        }
        else {
            return rand.nextInt(max - min) + min;
        }
    }
}

    


