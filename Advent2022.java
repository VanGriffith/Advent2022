public class Advent2022 {

    public static void main(String[] args) {

        int dayNumber = 0;
        try {
            dayNumber = Integer.parseInt(args[0]);

            if (dayNumber < 1 || dayNumber > 25) {
                throw new NumberFormatException();
            }
        }
        catch (Error e) {
            wrongInputProtocol();
        }

        System.out.printf("Day %d's answers:\n", dayNumber);
        switch (dayNumber) {
            case 1:
                Day1.Day1.main(null);
                break;

            case 2:
                Day2.Day2.main(null);
                Day2.Day2Problem2.main(null);
                break;

            case 3:
                Day3.Day3.main(null);
                Day3.Day3Problem2.main(null);
                break;
            case 4:
                Day4.Day4.main(null);
                break;
            case 5:
                Day5.Day5.main(null);
                break;
            case 6:
                Day6.Day6.main(null);
                break;
            case 7:
                Day7.Day7.main(null);
               break;
            /*
            case 8:
              Day8.Day8.main(null);
              break;
            /*
            case 9:
                Day9.Day9.main(null);
                break;
            /*
            case 10:
                Day10.Day10.main(null);
                break;
            /*
            case 11:
                Day11.Day11.main(null);
                break;
            /*
            case 12:
                Day12.Day12.main(null);
                break;
            /*
            case 13:
                Day13.Day13.main(null);
                break;
            /*
            case 14:
                Day14.Day14.main(null);
                break;
            /*
            case 15:
                Day15.Day15.main(null);
                break;
            /*
            case 16:
                Day16.Day16.main(null);
                break;
            /*
            case 17:
                Day17.Day17.main(null);
                break;
            /*
            case 18:
                Day18.Day18.main(null);
                break;
            /*
            case 19:
                Day19.Day19.main(null);
                break;
            /*
            case 20:
                Day20.Day20.main(null);
                break;
            /*
            case 21:
                Day21.Day21.main(null);
                break;
            /*
            case 22:
                Day22.Day22.main(null);
                break;
            /*
            case 23:
                Day23.Day23.main(null);
                break;
            /*
            case 24:
                Day24.Day24.main(null);
                break;
            /*
            case 25:
                Day25.Day25.main(null);
                break;
            */
            default:
                wrongInputProtocol();
                break;

        }

    }

    private static void wrongInputProtocol() {
        System.err.println("Please enter an Integer 1-25 as command line argument");
        System.exit(0);
    }
}
