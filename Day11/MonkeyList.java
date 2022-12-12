package Day11;

import java.util.ArrayList;

public class MonkeyList {
    ArrayList<Monkey> monkeys;
    ArrayList<Integer> divisors;

    public MonkeyList() {
        this.monkeys = new ArrayList<Monkey>();
        this.divisors = new ArrayList<Integer>();
    }

    public void add(Monkey monkey) {
        this.monkeys.add(monkey);
    }

    public void round() {
        for (Monkey monkey: this.monkeys) {
            monkey.inspectItems();
        }
    }

    public void round(int numRounds) {
        for (int round = 0; round < numRounds; round++) {
            this.round();
        }
    }

    public void setDestinationMonkeys() {
        for (Monkey monkey: this.monkeys) {
            monkey.trueMonkey = this.monkeys.get(monkey.trueMonkeyNumber);
            monkey.falseMonkey = this.monkeys.get(monkey.falseMonkeyNumber);
        }
    }

    public int size() {
        return this.monkeys.size();
    }

    public ArrayList<Integer> getDivisors() {
        for (Monkey monkey: this.monkeys) {
            this.divisors.add(monkey.getDivisor());
        }
        return this.divisors;
    }

    public void printActivities() {
        for (Monkey monkey: monkeys) {
            monkey.printActivity();
        }
    }

    public void print() {
        for (Monkey monkey: this.monkeys) {
            monkey.print();
        }
    }
    
    public void printItems() {
        for (Monkey monkey: this.monkeys) {
            monkey.printItems();
        }
    }

    public long getMonkeyBusiness() {
        
        
        return 1;
    }
}

