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
public class EnemyStats extends Stats{
    Random rand = new Random();
    int expValue;
    
    public EnemyStats(String n, int mh, int d, int a, int e) {
        super(n, mh, d, a);
        expValue = e;
     }
    
    public int getExpValue() {
        return expValue;
    }
    
    public void actionChoose(Stats player, Events events) {
        int action = rand.nextInt(1);
        if (action == 0) {
            combat(player, events);
        }
    }
    
    public void combat(Stats player, Events events) {
        player.loseHealth(events.damage(getAttack(), player.getDefence()));
        if (player.currentHealth < 0) {
            player.loseHealth(player.currentHealth);
        }
    }
}
