package Day13; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day13 {
    public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day13/input.txt"));
            
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}