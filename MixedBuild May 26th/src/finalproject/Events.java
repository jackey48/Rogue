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
     
    public int damage(int dam, int def) { //dam is from attacker, def from target
        if (dam > def) { 
            int max = (int)(dam * 1.2);
            int min = (int)(dam * 0.8);
            if (rand.nextInt(20) == 0) {
                return (2*(rand.nextInt(max - min) + min) - def);
            }
            else {
                return (rand.nextInt(max - min) + min - def);
            } 
        }
        else {
            return 0;
        }
    }
}

    


