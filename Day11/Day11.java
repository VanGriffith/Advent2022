package Day11; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day11 {
    public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day11/input.txt")); // 
            
            while (sc.hasNext()) {
                String nextLine = sc.nextLine();
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}