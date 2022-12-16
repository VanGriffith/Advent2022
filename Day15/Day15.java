package Day15; 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day15 {

    public static final int ROW_TO_CHECK = 2000000;
    static ArrayList<Sensor> sensors;
    static ArrayList<Beacon> beacons;
    static ArrayList<int[]> indeces;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day15/input.txt")); 
            sc.useDelimiter("[\\D]+\\=");
            
            sensors = new ArrayList<Sensor>();
            beacons = new ArrayList<Beacon>();
            indeces = new ArrayList<int[]>();

            while (sc.hasNext()) {
                try {
                    Sensor newSensor = new Sensor(sc.nextInt(), sc.nextInt());
                    sensors.add(newSensor);
                    Beacon newBeacon = new Beacon(sc.nextInt(), sc.nextInt());
    
                    if (beacons.contains(newBeacon)) {
                        newBeacon = beacons.get(beacons.indexOf(newBeacon));
                        newSensor.setBeacon(newBeacon);
                    }
                    else {
                        newSensor.setBeacon(newBeacon);
                        beacons.add(newBeacon);
                    }
                    
                } catch (InputMismatchException e) {
                    break;
                }
            }
            sc.close();

            System.out.printf(
                "Sensors: %d\nBeacons: %d\n",
                sensors.size(), 
                beacons.size()
            );
            
            for (Sensor sensor: sensors) {
                if (sensor.isInDistance) getIndecesFrom(sensor);
            }

            int sum = 0;
            for (int i = 0; i < indeces.size(); i++) {
                int[] index = indeces.get(i);
                System.out.printf("[%d][%d]\n", indeces.get(i)[0],indeces.get(i)[1]);
                sum += Math.abs(index[0] - index[1]) + 1;
            }

            System.out.printf("Position Count: %d\n", sum);

            
            

        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }

    public static void getIndecesFrom(Sensor sensor) {
        indeces.add(sensor.getRowIndeces());
        
        for (int i = 0; i < indeces.size() - 1; i++) {
            int[] newer = indeces.get(indeces.size()-1);
            int[] older = indeces.get(i);

            if (newer[1] >= older[0] && newer[0] <= older[1]) {
                newer[0] = Math.min(newer[0], older[0]);
                newer[1] = Math.max(newer[1], older[1]);
                indeces.set(indeces.size()-1, newer);
                indeces.remove(i);
                i--;
            }
        }
        
    }
}