package Day21;

import java.util.HashMap;

public class Monkey {
    
    String name;
    String monkeyOneName;
    String monkeyTwoName;
    char operation;
    boolean hasValue;
    long number;

    public Monkey(String name, String formula) {
        this.name = name;
        this.monkeyOneName = formula.split(" ")[0];
        this.monkeyTwoName = formula.split(" ")[2];
        this.operation = formula.split(" ")[1].charAt(0);
        this.hasValue = false;
    }

    public Monkey(String name, long number) {
        this.name = name;
        this.monkeyOneName = null;
        this.monkeyTwoName = null;
        this.number = number;
        this.hasValue = true;
    }

    public long getValue(HashMap<String, Monkey> monkeyMap) {
        if (!this.hasValue) {
            Monkey monkeyOne = monkeyMap.get(monkeyOneName);
            Monkey monkeyTwo = monkeyMap.get(monkeyTwoName);
            switch (this.operation) {
                case '+':
                    this.number = monkeyOne.getValue(monkeyMap) + monkeyTwo.getValue(monkeyMap);
                    break;
                case '-':
                    this.number = monkeyOne.getValue(monkeyMap) - monkeyTwo.getValue(monkeyMap);
                    break;
                case '*':
                    this.number = monkeyOne.getValue(monkeyMap) * monkeyTwo.getValue(monkeyMap);
                    break;
                case '/':
                    this.number =  monkeyOne.getValue(monkeyMap) / monkeyTwo.getValue(monkeyMap);
                    break;
                default:
                    throw new Error("ERROR: Operation error for " + this.operation + " on Monkey " + this.name);
            }
        }
        return this.number;
    }

    public boolean getRootValues(HashMap<String, Monkey> monkeyMap) {
        Monkey monkeyOne = monkeyMap.get(monkeyOneName);
        Monkey monkeyTwo = monkeyMap.get(monkeyTwoName);
        long monkeyOneValue = monkeyOne.getValue(monkeyMap);
        long monkeyTwoValue = monkeyTwo.getValue(monkeyMap);
        System.out.print(monkeyOneValue + " == " + monkeyTwoValue + "?");
        System.out.println(" " + (monkeyOneValue - monkeyTwoValue));
        return monkeyOneValue == monkeyTwoValue;
    }
}
