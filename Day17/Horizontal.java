package Day17;

public class Horizontal extends Tetranimo {
    
    public Horizontal(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean collision() {
        return false;
    }
}
