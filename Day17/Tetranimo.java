package Day17;

public abstract class Tetranimo {
    public int xPos;
    public int yPos;

    public Tetranimo(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public void pushLeft() {
        if (!this.checkLeft()) this.xPos--;
    }
    public abstract boolean checkLeft();

    public void pushRight() {
        if (!this.checkRight()) this.xPos++;
    }
    public abstract boolean checkRight();

    public void fallDown() {
        this.yPos--;
    }

    public abstract void cement();
    public abstract boolean collision();
}