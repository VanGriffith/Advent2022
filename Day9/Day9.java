package Day9; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day9 {
    public static void main(String[] args) { 
        try {
            int numKnots = 11;
            Rope head = new Rope(0, 0);
            Rope[] ropes = new Rope[numKnots];
            ropes[0] = head;

            for (int i = 1; i < numKnots; i++) {
                ropes[i] = new Rope(0, 0);
                ropes[i].setToFollow(ropes[i-1]);
            }
            
            Rope tail = ropes[numKnots - 1];


            PositionList positionList = new PositionList();
            Scanner sc = new Scanner(new File("Day9/input.txt"));

            while (sc.hasNext()) {
                char direction = sc.next().charAt(0);
                int distance = sc.nextInt();

                for (int i = 0; i < distance; i++) {
                    // Update Head
                    switch(direction) {
                        case 'U':
                            head.y++;
                            break;
                        case 'D':
                            head.y--;
                            break;
                        case 'L':
                            head.x--;
                            break;
                        case 'R':
                            head.x++;
                            break;
                        default:
                            System.out.println("Error");
                            break;
                    }
                    // Update Tail
                    head.updatePositions();
                    positionList.add(tail.getPosition());
                    // System.out.println(tail.getPosition() + "   " + positionList.getUniquePositions());
                }
            }
            System.out.println(positionList.getUniquePositions());
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}
