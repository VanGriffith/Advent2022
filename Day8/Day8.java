package Day8;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day8 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day8/input.txt"));
            ArrayList<String> lines = new ArrayList<String>();
            
            while (sc.hasNext()) {
                lines.add(sc.nextLine());
            }

            int[][] forest = new int[lines.get(0).length()][lines.size()];

            for (int row = 0; row < forest.length; row++) {
                for (int col = 0; col < forest.length; col++) {
                    forest[row][col] = Integer.parseInt(lines.get(row).substring(col, col+1));
                }
            }

            boolean[][] visible = new boolean[forest.length][forest.length];

            for (int row = 0; row < forest.length; row++) {
                int leftMax = -1;
                int rightMax = -1;
                for (int column = 0; column < forest.length; column++) {
                    if (forest[row][column] > leftMax) {
                        visible[row][column] = true;
                        leftMax = forest[row][column];
                    }
                    if (forest[row][forest.length-column-1] > rightMax) {
                        visible[row][forest.length-column-1] = true;
                        rightMax = forest[row][forest.length-column-1];
                    }
                }
            }

            for (int column = 0; column < forest.length; column++) {
                int topMax = -1;
                int bottomMax = -1;
                for (int row = 0; row < forest.length; row++) {
                    if (forest[row][column] > topMax) {
                        visible[row][column] = true;
                        topMax = forest[row][column];
                    }
                    if (forest[forest.length-row-1][column] > bottomMax) {
                        visible[forest.length-row-1][column] = true;
                        bottomMax = forest[forest.length-row-1][column];
                    }
                }
            }

            int treeTotal = 0;

            for (boolean[] row: visible) {
                for (boolean column: row) {
                    if (column) {
                        treeTotal += 1;
                    }
                }
            }
            System.out.println(treeTotal);
        }

        
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}