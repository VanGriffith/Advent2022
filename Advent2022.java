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

        System.out.println(dayNumber);
        Day1.Day1.main(null);


    }

    private static void wrongInputProtocol() {
        System.err.println("Please enter an Integer 1-25 as command line argument");
    }
}