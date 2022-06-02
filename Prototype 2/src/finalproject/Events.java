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
            int max = (int)(dam * 1.2);
            int min = (int)(dam * 0.8);
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
            BufferedReader br = new BufferedReader(new FileReader("map1.txt"));
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
    
    public void mapReplacer() {
    String oldString = "WWWokoWoWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW";
    String newString = "WWWoooWoWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW";
    String oldContent = "";
    BufferedReader reader = null;
    FileWriter writer = null;
    try {
      reader = new BufferedReader(new FileReader("map1.txt")); 
      //Reading all the lines of input text file into oldContent
      String line = reader.readLine();
      while (line != null) {
        oldContent = oldContent + line + System.lineSeparator();
        line = reader.readLine();
        }
        //Replacing oldString with newString in the oldContent
        String newContent = oldContent.replaceAll(oldString, newString);
        //Rewriting the input text file with newContent
        writer = new FileWriter("map1.txt");
        writer.write(newContent);
    }
        catch (IOException e)
        {
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
}

    


