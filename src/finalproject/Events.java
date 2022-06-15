/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 *
 * @author msull1
 */
public class Events {
    Random rand = new Random();
    
    public Events(){
    
    }
    
    public int damage(int dam, int def) { //dam is from attacker, def from target
        if (dam > def) { 
            int max = (int)(dam * 2);
            int min = (int)(dam * 1);
            if (rand.nextInt(20) == 0) {
                return (2*((rand.nextInt(max - min) + min) - def));
            }
            else {
                return (rand.nextInt(max - min) + min - def);
            } 
        }
        else {
            return 0;
        }
    }
    
    public char mapReader(int x, int y) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("map1player.txt"));
            String line;
            line = br.readLine();
            for (int i = 0; i <= y-1; i++)  {
                line = br.readLine();
            }
            br.close();
            return line.charAt(x);
        } 
        catch( IOException ex ) { 
            ex.printStackTrace();
            System.out.println("Error");
            return 'o';
        }
    }
    
    public void mapReplacer() { //Replaces whole map with default map
        String oldString = "";
        String newString = "";
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try { 
            reader = new BufferedReader(new FileReader("map1player.txt"));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = " " + line + System.lineSeparator();
            line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter("map1player.txt");
            writer.write(newContent);
            reader.close();
            writer.close();
            
            reader = new BufferedReader(new FileReader("map1.txt"));
            writer = new FileWriter("map1player.txt");
            for (int i = 0; i < 30; i++) {
                writer.write(reader.readLine() + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e)  {
                e.printStackTrace();
            }
        }       
    }
    
    public void mapLineReplacer(int x, int y, int playerX, int playerY) { //Replaces single character on map
        String oldString = "";
        String newString = "";
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try { 
            reader = new BufferedReader(new FileReader("map1player.txt"));
            for (int i = 0; i <= (playerY + y); i ++) {
                oldString = reader.readLine();
            }
            reader.close();
            newString = oldString.substring(0,(playerX + x))+'o'+oldString.substring(playerX + x + 1);
            //Reading all the lines of input text file into oldContent
            reader = new BufferedReader(new FileReader("map1player.txt"));
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
            line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter("map1player.txt");
            writer.write(newContent);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e)  {
                e.printStackTrace();
            }
        }
    }  
    
    public int getColor(int x, int y, int playerX, int playerY) {
        String oldString = "";
        String newString = "";
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try { 
            reader = new BufferedReader(new FileReader("map1player.txt"));
            for (int i = 0; i <= (playerY + y); i ++) {
                oldString = reader.readLine();
            }
            reader.close();
            newString = oldString.substring(playerX + x, playerX + x + 1);
            switch (newString) {
                case("o"): //open area (nothing)
                    return 1;
                case("W"): //wall
                    return 2;
                case("k"): case("e"): case("b"): //enemies
                    return 3;
                case("t"): //tresure
                    return 4;
                case("u"): //Win zone
                    return 5;
            }
            return 1;
        }
        catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
    }
}

    


