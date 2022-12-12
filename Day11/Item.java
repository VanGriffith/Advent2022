package Day11;


public class Item {
    public int worryLevel;
    public static int[] divisors = {17, 3, 19, 7, 2, 5, 11, 13}; 
    public int[] remainders;

    public Item(int worryLevel) {
        this.worryLevel = worryLevel;
        this.remainders = new int[Item.divisors.length];
        this.setRemainders();
    }

    public int getWorryLevel() {
        return this.worryLevel;
    }

    /* 
    public int reduceWorryLevel() {
        this.worryLevel /= 3;
        return this.worryLevel;
    }
    */

    public void setWorryLevel(int newLevel) {
        this.worryLevel = newLevel;
    }

    public void setRemainders() {
        for (int i = 0; i < this.remainders.length; i++) {
            this.remainders[i] = this.worryLevel % Item.divisors[i];
        }
    }

    public void updateRemainders(boolean multiplying, int operationNumber) {
        for (int i = 0; i < this.remainders.length; i++) {
            if (operationNumber == -1) {
                this.remainders[i] *= this.remainders[i];
            }
            else if (multiplying) {
                this.remainders[i] *= operationNumber;
            }
            else {
                this.remainders[i] += operationNumber;
            }
            
            this.remainders[i] = this.remainders[i] % Item.divisors[i];
        }
    }

    public boolean test(int testNumber) {
        for (int i = 0; i < Item.divisors.length; i++) {
            if (Item.divisors[i] == testNumber && this.remainders[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
