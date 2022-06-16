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
public class Inventory {
    Random rand = new Random();
    String[][] items = new String[20][2]; //Exampe: [Sword][+1 Attack]
    int equipedWeapon;
    int equipedArmour;
    int attackBonus = 0;
    int defenceBonus = 0;
        
    public String getItems(int i) {
        if (items[i][0].equals(" ")) {
            return "";
        }
        else {
        return (items[i][0]+"("+items[i][1]+")");
        }
    }
    
    public int getInventoryLength() {
        return items.length;
    }   
    
    public void fillItems() {
        for (int t = 0; t < 20; t++) {
            items[t][0] = " ";
            items[t][1] = " ";
        }
    }
    
    public void addItem(int level, javax.swing.JTextArea eventTextBox) {
        String modifier = ""; //Modifier added to start of item name (Ex: Iron Sword)
        
        switch(level) {
            case(1): case(2): case(3):
                modifier = "Wooden ";
                break;
            case(4): case(5): case(6):
                modifier = "Rusty ";
                break;
            case(7): case(8): case(9):
                modifier = "Iron ";
                break;
            case(10): case(11): case(12):
                modifier = "Steel ";
                break;
            case(13): case(14): case(15):
                modifier = "Silver ";
                break;
            case(16): case(17): case(18):
                modifier = "Titanium ";
                break;
            case(19): case(20): case(21):
                modifier = "Royal ";
                break;
            case(22): case(23): case(24):
                modifier = "Magic ";
                break;
            case(25): case(26): case(27):
                modifier = "Diamond ";
                break;
            case(28): case(29): case(30):
                modifier = "Meteor ";
                break;
        }
        
        for (int i = 0; i < 20; i++) { //Checks for first empty space in array
            if (items[i][0].equals(" ")) {
                int a = rand.nextInt(3); //Randomly generates item type
                switch (a) {
                    case(0):
                        items[i][0] = modifier + "Sword";
                        items[i][1] = "+"+String.valueOf(level)+" ATT";
                        eventTextBox.append("You got " + items[i][0]+"("+items[i][1]+") \n");
                        break;
                    case(1):
                        items[i][0] = modifier + "Armour";
                        items[i][1] = "+"+String.valueOf(level)+" DEF";
                        eventTextBox.append("You got " + items[i][0]+"("+items[i][1]+") \n");
                        break;
                    case(2):
                        items[i][0] = "Potion";
                        items[i][1] = "Heals "+String.valueOf(level*5)+" HP";
                        eventTextBox.append("You got " + items[i][0]+"("+items[i][1]+") \n");
                        break;
                } 
                break;
            }
        }
    }
        
    public void equip(PlayerStats player, javax.swing.JTextArea eventTextBox, boolean deleteMode) {
        ItemScreen dialog = new ItemScreen(null, true, items); //opens inventory window
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        int selection = dialog.getSelection();
        
        if (deleteMode == true) { 
            items[selection][0] = " ";
            items[selection][1] = " ";
        }
        else if (items[selection][0].contains("Sword")) { //Checks what type of item is being used
            equipedWeapon = selection;
            player.setAttack(-attackBonus);
            attackBonus = Integer.parseInt(items[selection][1].replaceAll("[\\D]", ""));
            player.setAttack(attackBonus);
            eventTextBox.append("You equiped " + items[selection][0]+"("+items[selection][1]+") \n");
        }     
        else if (items[selection][0].contains("Armour")) {
            equipedArmour = selection;
            player.setDefence(-defenceBonus);
            defenceBonus = Integer.parseInt(items[selection][1].replaceAll("[\\D]", ""));
            player.setDefence(defenceBonus);
            eventTextBox.append("You equiped " + items[selection][0]+"("+items[selection][1]+") \n");
        } 
        else if (items[selection][0].contains("Potion")) {
            int heal = Integer.parseInt(items[selection][1].replaceAll("[\\D]", ""));
            player.gainHealth(heal);
            eventTextBox.append("You used " + items[selection][0]+"("+items[selection][1]+") \n");
            items[selection][0] = " ";
            items[selection][1] = " ";
        }
    }
}
