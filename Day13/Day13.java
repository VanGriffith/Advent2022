package Day13; 
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day13 {
    public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day13/input.txt"));
            ArrayList<Tree[]> treePairs = new ArrayList<Tree[]>();
            while (sc.hasNext()) {
                Tree[] treePair = new Tree[2];
                treePair[0] = new Tree(sc.nextLine());
                treePair[1] = new Tree(sc.nextLine());
                if (sc.hasNext()) sc.nextLine();

                treePairs.add(treePair);
            }

            int sum = 0;
            for (int i = 1; i <= treePairs.size(); i++) {
                Tree left = treePairs.get(i-1)[0];
                Tree right = treePairs.get(i-1)[1];

                if (Tree.compare(left, right)) {
                    sum += i;
                }
                else {
                }
            }
            System.out.printf("Sum = %d\n", sum);
            Tree[] dividers = new Tree[2];
            dividers[0] = new Tree("[[2]]");
            dividers[1] = new Tree("[[6]]");
            treePairs.add(dividers);

            PriorityQueue<Tree> treeQueue = new PriorityQueue<Tree>();
            for (int i = 1; i <= treePairs.size(); i++) {
                Tree left = treePairs.get(i-1)[0];
                Tree right = treePairs.get(i-1)[1];
                treeQueue.offer(left);
                treeQueue.offer(right);
            }
            int index = 1;
            int decoderKey = 1;
            while (!treeQueue.isEmpty()) {
                Tree tree = treeQueue.poll();
                if (tree == dividers[0] || tree == dividers[1]) {
                    decoderKey *= index;
                    System.out.println();
                    tree.printTree();
                    System.out.println();
                }
                else {
                    tree.printTree();
                }
                index++;
            }

            System.out.printf("Key = %d\n", decoderKey);

        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}