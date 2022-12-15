package Day14;

import java.util.Scanner;

public class Cave {
    public static final int AIR = 0;
    public static final int ROCK = 1;
    public static final int SAND = 2;
    public static final int TEST = 0;
    public static final int SAND_INDEX = 500 - TEST;
    public static final int GRID_WIDTH = 1000;
    public static final int GRID_HEIGHT = 200;
    public int highestY;

    public int sandX, sandY;
    public int sandCount;
    
    public int[][] cave;

    public Cave(){
        this.cave = new int[GRID_WIDTH][GRID_HEIGHT];
        this.sandX = SAND_INDEX;
        this.sandY = 0;
        this.sandCount = 0;
        this.highestY = 0;
    }

    public void createRocks(String pattern) {
        Scanner sc = new Scanner(pattern);
        sc.useDelimiter("[\\D]+");

        int xStart = sc.nextInt() - TEST;
        int yStart = sc.nextInt();
        highestY = Math.max(highestY, yStart);
        

        while (sc.hasNext()) {
            int xEnd = sc.nextInt() - TEST;
            int yEnd = sc.nextInt();
            highestY = Math.max(highestY, yEnd);

            for (int x = Math.min(xStart,xEnd); x <= Math.max(xStart, xEnd); x++) {
                for (int y = Math.min(yStart, yEnd); y <= Math.max(yStart, yEnd); y++) {
                    this.cave[x][y] = ROCK;
                }
            }
            xStart = xEnd;
            yStart = yEnd;
        }
        
        sc.close();
    }

    public void createFloor() {
        for (int x = 0; x < GRID_WIDTH; x++) {
            this.cave[x][highestY+2] = ROCK;
        }
    }

    public void dropSand() {
        try {
            while (true) {
                if (this.cave[sandX][sandY + 1] == AIR) {
                    sandY++;
                }
                else if (this.cave[sandX - 1][sandY + 1] == AIR) {
                    sandX--;
                    sandY++;
                }
                else if (this.cave[sandX + 1][sandY + 1] == AIR) {
                    sandX++;
                    sandY++;
                }
                else {
                    this.cave[sandX][sandY] = SAND;
                    sandCount++;
                    this.printSandTotal();
                    if (sandX == SAND_INDEX && sandY == 0) {
                        break;
                    }
                    sandX = SAND_INDEX;
                    sandY = 0;
                }
            }
           // this.print();
        } catch (ArrayIndexOutOfBoundsException e) {
          //  this.print();
        }
        catch (StackOverflowError e) {

        }
    }

    public void print() {
        for (int y = 0; y < highestY + 3; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                char toPrint;
                switch (this.cave[x][y]) {
                    case SAND:
                        toPrint = 'o';
                        break;
                    case ROCK:
                        toPrint = 'X';
                        break;
                    default:
                        toPrint = ' ';
                        break;
                }
                System.out.print(toPrint);
            }
            System.out.println();
        }
        this.printSandTotal();
    }

    public void printSandTotal() {
        System.out.printf("Total sand: %d\n", sandCount);       
    }
}
