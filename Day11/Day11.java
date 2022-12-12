package Day11; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day11 {
    public static void main(String[] args) { 
        try {
            Scanner sc = new Scanner(new File("Day11/input.txt"));
            MonkeyList monkeys = new MonkeyList();

            while (sc.hasNextLine()) {
                int monkeyNumber;
                String line = sc.nextLine();
                monkeyNumber = Integer.parseInt(line.substring(7,8));
                Monkey monkey = new Monkey(monkeyNumber);
                monkey.readStartingItems(sc.nextLine());
                monkey.readOperation(sc.nextLine());
                monkey.readTest(sc.nextLine());
                monkey.readNextMonkeyNumbers(sc.nextLine(), sc.nextLine());
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                monkeys.add(monkey);
            }
            monkeys.setDestinationMonkeys();
            monkeys.getDivisors();
            monkeys.round(10000);

            monkeys.printActivities();

            


            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            e.printStackTrace();
        }
    }
}