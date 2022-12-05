
package Day5; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Day5 {
    public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day5/input.txt"));
            String nextLine;

            int numStacks = 9;
            ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
            
            for (int i = 0; i < numStacks; i++) {
                stacks.add(new Stack<Character>());
            }

            while (sc.hasNext()) {
                nextLine = sc.nextLine();
                if (nextLine.charAt(1) == '1') {
                    break;
                }
            
                for (int i = 0; i < numStacks; i++) {
                    int charIndex = 4 * i + 1;
                    if (nextLine.charAt(charIndex) != ' ') {
                        stacks.get(i).add(nextLine.charAt(charIndex));
                    }
                }
            }
            for (int i = 0; i< numStacks; i++) {
                Stack<Character> temp = stacks.get(i);
                stacks.set(i, new Stack<Character>());
                while (!temp.isEmpty()) {
                    stacks.get(i).add(temp.pop());
                }
            }
            
            sc.nextLine();


            while (sc.hasNext()) {
                sc.next();
                int numToMove = sc.nextInt();
                sc.next();
                Stack<Character> fromStack = stacks.get(sc.nextInt() - 1);
                sc.next();
                Stack<Character> toStack = stacks.get(sc.nextInt() - 1);

                Stack<Character> tempStack = new Stack<Character>();
                for (int i = 0; i < numToMove; i++) {
                    tempStack.add(fromStack.pop());
                }
                for (int i = 0; i < numToMove; i++) {
                    toStack.add(tempStack.pop());
                }
            }

            

            for (int i = 0; i < numStacks; i++) {
                System.out.print(stacks.get(i).pop());
            }

            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}
