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
    int CR;
    String[] moveList;

    
    public EnemyStats(String n, int mh, int d, int a) {
        super(n, mh, d, a);
     }
    
    public int getExpValue() {
        return expValue;
    }
    
    public void generateLesserEnemyType(int level){
        CR = level;
        int enemyIndex = (int)(Math.random()*(3 - 1 + 1) + 1);
        switch (enemyIndex) {
            case 1:
                generateMoblin();
                break;
            case 2:  
                generateGodlin();
                break;
            case 3:
                generateAoblin();
                break;
        }

    }
    
    private void generateMoblin(){
        maxHealth = 10 + CR;
        setCurrentHealth();
        attack = 3 + (int)(CR/2);
        defence = 1 + (int)(CR/4);
        name = "Moblin The Goblin";
        expValue = 12 + CR;
        String setList[] = {"a","dh"};
        moveList = setList;
    }
    
    private void generateGodlin() {
        maxHealth = 10 + (int)(CR);
        setCurrentHealth();
        attack = 4 * CR;
        defence = 1 + CR;
        name = "Godelin, the Third Elden Lord";
        expValue = 50;
        String setList[] = {"a","dh"};
        moveList = setList;
    }
    
    private void generateAoblin() {
        maxHealth = 8 + (int)(CR/2);
        setCurrentHealth();
        attack = 2 + (int)(CR/2);
        defence = 0 + (int)(CR/4);
        name = "Aoblin, the First Goblin";
        expValue = 10 + CR;
        String setList[] = {"a"};
        moveList = setList;
    }
    
    public void generateEliteEnemyType(int level){
        CR = level;
        int enemyIndex = (int)(Math.random()*(3 - 1 + 1) + 1);
        switch (enemyIndex) {
            case 1:
                generateMoe();
                break;
            case 2:  
                generateShoe();
                break;
            case 3:
                generateOrc();
                break;
        }
    }
        
    private void generateMoe(){
        maxHealth = 18 + CR;
        setCurrentHealth();
        attack = 3 + (int)(CR/2);
        defence = 1 + (int)(CR/4);
        name = "Moe, Just Moe";
        expValue = 25 + CR;
        String setList[] = {"a","s"};
        moveList = setList;
    }
    
    private void generateShoe() {
        maxHealth = 20 * (int)(CR);
        setCurrentHealth();
        attack = 2 + CR;
        defence = 0;
        name = "Shoe";
        expValue = 20 + CR*2;
        String setList[] = {"a","m"};
        moveList = setList;
    }
    
    private void generateOrc() {
        maxHealth = 15 + (CR);
        setCurrentHealth();
        attack = 4 + (int)(CR/2);
        defence = 2 + (int)(CR/4);
        name = "Orc Borc";
        expValue = 25 + CR*2;
        String setList[] = {"a","dh"};
        moveList = setList;
    }
    
    public void combat(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage(getAttack(), player.getDefence()));
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
        if (player.currentHealth < 0) {
            player.loseHealth(player.currentHealth);
        }
    }
    
    public void beamHim(Stats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage(0,player.getDefence()));
        eventTextBox.append(player.getName() + " Gets Domed. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    public void Slap(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox){
        temp = player.currentHealth;
        player.loseHealth(events.damage((attack)+CR,player.getDefence()));
        eventTextBox.append(player.getName() + " Gets smacked upside the head. \n");
    }
    
    public void Mexico(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox){
        temp = player.currentHealth;
        player.loseHealth(events.damage(6,player.getDefence()));
        eventTextBox.append("The shoe takes off its shoe and beats you. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    private String actionChoose() {
        return moveList[rand.nextInt(moveList.length)];
    }
    
    public void actionDo(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox){
        switch(actionChoose()){
            case "a":
                combat(player, events, eventTextBox);
                break;
            case "dh":
                beamHim(player, events, eventTextBox);
                break;
            case "m":
                Mexico(player, events, eventTextBox);
                break;
            case "s":
                Slap(player, events, eventTextBox);
                break;
        }
    }
}
