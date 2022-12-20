package Day17;

/**
 * O
 * O
 * O
 * O
 */
public class Vertical extends Tetranimo {
    
    public Vertical(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean checkLeft() {
        try {
            return 
                Cavern.caveArray[yPos+0][xPos-1] ||
                Cavern.caveArray[yPos+1][xPos-1] ||
                Cavern.caveArray[yPos+2][xPos-1] ||
                Cavern.caveArray[yPos+3][xPos-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public boolean checkRight() {
        try {
            return 
                Cavern.caveArray[yPos+0][xPos+1] ||
                Cavern.caveArray[yPos+1][xPos+1] ||
                Cavern.caveArray[yPos+2][xPos+1] ||
                Cavern.caveArray[yPos+3][xPos+1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public void cement() {
        Cavern.caveArray[yPos+0][xPos] = true;
        Cavern.caveArray[yPos+1][xPos] = true;
        Cavern.caveArray[yPos+2][xPos] = true;
        Cavern.caveArray[yPos+3][xPos] = true;
        
        Cavern.highestRock = Math.max(Cavern.highestRock, yPos+3);
    }

    @Override
    public boolean collision() {
        return 
            Cavern.caveArray[yPos-1][xPos];
    }
}
