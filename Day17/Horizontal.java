package Day17;

public class Horizontal extends Tetranimo {
    
    public Horizontal(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean collision() {

        return 
                Cavern.caveArray[yPos-1][xPos] || 
                Cavern.caveArray[yPos-1][xPos+1] ||
                Cavern.caveArray[yPos-1][xPos+2] ||
                Cavern.caveArray[yPos-1][xPos+3];
    }

	@Override
	public void cement() {
        Cavern.caveArray[yPos][xPos] = true;
        Cavern.caveArray[yPos][xPos+1] = true;
        Cavern.caveArray[yPos][xPos+2] = true;
        Cavern.caveArray[yPos][xPos+3] = true;

        Cavern.highestRock = Math.max(Cavern.highestRock, yPos);
	}

	@Override
	public boolean checkLeft() {
        try {
            return Cavern.caveArray[yPos][xPos-1];
            
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
	}

	@Override
	public boolean checkRight() {
        try {
            return Cavern.caveArray[yPos][xPos+4];
            
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
	}
}
