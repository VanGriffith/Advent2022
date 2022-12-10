import java.util.ArrayList;

public class Clock {
    int X;
    ArrayList<Integer> cycles;

    public Clock() {
        this.X = 1;
        this.cycles = new ArrayList<Integer>();
        this.cycles.add(0);
    }

    public void noop() {
        this.cycles.add(this.X);
    }

    public void addx(int addend) {
        for (int i = 0; i < 2; i++) {
            this.cycles.add(this.X);
        }
        this.X += addend;
    }

    public int getSignalStrengths(int[] cycleIndex) {
        int sum = 0;
        
        for (int i = 0; i < cycleIndex.length; i++) {
            int xAtI = this.cycles.get(cycleIndex[i]);
            int strength = xAtI * cycleIndex[i];
            System.out.println("X at " + cycleIndex[i] + " is " + xAtI + ", strength is " + strength);
            sum += strength;

            System.out.println("total sum is " + sum);
        }
        return sum;
    }
    
    public void printCRT() {
        for (int i = 1; i < this.cycles.size(); i++) {

           // int pixel = i - 1;
           // pixel -= ((i - 1) / 40) * 40;

            if ((i - 1 - ((i - 1) / 40) * 40) == this.cycles.get(i) - 1 ||
                (i - 1 - ((i - 1) / 40) * 40) == this.cycles.get(i) + 1 ||
                (i - 1 - ((i - 1) / 40) * 40) == this.cycles.get(i)) {
                System.out.print("#");
            }
            else {
                System.out.print(" ");
            }

            if (i % 40 == 0) {
                System.out.println();
            }
        }
    }
}
