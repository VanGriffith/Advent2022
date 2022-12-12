package Day9;
import java.util.ArrayList;

public class PositionList {
    
    ArrayList<String> positions;

    public PositionList() {
        this.positions = new ArrayList<String>();
    }

    public void add(String newPosition) {
        for (String position: positions) {
            if (position.equals(newPosition)) {
                return;
            }
        }
        this.positions.add(newPosition);
    }

    public int getUniquePositions() {
        return positions.size();
    }
}
