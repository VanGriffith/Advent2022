package Day6;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day6 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day6/input.txt"));
            
            while (sc.hasNext()) {
                String nextLine = sc.nextLine();
                System.out.println(nextLine);
                break;
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}