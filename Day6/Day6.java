package Day6;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day6 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day6/input.txt"));
            
            int subStreamLength = 4;
            char[] datastream = sc.next().toCharArray();
            for (int right = subStreamLength; right < datastream.length; right++) {
                int left = right - subStreamLength;

                boolean repeatFound = false;
                while (left < right) {
                    for (int j = left + 1; j < right; j++) {
                        if (datastream[left] == datastream[j]) {
                            repeatFound = true;
                        }
                    }
                    left++;
                }

                if (!repeatFound) {
                    System.out.println(right);
                    break;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}