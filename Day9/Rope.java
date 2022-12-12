package Day9;

public class Rope {
    int x;
    int y;
    Rope nextRope;

    public Rope(int x, int y) {
        this.x = x;
        this.y = y;
        this.nextRope = null;
    }

    public void setToFollow(Rope leader) {
        leader.nextRope = this;
    }

    public String getPosition() {
        return x + "," + y;
    }

    public void follow(Rope leader) {
        int xDiff = leader.x - this.x;
        int yDiff = leader.y - this.y;
        
        if (Math.abs(yDiff) > 1 || Math.abs(xDiff) > 1) {
            this.x += Integer.signum(xDiff);
            this.y += Integer.signum(yDiff);
        }

        if (this.nextRope != null) {
            this.nextRope.follow(this);
        }
    }

    public void updatePositions() {
        if (this.nextRope != null) {
            this.nextRope.follow(this);
        }
    }
}
