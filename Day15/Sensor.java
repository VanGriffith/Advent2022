package Day15;

public class Sensor extends IntegerPoint {

    Beacon beacon;
    public int distance;
    public int distanceToRow;
    public boolean isInDistance;

    public Sensor(int x, int y) {
        super(x, y);
        this.beacon = null;
        this.distanceToRow = Math.abs(this.getY() - Day15.ROW_TO_CHECK);
    }

    public Beacon setBeacon(Beacon beacon) {
        this.beacon = beacon;
        this.beacon.addSensor(this);
        this.distance = this.getManhattanDistance(this.beacon);
        this.isInDistance = this.distanceToRow < this.distance;
        return this.beacon;
    }

    public int[] getRowIndeces() {
        int[] indeces = new int[2];
        indeces[0] = this.getX() - (this.distance - this.distanceToRow);
        indeces[1] = this.getX() + (this.distance - this.distanceToRow);
        if (this.beacon.getX() == indeces[0]) indeces[0]++;
        if (this.beacon.getX() == indeces[1]) indeces[1]--;
        return indeces;
    }

    
    public int[] getRowIndecesPart2() {
        int[] indeces = new int[2];
        indeces[0] = this.getX() - (this.distance - this.distanceToRow);
        indeces[1] = this.getX() + (this.distance - this.distanceToRow);
        indeces[0] = Math.max(indeces[0], 0);
        indeces[1] = Math.max(indeces[1], 0);
        indeces[0] = Math.min(indeces[0], Day15Problem2.ROW_TO_CHECK);
        indeces[1] = Math.min(indeces[1], Day15Problem2.ROW_TO_CHECK);
        return indeces;
    }

    public boolean isInDistance() {
        this.distanceToRow = Math.abs(this.getY() - Day15Problem2.CURRENT_ROW);
        this.isInDistance = this.distanceToRow < this.distance;
        return this.isInDistance;
    }

    
}