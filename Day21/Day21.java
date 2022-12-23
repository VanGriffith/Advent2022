package Day21;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day21 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("Day21/input.txt"));
            HashMap<String, Monkey> monkeyMap = new HashMap<String, Monkey>();
            
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String name = line.substring(0,4);
                String rest = line.substring(6);
                Monkey monkey;

                try {
                    monkey = new Monkey(name, Integer.parseInt(rest));
                } catch (NumberFormatException e) {
                    monkey = new Monkey(name, rest);
                }

                monkeyMap.put(name, monkey);
                //System.err.printf("Monkeys Parsed: %d\n", monkeyMap.size());
            }
            long num = 3910938071000L;
            while (num <= 3910938072000L) {
                monkeyMap.get("humn").number = num;
                System.out.printf("%d: ", num);
                if (monkeyMap.get("root").getRootValues(monkeyMap)) {
                    System.out.printf("Match found! humn = %d", num);
                    break;
                }
                num += 1L;
            }
            
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}