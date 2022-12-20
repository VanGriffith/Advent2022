package Day17;

public class Cavern {
    public static final int ROCK_TYPES = 5;
    public static final int SUM_HEIGHTS = 13;
    public static final int START_X = 2;

    public static int caveWidth = 0, maxHeight = 0, highestRock = 0;
    public static boolean[][] caveArray;


    public int numRocks, moveNumber;
    public int rocksFallen;

    public Cavern(int caveWidth, int numRocks) {
        Cavern.highestRock = 0;
        Cavern.caveWidth = caveWidth;
        this.numRocks = numRocks;
        Cavern.maxHeight = ((this.numRocks / ROCK_TYPES) + 2) * SUM_HEIGHTS;
        Cavern.caveArray = new boolean[maxHeight][caveWidth];

        this.rocksFallen = 0;
        this.moveNumber = 0;
        
        for (int i = 0; i < caveWidth; i++) {
            Cavern.caveArray[0][i] = true;
        }
    }

    public void run() {

        for (rocksFallen = 0; rocksFallen < numRocks; rocksFallen++) {

            Tetranimo rock;
            int startY = highestRock + 4;
            switch (this.rocksFallen % ROCK_TYPES) {
                case 0: 
                    rock = new Horizontal(START_X, startY);
                    break;
                case 1: 
                    rock = new Plus(START_X, startY);
                    break;
                case 2: 
                    rock = new Hook(START_X, startY);
                    break;
                case 3:
                    rock = new Vertical(START_X, startY);
                    break;
                case 4:
                    rock = new Square(START_X, startY);
                    break;
                default:
                    throw new Error("Rock type OOB");
            }

            while (true) {
                switch (Day17.moves.charAt(moveNumber % Day17.movesLength)) {
                    case '<':
                        rock.pushLeft();
                        break;
                    case '>':
                        rock.pushRight();
                        break;
                    default:
                        throw new Error("Move Read input");
                }
                this.moveNumber++;
                if (rock.collision()) break;
                rock.fallDown();
            }
            rock.cement();

        }
    }

    public void print() {
        for (int row = Cavern.highestRock + 2; row > 0; row--) {
            System.out.print("|");
            for (int column = 0; column < caveWidth; column++) {
                System.out.print(caveArray[row][column] ? "#":".");
            }
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < caveWidth; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        System.out.printf("Rocks Fallen: %d\nCave Height: %d\nTower Height: %d\n", rocksFallen, maxHeight ,highestRock);
    }
}