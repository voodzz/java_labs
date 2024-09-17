public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Invalid number of arguments.");
            }
            checkInput(args[0]);
            StringBuilder string = new StringBuilder(args[0]);
            StringBuilder result = new StringBuilder(deleteSymbols(string));
            System.out.print("Result: " + result);
        } catch (IllegalArgumentException e) {
            StringBuilder defaultString = new StringBuilder("I (love Java((I love Java))I love) Java");
            System.out.println("Your input is wrong. Default value: " + defaultString);
            StringBuilder result = new StringBuilder(deleteSymbols(defaultString));
            System.out.print("Result: " + result);
        }
    }

    static void checkInput(String string) {
        int openBrackets = 0;
        int closingBrackets = 0;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == '(') {
                ++openBrackets;
            }
            if (string.charAt(i) == ')') {
                ++closingBrackets;
            }
        }
        if (openBrackets != closingBrackets) {
            throw new IllegalArgumentException("Brackets are not balanced.");
        }
    }

    static StringBuilder deleteSymbols(StringBuilder string) {
        int lastOpenBracket = string.lastIndexOf("(");
        int firstClosingBracket = string.indexOf(")");
        for (int i = lastOpenBracket + 1; i < firstClosingBracket; ++i) {
            string.deleteCharAt(i);
            --i;
            --firstClosingBracket;
        }
        return string;
    }
}