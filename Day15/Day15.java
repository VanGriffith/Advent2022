package Day15; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day15 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day15/input.txt")); 
            
            
            
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}