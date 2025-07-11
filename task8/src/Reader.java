import java.io.*;
import java.util.ArrayList;

public class Reader {
    Present readPresentFromFile(File file) throws IOException, IllegalArgumentException {
        ArrayList<Candy> candies = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("[\\s]+");
            if (tokens.length != 4) {
                throw new IllegalSizeOfLineException("Your candy has more or less than 4 characteristics\n" +
                        "It should be: type_of_chocolate/color, type_of_candy, weight, percent_of_sugar.");
            }

            String typeOfChocolateOrColor = tokens[0];
            String typeOfCandy = tokens[1];
            double weight = Double.parseDouble(tokens[2]);
            double percentOfSugar = Double.parseDouble(tokens[3]);
            checkTypeOrColorAndTypeMatching(typeOfChocolateOrColor, typeOfCandy, weight, percentOfSugar);

            if (typeOfCandy.equalsIgnoreCase("chocolate")) {
                candies.add(new Chocolate(weight, percentOfSugar, ChocolateType.valueOf(typeOfChocolateOrColor.toUpperCase())));
            } else {
                candies.add(new Lollipop(weight, percentOfSugar, LollipopColor.valueOf(typeOfChocolateOrColor.toUpperCase())));
            }
        }

        return new Present(candies);
    }

    String readDataFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder buffer = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            buffer.append(line).append('\n');
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

    void checkTypeOrColorAndTypeMatching(String typeOfChocolateOrColor, String typeOfCandy,
                                         double weight, double percentOfSugar) throws IllegalArgumentException {
        if (!typeOfCandy.equalsIgnoreCase("chocolate") &&
                !typeOfCandy.equalsIgnoreCase("lollipop")) {
            throw new IllegalTypeOfCandyException("Your candy is not chocolate or lollipop.");
        } else if (typeOfCandy.equalsIgnoreCase("lollipop") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("blue") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("red") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("yellow") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("orange") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("green")) {
            throw new IllegalArgumentException("Your lollipop has illegal color or it's not a color at all: " +
                    typeOfChocolateOrColor);
        } else if (typeOfCandy.equalsIgnoreCase("chocolate") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("bitter") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("milk") &&
                !typeOfChocolateOrColor.equalsIgnoreCase("white")) {
            throw new IllegalArgumentException("Your chocolate is of incorrect type: " + typeOfChocolateOrColor);
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight is less than or equal to zero.");
        }
        if (percentOfSugar > 100 || percentOfSugar < 0) {
            throw new IllegalArgumentException("Percent of sugar is out of bounds.");
        }
    }
}
