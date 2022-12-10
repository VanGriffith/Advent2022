package Day10;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day10Problem2 {
    public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day10/input.txt")); 
            Clock clock = new Clock();
            int[] cycleStrengths = {20, 60, 100, 140, 180, 220};
            
            while (sc.hasNext()) {
                if (sc.next().equals("noop")) {
                    clock.noop();
                }
                else {
                    clock.addx(sc.nextInt());
                }
            }

            System.out.println(clock.getSignalStrengths(cycleStrengths));
            System.out.println();
            clock.printCRT();

            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}