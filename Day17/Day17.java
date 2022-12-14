package Day17;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day17 {

    public static String moves;
    public static int movesLength;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day17/input.txt"));
            moves = sc.nextLine();
            movesLength = moves.length();

            Cavern cave = new Cavern(7, 2022);
            cave.run();
            cave.print();


            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}