package Day2; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {

    public static void main(String[] args) {
        final int LOSS = 0;
        final int DRAW = 3;
        final int WIN = 6;

        try {
            Scanner sc = new Scanner(new File("Day2/input.txt")); 
            int myPoints = 0;
            while (sc.hasNext()) {
                char oppShape = sc.next().charAt(0);
                char myShape = sc.next().charAt(0);

                myPoints += myShape - 'X' + 1;
                int difference = myShape - oppShape;

                if (difference % 3 == 0) {
                    myPoints += WIN;
                }
                else if (difference % 3 == 1) {
                    myPoints += LOSS;
                }
                else if (difference % 3 == 2) {
                    myPoints += DRAW;
                }
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

