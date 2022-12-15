package Day14;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day14 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day14/input.txt"));
            Cave cave = new Cave();
            while (sc.hasNextLine()) {
                cave.createRocks(sc.nextLine());
            }
            cave.createFloor();

            cave.dropSand();
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}