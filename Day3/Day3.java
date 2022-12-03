package Day3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day3/input.txt"));
            
            int priortySum = 0;

            while (sc.hasNext()) {
                String rucksack = sc.nextLine();
                String compartmentOne = rucksack.substring(0,rucksack.length()/2);
                String compartmentTwo = rucksack.substring(rucksack.length()/2);
                char letter = '0';

                for (int i = 0; i < compartmentOne.length(); i++) {
                    for (int j = 0; j < compartmentTwo.length(); j++) {
                        if (compartmentOne.charAt(i) == compartmentTwo.charAt(j)) {
                            letter = compartmentOne.charAt(i);
                            i = compartmentOne.length();
                            j = compartmentTwo.length();
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
