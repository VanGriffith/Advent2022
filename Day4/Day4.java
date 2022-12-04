package Day4; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day4 {
        public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day4/input.txt")); 
            
            while (sc.hasNext()) {
                
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}