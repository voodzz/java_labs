import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndividualWork {
    public static void main(String[] args) throws IOException {
        countNumbersInFile("input.txt");
    }

    public static void countNumbersInFile(String fileName) throws IOException {
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter("[\\s,;\n]+");

        double sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }

        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write("Sum: " + sum);
        fileWriter.close();
    }
}
