package Day11;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Monkey {
    int monkeyNumber;
    Queue<Item> items;
    boolean operationMultiply;
    int operationNumber;

    int testNumber;
    
    int trueMonkeyNumber;
    int falseMonkeyNumber;
    Monkey trueMonkey;
    Monkey falseMonkey;

    int activity;

    public Monkey(int monkeyNumber) {
        this.monkeyNumber = monkeyNumber;
        this.items = new LinkedList<Item>();
        this.activity = 0;
    }

    public void addItem(Item item) {
        this.items.offer(item);
    }

    public void readStartingItems(String line) {
        line = line.substring(16);
        for (int i = 0; i < line.length() / 4; i++) {
            int itemNumber = Integer.parseInt(line.substring((i*4)+2, (i*4)+4));
            this.addItem(new Item(itemNumber));
        }
    }
    public void readOperation(String line) {
        Scanner sc = new Scanner(line);
        sc.next();
        sc.next();
        sc.next();
        sc.next();
        this.operationMultiply = sc.next().equals("*");
        try {
            int operationNumber = sc.nextInt();
            this.operationNumber = operationNumber;
        }
        catch (InputMismatchException e) {
            this.operationNumber = -1;
        }
        
        sc.close();
    }
    public void readTest(String line) {
        Scanner sc = new Scanner(line);
        sc.next();
        sc.next();
        sc.next();
        this.testNumber = sc.nextInt();

        sc.close();
    }
    public void readNextMonkeyNumbers(String lineOne, String lineTwo) {
        String line = lineOne + lineTwo;
        Scanner sc = new Scanner(line);
        sc.next();
        sc.next();
        sc.next();
        sc.next();
        sc.next();
        this.trueMonkeyNumber = sc.nextInt();
        sc.next();
        sc.next();
        sc.next();
        sc.next();
        sc.next();
        this.falseMonkeyNumber = sc.nextInt();

        sc.close();
    }

    public void print() {
        System.out.println("Monkey " + this.monkeyNumber + ":");
        System.out.print("Starting items: "); 
        while (!this.items.isEmpty()) {
            System.out.print(this.items.remove().getWorryLevel() + " ");
        }
        System.out.println("\n  Operation: new = old " + (this.operationMultiply ? "* ":"+ ") + operationNumber);
        System.out.println("  Test: divisible by " + testNumber);
        System.out.println("    If true: throw to monkey " + this.trueMonkeyNumber);
        System.out.println("    If false: throw to monkey " + this.falseMonkeyNumber);
        System.out.println();
    }

    public void inspectItems() {
        while (!this.items.isEmpty()) {
            Item item = this.items.remove();
            item.updateRemainders(this.operationMultiply, this.operationNumber);

            if (this.testItem(item)) {
                trueMonkey.addItem(item);
            }
            else {
                falseMonkey.addItem(item);
            }
            this.activity++;
        }
    }
/* 
    public void operate(Item item) {
        if (this.operationMultiply) {
            if (this.operationNumber == -1) {
                item.setWorryLevel(item.getWorryLevel() * item.getWorryLevel());
            }
            else {
                item.setWorryLevel(item.getWorryLevel() * this.operationNumber);
            }
        }
        else {
            item.setWorryLevel(item.getWorryLevel() + this.operationNumber);
        }
    }
*/

    public boolean testItem(Item item) {
        return item.test(this.testNumber);
    }

    public int activity() {
        return this.activity;
    }

    public void printItems() {
        System.out.print("Monkey " + this.monkeyNumber + ": ");
        Queue<Item> tempQueue = new LinkedList<Item>();

        while (!this.items.isEmpty()) {
            Item item = this.items.remove();
            tempQueue.add(item);
        }
        this.items = tempQueue;
        System.out.println();
    }

    public void printActivity() {
        System.out.println("Monkey " + this.monkeyNumber +
                            " inspected items " + this.activity +
                            " times.");
    }

    public int getDivisor() {
        return this.testNumber;
    }
    
}
