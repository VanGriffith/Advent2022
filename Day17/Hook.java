package Day17;

/**
 *  ..O
 *  ..O
 *  OOO
 */
public class Hook  extends Tetranimo {
    
    public Hook(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean checkLeft() {
        try {
            return 
                Cavern.caveArray[yPos][xPos-1] ||
                Cavern.caveArray[yPos+1][xPos+1] ||
                Cavern.caveArray[yPos+2][xPos+1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public boolean checkRight() {
        try {
            return 
                Cavern.caveArray[yPos][xPos+3] ||
                Cavern.caveArray[yPos+1][xPos+3] ||
                Cavern.caveArray[yPos+2][xPos+3];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public void cement() {
        Cavern.caveArray[yPos+0][xPos+0] = true;
        Cavern.caveArray[yPos+0][xPos+1] = true;
        Cavern.caveArray[yPos+0][xPos+2] = true;
        
        Cavern.caveArray[yPos+1][xPos+2] = true;

        Cavern.caveArray[yPos+2][xPos+2] = true;
        
        Cavern.highestRock = Math.max(Cavern.highestRock, yPos+2);
        
    }

    @Override
    public boolean collision() {
        return 
            Cavern.caveArray[yPos-1][xPos+0] || 
            Cavern.caveArray[yPos-1][xPos+1] ||
            Cavern.caveArray[yPos-1][xPos+2];
    }
}
