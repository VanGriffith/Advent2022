package Day17;

/*
 *  .#.
 *  ###
 *  .#.
 */
public class Plus extends Tetranimo {
    
    public Plus(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean collision() {
        return 
            Cavern.caveArray[yPos][xPos] || 
            Cavern.caveArray[yPos-1][xPos+1] ||
            Cavern.caveArray[yPos][xPos+2];
    }

	@Override
	public void cement() {
        Cavern.caveArray[yPos+2][xPos+1] = true;

        Cavern.caveArray[yPos+1][xPos+0] = true;
        Cavern.caveArray[yPos+1][xPos+1] = true;
        Cavern.caveArray[yPos+1][xPos+2] = true;

        Cavern.caveArray[yPos+0][xPos+1] = true;
        
        Cavern.highestRock = Math.max(Cavern.highestRock, yPos+2);
	}

    @Override
    public boolean checkLeft() {
        try {
            return 
                Cavern.caveArray[yPos][xPos] ||
                Cavern.caveArray[yPos+1][xPos-1] ||
                Cavern.caveArray[yPos+2][xPos];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public boolean checkRight() {
        try {
            return 
                Cavern.caveArray[yPos][xPos+2] ||
                Cavern.caveArray[yPos+1][xPos+3] ||
                Cavern.caveArray[yPos+2][xPos+2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

}
