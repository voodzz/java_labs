import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    Present readPresentFromFile(String fileName) throws IOException, IllegalArgumentException {
        ArrayList<Candy> candies = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("[\\s]+");
            if (tokens.length != 4) {
                throw new IllegalSizeOfLineException("Your candy has more or less than 4 characteristics\n" +
                        "It should be: type_of_chocolate/color, type_of_candy, weight, percent_of_sugar.");
            }
            String typeOfChocolateOrColor = tokens[0];
            String typeOfCandy = tokens[1];
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

            double weight = Double.parseDouble(tokens[2]);
            double percentOfSugar = Double.parseDouble(tokens[3]);
            if (percentOfSugar > 100 || percentOfSugar < 0) {
                throw new IllegalArgumentException("Percent of sugar is out of bounds.");
            }
            if (typeOfCandy.equalsIgnoreCase("chocolate")) {
                candies.add(new Chocolate(weight, percentOfSugar, ChocolateType.valueOf(typeOfChocolateOrColor.toUpperCase())));
            } else {
                candies.add(new Lollipop(weight, percentOfSugar, LollipopColor.valueOf(typeOfChocolateOrColor.toUpperCase())));
            }
        }

        return new Present(candies);
    }
}
