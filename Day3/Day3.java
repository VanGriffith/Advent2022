package Day3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day3/input.txt"));
            
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
