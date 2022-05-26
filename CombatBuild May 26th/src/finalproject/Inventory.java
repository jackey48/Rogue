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
    String equipedWeapon;
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
        
    public void equip(int i, PlayerStats player) {
        if (items[i][0] == null) {
            System.out.print(":)");
        }
        else if (items[i][0].contains("Sword")) {
            equipedWeapon = items[i][0];
            player.setAttack(-attackBonus);
            attackBonus = Integer.parseInt(items[i][1].replaceAll("[\\D]", ""));
            player.setAttack(attackBonus);
        }     
        else if (items[i][0].contains("Armour")) {
            
        }
    }
}
