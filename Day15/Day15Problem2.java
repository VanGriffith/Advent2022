package Day15; 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day15Problem2 {

    public static final int ROW_TO_CHECK = 4000000;
    public static int CURRENT_ROW = 0;
    static ArrayList<Sensor> sensors;
    static ArrayList<Beacon> beacons;
    static ArrayList<int[]> indeces;
    static int[][] positions;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day15/input.txt")); 
            sc.useDelimiter("[\\D]+\\=");
            
            sensors = new ArrayList<Sensor>();
            beacons = new ArrayList<Beacon>();

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
            
            for (CURRENT_ROW = 0; CURRENT_ROW < ROW_TO_CHECK; CURRENT_ROW++) {
                indeces = new ArrayList<int[]>();
                for (Sensor sensor: sensors) {
                    if (sensor.isInDistance()) getIndecesFrom(sensor);
                }

                if (indeces.size() != 1) {

                    for (int i = 0; i < indeces.size(); i++) {
                        int[] index = indeces.get(i);
                        System.out.printf("[%d][%d]\n", index[0], index[1]);
                    }

                    int xPosition = indeces.get(0)[1] + 1;
                    System.out.printf("Beacon is at (%d, %d)\n", xPosition, CURRENT_ROW);
                    long key = xPosition; 
                    key *= ROW_TO_CHECK;
                    key += CURRENT_ROW;
                    System.out.println(key);
                    System.out.println(Long.valueOf(key));
                }
            }
            

        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }

    public static void getIndecesFrom(Sensor sensor) {
        indeces.add(sensor.getRowIndecesPart2());
        
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