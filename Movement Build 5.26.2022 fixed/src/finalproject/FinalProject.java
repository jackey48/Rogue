/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

class Player {
    int[][] position;
    int positionX;
    int positionY;
    int length;
    int width;
    public Player(int[][] map, int CoordsX, int CoordsY, int length, int width){
        position = map;
        positionX = CoordsX;
        positionY = CoordsY;
        this.length = length;
        this.width = width;
        System.out.println("Class:" + positionY + " " + CoordsY);
        }
    
    public int getX(int mapValue){
        int printedLocation = mapValue%(width*10);
        return printedLocation;
    }
    
    public int getY(int mapValue, int X){
        int printedLocation = (mapValue - X)/length;
        return printedLocation;
    }
    
    public void setMap(int[][] newMap){
        position = newMap;
    }
    
    public void setPosX(int CoordsX) {
        positionX = CoordsX;
    }
    
    public void setPosY(int CoordsY) {
        positionY = CoordsY;
    }    
    }


/**
 *
 * @author kchan3
 */



public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new GameUI().setVisible(true);
    }
}