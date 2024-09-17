import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new RuntimeException("Wrong number of arguments");
        }
        double x;
        double precision;
        try {
            x = Double.parseDouble(args[0]);
            precision = Double.parseDouble(args[1]);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong arguments. Please enter valid numbers.");
            Scanner in = new Scanner(System.in);
            String newInput1 = in.nextLine();
            String newInput2 = in.nextLine();
            x = Double.parseDouble(newInput1);
            precision = Double.parseDouble(newInput2);
        }
        double sum = calculateSum(x, precision);
        System.out.println(sum);
    }

    private static double calculateSum(double x, double precision) {
        //x ^ (3 * k ^ 2)
        double sum = 0;
        int k = 1;
        double summand = Math.pow(x, 3 * Math.pow(k, 2));

        while (Math.abs(summand) >= precision) {
            sum += summand;
            summand *= Math.pow(x, 6 * k + 3);
            ++k;
        }

        return sum;
    }
}