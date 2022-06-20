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
    int CR; //equal to player level
    String[] moveList;

    
    public EnemyStats(String n, int mh, int d, int a) {
        super(n, mh, d, a);
     }
    
    public int getExpValue() {
        return expValue;
    }
    
    public void generateLesserEnemyType(int level){ //randomly generates a basic enemy
        int levelModifier = (int)(Math.random()*(20) + 1);
        switch(levelModifier) { //randomly have enemies be higher or lower level
            case(1):
                CR = level + 2;
                break;
            case(2): case(3):
                CR = level + 1;
                break;
            case(18): case(19):
                CR = level - 1;
                break;
            case(20):
                CR = level - 2;
                break;
            default:
                CR = level;
                break;
        }
        int enemyIndex = (int)(Math.random()*(3) + 1);
        switch (enemyIndex) {
            case 1:
                generateMoblin();
                break;
            case 2:  
                generateKobold();
                break;
            case 3:
                generateGoblin();
                break;
        }

    }
    
    public void generateEliteEnemyType(int level){ //randomly generates an elite enemy
        int levelModifier = (int)(Math.random()*(20) + 1);
        switch(levelModifier) { //randomly have enemies be higher or lower level
            case(1):
                CR = level + 2;
                break;
            case(2): case(3):
                CR = level + 1;
                break;
            case(18): case(19):
                CR = level - 1;
                break;
            case(20):
                CR = level - 2;
                break;
            default:
                CR = level;
                break;
        }
        int enemyIndex = (int)(Math.random()*(3) + 1);
        switch (enemyIndex) {
            case 1:
                generateMinotaur();
                break;
            case 2:  
                generateBigHand();
                break;
            case 3:
                generateOrc();
                break;
        }
    }
    
    public void generateBossEnemyType(int level){ //randomly generates a boss
        CR = level;
        int enemyIndex = (int)(Math.random()*(3) +1); //Random number 1-3
        switch (enemyIndex) { //Pick an enemy off number
            case 1:
                generateJohnEvil();
                break;
            case 2:  
                generateTheGodlin();
                break;
            case 3:
                generateDragon();
                break;
        }
    }
    
    private void generateMoblin(){ //Stats gets scaled by level
        maxHealth = 11 + (int)(CR * 1.5);
        currentHealth = maxHealth;
        attack = 3 + (int)(CR/2);
        defence = 1 + (int)(CR/4);
        name = "Moblin";
        expValue = 12 + CR * 2;
        String setList[] = {"attack","domehim"}; //Movelist connected to attack functions
        moveList = setList;
    }
    
    private void generateKobold(){
        maxHealth = 7 + (int)(CR * 1.5);
        currentHealth = maxHealth;
        attack = 2 + (int)(CR);
        defence = 1 + (int)(CR/4);
        name = "Kobold";
        expValue = 8 + CR * 2;
        String setList[] = {"attack"};
        moveList = setList;
    }
    
    private void generateMinotaur() {
        maxHealth = 40 + CR;
        currentHealth = maxHealth;
        attack = 3 + (int)(CR);
        defence = (int)(CR/4);
        name = "Minotaur";
        expValue = 20 + CR * 3;
        String setList[] = {"attack","charge"};
        moveList = setList;        
    }
    
    private void generateJohnEvil(){
        maxHealth = (int)(75 * CR/3);
        currentHealth = maxHealth;
        attack = 10 + (int)(CR/2);
        defence = 1 + (int)(CR/2);
        name = "John Evil, the Dark One";
        expValue = 120 + CR * 2;
        String setList[] = {"attack","attack","magicattack","doom"};
        moveList = setList;
    }
    
    private void generateTheGodlin() {
        maxHealth = (int)(100 * CR/4);
        currentHealth = maxHealth;
        attack = 15 + (int)(CR/2);
        defence = 1 + CR;
        name = "Godlin, the Goblin";
        expValue = 70 + CR * 2;
        String setList[] = {"attack","attack","axe"};
        moveList = setList;
    }
    
    private void generateGoblin() {
        maxHealth = 8 + (int)(CR * 1.5);
        currentHealth = maxHealth;
        attack = 2 + (int)(CR/2);
        defence = 0 + (int)(CR/4);
        name = "Goblin";
        expValue = 10 + CR * 2;
        String setList[] = {"attack"};
        moveList = setList;
    }
    
    private void generateDragon(){
        maxHealth = (int)(100 * CR/3);
        currentHealth = maxHealth;
        attack = 5 + CR;
        defence = 2 + (CR);
        name = "Dragon";
        expValue = 90 + CR * 2;
        String setList[] = {"attack", "attack" , "breathefire"};
        moveList = setList;
    }
    
    private void generateBigHand() {
        maxHealth = 15 + (int)(CR*2.5);
        currentHealth = maxHealth;
        attack = 2 + CR;
        defence = 0;
        name = "Big Hand";
        expValue = 20 + CR * 4;
        String setList[] = {"attack","slap"};
        moveList = setList;
    }
    
    private void generateOrc() {
        maxHealth = 15 + (int)(CR * 2.5);
        currentHealth = maxHealth;
        attack = 4 + (int)(CR/1.5);
        defence = 2 + (int)(CR/2);
        name = "Orc";
        expValue = 25 + CR * 4;
        String setList[] = {"attack","axe"};
        moveList = setList;
    }
    
    public void combat(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage(getAttack() + buff, player.getDefence()));
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
        if (player.currentHealth < 0) {
            player.loseHealth(player.currentHealth);
        }
    }
    
    public void axe(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage((int)(attack * 1.5), player.getDefence()));
        eventTextBox.append(name + " swings it's axe wildly. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    public void charge(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage(attack-1, player.getDefence()));
        eventTextBox.append(name + " charges at you. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");       
    }
    
    public void beamHim(Stats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage(2 + (attack/4),player.getDefence()));
        eventTextBox.append(player.getName() + " gets beamed in the back of the head. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    public void slap(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox){
        temp = player.currentHealth;
        player.loseHealth(events.damage((attack)+CR,player.getDefence()));
        eventTextBox.append(name + " smacks you upside the head. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    public void breatheFire(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox){
        temp = player.currentHealth;
        player.loseHealth(events.damage(attack,(int)(player.getDefence()*0.75)));
        eventTextBox.append(name + " breathes fire! \n");
        player.statusEffect[1] = true;
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    public void doom(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage(3*CR, player.getDefence()));
        eventTextBox.append("John Evil conjurs some bad juju. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    private void magicAttack(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox) {
        temp = player.currentHealth;
        player.loseHealth(events.damage(attack, player.getDefence() - (CR / 2)));
        eventTextBox.append("The shoe takes off its shoe and beats you. \n");
        eventTextBox.append(player.getName()+" takes "+(temp - player.getCurrentHealth())+" damage! \n");
    }
    
    private String actionChoose() {
        return moveList[rand.nextInt(moveList.length)];
    }
    
    public void actionDo(PlayerStats player, Events events, javax.swing.JTextArea eventTextBox){
        switch(actionChoose()){
            case "attack":
                combat(player, events, eventTextBox);
                break;
            case "domehim":
                beamHim(player, events, eventTextBox);
                break;
            case "axe":
                axe(player, events, eventTextBox);
                break;
            case "breathefire":
                breatheFire(player, events, eventTextBox);
                break;
            case "slap":
                slap(player, events, eventTextBox);
                break;
            case "doom":
                doom(player, events, eventTextBox);
                break;
            case "magicattack":
                magicAttack(player, events, eventTextBox);
                break;
            case "charge":
                charge(player, events, eventTextBox);
                break;
        }
    }
}
