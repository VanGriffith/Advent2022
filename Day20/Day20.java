package Day20;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day20 {

    public static CircularList list;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day20/input.txt"));
            
            Queue<Node> queue = new LinkedList<Node>();
            list = new CircularList();

            while (sc.hasNextInt()) {
                Node node = new Node(sc.nextInt());
                queue.offer(node);
                list.addToEnd(node);
            }

            while (!queue.isEmpty()) {
                
                queue.poll().shift();
            }

            list.print();

            System.out.println("Coordinates Sum: " + list.coordinatesSum());
            
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}