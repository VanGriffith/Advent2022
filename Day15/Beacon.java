package Day15;

import java.util.ArrayList;

public class Beacon extends IntegerPoint {
    
    ArrayList<Sensor> sensors;

    public Beacon(int x, int y) {
        super(x, y);
        this.sensors = new ArrayList<Sensor>();
    }

    public Sensor addSensor(Sensor sensor) {
        this.sensors.add(sensor);
        return sensor;
    }

}
