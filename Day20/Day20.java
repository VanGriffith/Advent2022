package Day20;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day20 {

    public static CircularList list;
    public static final long KEY = 811589153L;
    public static ArrayList<Node> arraylist;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day20/input.txt"));
            
            arraylist = new ArrayList<Node>();
            list = new CircularList();

            while (sc.hasNextInt()) {
                Node node = new Node(sc.nextInt() * KEY);
                arraylist.add(node);
                list.addToEnd(node);
            }

            for (int i = 0; i < 10; i++){
                for (Node node : arraylist) {
                    node.shift();
                }
            }


            System.out.println("Coordinates Sum: " + list.coordinatesSum());
            
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}