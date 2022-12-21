package Day18;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day18 {

    public static boolean[][][] grid;

    public static void main(String[] args) {
        try {
            grid = new boolean[22][22][22];
            int surfaceArea = 0;

            Scanner sc = new Scanner(new File("Day18/input.txt"));
            sc.useDelimiter("[\\D]+");

            while (sc.hasNext()) {
                surfaceArea += addCube(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            sc.close();

            System.out.println(surfaceArea);
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }

    private static int addCube(int x, int y, int z) {
        grid[x][y][z] = true;
        int neighbors = 0;

        try {
            if (grid[x+1][y][z]) neighbors++;
        } catch (ArrayIndexOutOfBoundsException e){};
        
        try {
            if (grid[x-1][y][z]) neighbors++;
        } catch (ArrayIndexOutOfBoundsException e){}

        try {
            if (grid[x][y+1][z]) neighbors++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        
        try {
            if (grid[x][y-1][z]) neighbors++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        
        try {
            if (grid[x][y][z+1]) neighbors++;
        } catch (ArrayIndexOutOfBoundsException e) {}
        
        try {
            if (grid[x][y][z-1]) neighbors++;
        } catch (ArrayIndexOutOfBoundsException e) {}

        int surfaceAreaChange = -2 * (neighbors - 3);
        return surfaceAreaChange;

    }
}