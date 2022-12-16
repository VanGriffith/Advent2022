package Day15;

public class IntegerPoint {
    public int x;
    public int y;

    public IntegerPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int setX(int x) {
        this.x = x;
        return this.x;
    }
    public int setY(int y) {
        this.y = y;
        return this.y;
    }
    public int getManhattanDistance(IntegerPoint destination) {
        int distance = 
            this.getHorizontalDistance(destination) +
            this.getVerticalDistance(destination);
        return distance;
    }
    public double getEuclideanDistance(IntegerPoint destination) {
        int xDistance = this.getHorizontalDistance(destination);
        int yDistance = this.getVerticalDistance(destination);
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }
    private int getHorizontalDistance(IntegerPoint destination) {
        return Math.abs(this.getX() - destination.getX());
    }
    private int getVerticalDistance(IntegerPoint destination) {
        return Math.abs(this.getY() - destination.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        IntegerPoint other = (IntegerPoint) o;
        return this.getX() == other.getX() && this.getY() == other.getY();
    }

}
