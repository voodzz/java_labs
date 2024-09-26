import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        executeTask3(string);
    }

    public static void executeTask1(int num1, int num2) {
        System.out.println(String.valueOf(num1) + " + " + String.valueOf(num2) + " = " + String.valueOf(num1 + num2));
        System.out.println(String.valueOf(num1) + " - " + String.valueOf(num2) + " = " + String.valueOf(num1 - num2));
        System.out.println(String.valueOf(num1) + " * " + String.valueOf(num2) + " = " + String.valueOf(num1 * num2));
    }

    public static void executeTask2(String string) {
        int counter = 0;
        String[] tokens = string.split("\\s");
        for (int i = 0; i < tokens.length; ++i) {
            if (tokens[i].matches("[a-zA-Z]+")) {
                ++counter;
            }
        }
        System.out.println("Количество слов, состоящих только из символов латинского алфавита: " +
                            String.valueOf(counter));
    }

    public static void executeTask3(String string) {
        String[] words = string.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.matches("\\d+")) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(word);
            }
        }

        System.out.println("Результат: " + result.toString());
    }
}