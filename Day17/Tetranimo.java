package Day17;

public abstract class Tetranimo {
    public int xPos;
    public int yPos;

    public Tetranimo(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public void pushLeft() {
        if (this.xPos > 0) this.xPos--;
    }
    public void pushRight() {
        if (this.xPos + 1 < Cavern.caveWidth) this.xPos++;
    }
    public void fallDown() {
        this.yPos--;
    }

    public abstract boolean collision();
}