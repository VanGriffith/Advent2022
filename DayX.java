//package DayX;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DayX {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DayX/input.txt"));
            
            
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}