package Day2; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2Problem2 {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("Day2/input.txt")); 
            int myPoints = 0;
            while (sc.hasNext()) {
                char oppShape = sc.next().charAt(0);
                char myShape = sc.next().charAt(0);
                
                myPoints += 3 * ((myShape - 1) % 3);
                myPoints += 1 + ((myShape + oppShape + 2) % 3);
            }

            System.out.println(myPoints);
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }

}

