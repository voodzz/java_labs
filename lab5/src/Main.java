import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Exponential progression = new Exponential(2, 2, 5);
        System.out.println(progression.toString());
        System.out.println(progression.findElementJ(10));
        progression.printToFile("output.txt");
    }
}
