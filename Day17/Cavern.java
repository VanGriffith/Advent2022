package Day17;

public class Cavern {
    public static final int ROCK_TYPES = 5;
    public static final int SUM_HEIGHTS = 13;

    public static int caveWidth = 0, maxHeight = 0;
    public int numRocks, highestRock;
    public boolean[][] caveArray;
    public int rocksFallen;

    public Cavern(int caveWidth, int numRocks) {
        this.highestRock = 0;
        Cavern.caveWidth = caveWidth;
        this.numRocks = numRocks;
        Cavern.maxHeight = ((this.numRocks / ROCK_TYPES) + 2) * SUM_HEIGHTS;
        this.caveArray = new boolean[maxHeight][caveWidth];

        this.rocksFallen = 0;
        
        for (int i = 0; i < caveWidth; i++) {
            this.caveArray[0][i] = true;
        }
    }

    public void run() {
        
    }

    public void print() {
        for (int row = this.highestRock + 2; row > 0; row--) {
            System.out.print("|");
            for (int column = 0; column < caveWidth; column++) {
                System.out.print(caveArray[row][column] ? "#":" ");
            }
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < caveWidth; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        System.out.printf("Rocks Fallen: %d\nCave Height: %d\nTower Height: %d\n", rocksFallen, maxHeight ,highestRock);
    }
}