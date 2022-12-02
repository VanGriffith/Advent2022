package Day1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day1/input.txt"));
            
            int firstMost = 0;
            int secondMost = 0;
            int thirdMost = 0;
            int currentCalories= 0;
            
            while (sc.hasNext()) {
                String nextLine = sc.nextLine();
                
                if (nextLine.equals("")) {
                    if (currentCalories > firstMost) {
                        thirdMost = secondMost;
                        secondMost = firstMost;
                        firstMost = currentCalories;
                    }
                    else if (currentCalories > secondMost) {
                        thirdMost = secondMost;
                        secondMost = currentCalories;
                    }
                    else if (currentCalories > thirdMost) {
                        thirdMost = currentCalories;
                    }
                    currentCalories = 0;

                }
                else {
                    currentCalories += Integer.parseInt(nextLine);

                }
            }
            System.out.println(firstMost + secondMost + thirdMost);
            System.out.println(firstMost + secondMost + thirdMost);
            sc.close();
            
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}