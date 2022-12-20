package Day17;

public class Cavern {
    public static final int ROCK_TYPES = 5;
    public static final int SUM_HEIGHTS = 13;

    public static int caveWidth = 0, maxHeight = 0;
    public int numRocks, highestRock;
    public boolean[][] caveArray;

    public Cavern(int caveWidth, int numRocks) {
        this.highestRock = 0;
        Cavern.caveWidth = caveWidth;
        this.numRocks = numRocks;
        Cavern.maxHeight = ((this.numRocks / ROCK_TYPES) + 2) * SUM_HEIGHTS;
        this.caveArray = new boolean[maxHeight][caveWidth];
        
        for (int i = 0; i < caveWidth; i++) {
            this.caveArray[0][i] = true;
        }
    }
}