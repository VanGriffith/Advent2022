package Day4; 
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Day4 {
        public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day4/input.txt")); 
            int totalBadPairs = 0;
            
            while (sc.hasNext()) {
                String elfPair = sc.nextLine();

                Scanner pairScanner = new Scanner(elfPair);
                pairScanner.useDelimiter(",");
                String elfOne = pairScanner.next();
                String elfTwo = pairScanner.next();

                Scanner elfScanner = new Scanner(elfOne);
                elfScanner.useDelimiter("-");
                int elfOneStart = Integer.parseInt(elfScanner.next());
                int elfOneEnd = Integer.parseInt(elfScanner.next());
                elfScanner.close();
                elfScanner = new Scanner(elfTwo);
                elfScanner.useDelimiter("-");
                int elfTwoStart = Integer.parseInt(elfScanner.next());
                int elfTwoEnd = Integer.parseInt(elfScanner.next());
                
                if (elfOneStart > elfTwoEnd || elfOneEnd < elfTwoStart) {

                }
                else {
                    totalBadPairs += 1;
                }

                pairScanner.close();
                elfScanner.close();
            }
            sc.close();

            System.out.println(totalBadPairs);
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}