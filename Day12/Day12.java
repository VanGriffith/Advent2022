package Day12; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day12 {
    public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day12/input.txt"));
            Queue<String> inputQueue = new LinkedList<String>();

            while (sc.hasNext()) {
                inputQueue.offer(sc.nextLine());
            }
            sc.close();

            Map heightMap = new Map(inputQueue);            
            System.out.printf("Shortest a path: %d\n", heightMap.findBestStart());
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}
