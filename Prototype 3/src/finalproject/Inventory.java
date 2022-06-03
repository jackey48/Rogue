/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *
 * @author msull1
 */
public class Inventory {
    String[][] items = new String[20][3];
    int equipedWeapon;
    int equipedArmour;
    int attackBonus = 0;
        
    public String getItems(int i) {
        if (items[i][0] == null) {
            return "";
        }
        else {
        return (items[i][0]+"("+items[i][1]+")");
        }
    }
    
    public int getInventoryLength() {
        return items.length;
    }   
    
    public void addItem(String itemName, String itemEffect) {
        for (int i = 0; i < 20; i++) {
            if (items[i][0] == null) {
                items[i][0] = itemName;
                items[i][1] = itemEffect;
                break;
            }
        }
    }
        
    public void equip(PlayerStats player) {
        /*ItemScreen dialog = new ItemScreen(null, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        int selection = dialog.getSelection();
        
        if (items[selection][0] == null) {
            System.out.print(":)");
        }
        else if (items[selection][0].contains("Sword")) {
            equipedWeapon = selection;
            player.setAttack(-attackBonus);
            attackBonus = Integer.parseInt(items[selection][1].replaceAll("[\\D]", ""));
            player.setAttack(attackBonus);
        }     
        else if (items[selection][0].contains("Armour")) {
            equipedArmour = selection;
            
        } */
    }
}
