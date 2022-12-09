package Day8;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day8Problem2 {
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

            int[][] visibilityScores = new int[forest.length][forest.length];

            for (int row = 0; row < forest.length; row++) {
                for (int column = 0; column < forest.length; column++) {
                    int treesNorth = 0;
                    int treesSouth = 0; 
                    int treesEast = 0;
                    int treesWest = 0;

                    int columnPointer = column;
                    while (--columnPointer >= 0) {
                        treesNorth++;
                        if (forest[row][columnPointer] >= forest[row][column]) {
                            break;
                        }
                    }

                    columnPointer = column;
                    while (++columnPointer < forest.length) {
                        treesSouth++;
                        if (forest[row][columnPointer] >= forest[row][column]) {
                            break;
                        }
                    }

                    int rowPointer = row;
                    while (--rowPointer >= 0) {
                        treesWest++;
                        if (forest[rowPointer][column] >= forest[row][column]) {
                            break;
                        }
                    }

                    rowPointer = row;
                    while (++rowPointer < forest.length) {
                        treesEast++;
                        if (forest[rowPointer][column] >= forest[row][column]) {
                            break;
                        }
                    }
                    visibilityScores[row][column] = treesNorth*treesSouth*treesWest*treesEast;
                }
            }

            int maxScore = 0;
            for (int[] row: visibilityScores) {
                for (int score: row) {
                    maxScore = Math.max(score, maxScore);
                }
            }
            System.out.println(maxScore);
            
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}