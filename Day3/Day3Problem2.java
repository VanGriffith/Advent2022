package Day3;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3Problem2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day3/input.txt"));
            
            int priortySum = 0;

            while (sc.hasNext()) {
                String rucksackOne = sc.nextLine();
                String rucksackTwo = sc.nextLine();
                String rucksackThree = sc.nextLine();
                ArrayList<Character> oneTwoShared = new ArrayList<Character>();
                char letter = '0';

                for (int i = 0; i < rucksackOne.length(); i++) {
                    for (int j = 0; j < rucksackTwo.length(); j++) {
                        if (rucksackOne.charAt(i) == rucksackTwo.charAt(j)) {
                            oneTwoShared.add(rucksackOne.charAt(i));
                        }
                    }
                }

                for (int i = 0; i < oneTwoShared.size(); i++) {
                    for (int j = 0; j < rucksackThree.length(); j++) {
                        if (oneTwoShared.get(i).equals(rucksackThree.charAt(j))) {
                            letter = (char) oneTwoShared.get(i);
                            i = oneTwoShared.size();
                            j = rucksackThree.length();
                        }
                    }
                }

                if (letter > 'Z') {
                    priortySum += letter - 'a' + 1;
                }
                else {
                    priortySum += letter - 'A' + 27;
                }
            }

            System.out.println(priortySum);
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}
