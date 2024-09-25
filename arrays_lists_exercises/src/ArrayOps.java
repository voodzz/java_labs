import java.util.ArrayList;
import java.lang.String;

public class ArrayOps {
    // 1
    public static int sumArray(int values[]) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
    // 2
    public static double averagePrice(double[] priceData)
    {
        double average = 0;
        int count = 0;
        for (double value : priceData) {
            count++;
            average += value;
        }
        return average/count;
    }
    // 3
    public static int middleArray(int values[])
    {
        int middleIndex = values.length / 2;
        if (values.length % 2 == 0) middleIndex--;
        return values[middleIndex];
    }
    // 4
    public static int findValue(int values[], int valueToFind)
    {
        int i = 0;
        boolean find = false;
        while (i < values.length && !find) {
            if (values[i] == valueToFind) find = true;
            else i++;
        }
        return i;
    }
    // 5
    public static int countOccurs(int[] theArray, int theInt) {
        int count = 0;

        for (int value : theArray) {
            if (value == theInt) {
                count++;
            }
        }
        return count;
    }
    // 6
    public static int bigSum(int[][] theArray)
    {
        int firstSum = sumArray(theArray[0]);
        int secondSum = sumArray(theArray[1]);
        return firstSum > secondSum ? firstSum : secondSum;
    }
    // 7
    public static double[] makeAverage(double[] test1, double[] test2)
    {
        double[] averages = new double[test1.length];
        for (int i = 0; i < test1.length; i++) {
            averages[i] = (test1[i] + test2[i]) / 2;
        }
        return averages;
    }
    // 8
    public static int testAverage(double[][] theArray, int numStudents)
    {
        int NUM_TESTS = 3;
        int numOf = 0;
        for (int i = 0; i < theArray.length; i++) {
            double average = 0;
            for (double value : theArray[i]) {
                average+=value;
            }
            average /= NUM_TESTS;
            numOf += average < 70 ? 1 : 0;
        }
        return numOf;
    }
    // 9
    public static ArrayList<Integer> copyReverse(int[] anArray)
    {
        ArrayList <Integer> reverse = new ArrayList<>();
        for (int i = anArray.length-1; i >= 0; i--) {
            reverse.add(anArray[i]);
        }
        return reverse;
    }
    // 10
    public static ArrayList<Integer> copyArray(int[] anArray) {
        ArrayList<Integer> uniqueIntAL = new ArrayList<>();
        for (int value : anArray) {
            if (!uniqueIntAL.contains(value)) {
                uniqueIntAL.add(value);
            }
        }
        return uniqueIntAL;
    }
    // 11
    public String separateWithCommas(int[] values)
    {
       String str = "";
       for (int i = 0; i < values.length; i++) {
           str+= values[i] + ((values.length - i == 1) ? "" : ",");
       }
       return str;
    }
    // 12
    public ArrayList<String> shortWords(String[] words)
    {
        ArrayList <String> str = new ArrayList<>();
        for (String word : words) {
            if (word.length() <= 3) str.add(word);
        }
        return str;
    }
    // 13
    public String nthShortWord(String[] words, int n)
    {
        int count = 0;
        String str = "";
        for (int i = 0; i < words.length && count < n; i++) {
            if (words[i].length() <= 3) count++;
            if (count == n) str = words[i];
        }
        return str;
    }
    // 14 and 15 is SquareBoard and SquareBoard2
    // 16
    public int lengthOfLongestRun(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int longestRun = 1;
        int currentRun = 1;

        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                currentRun++;
            } else {
                if (currentRun > longestRun) {
                    longestRun = currentRun;
                }
                currentRun = 1;
            }
        }

        if (currentRun > longestRun) {
            longestRun = currentRun;
        }

        return longestRun;
    }
    // 17
    public int sameEnds(int[] values) {
        int n = values.length;
        int maxLength = 0;
        for (int len = 1; len <= n / 2; len++) {
            boolean isSame = true;
            for (int i = 0; i < len; i++) {
                if (values[i] != values[n - len + i]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                maxLength = len;
            }
        }

        return maxLength;
    }
    // 18
    public static void removeShortWords(String[] words) {
        int insertPos = 0;  // Keeps track of where to place the next non-short word
        for (String word : words) {
            if (word.length() > 3) {
                words[insertPos] = word;
                insertPos++;
            }
        }
        for (int i = insertPos; i < words.length; i++) {
            words[i] = "";
        }
    }
    // 19
    public int[] evenOdds(int[] values)
    {
        int[] array = new int[2];
        for (int value : values) {
            array[value % 2 == 0 ? 0 : 1]++;
        }
        return array;
    }
    // 20
    public int[] letterFrequencies(String str) {
        int[] counts = new int[26];
        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            }
        }

        return counts;
    }
    // 21
    public double[] letterFrequenciesP(String str)
    {
        double[] counts = new double[26];
        str = str.toLowerCase();
        int num = 0;

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
                num++;
            }
        }
        for (int i = 0; i < 26; i++) {
            counts[i] /= num;
        }
        return counts;
    }
    // 22
    public void swapFirstAndSecondHalf(int[] values) {
        int n = values.length;
        int half = n / 2;

        for (int i = 0; i < half; i++) {
            int temp = values[i];
            values[i] = values[n - half + i];
            values[n - half + i] = temp;
        }
    }
    // 23
    public void swapAdjacentElements(int[] values) {
        for (int i = 0; i < values.length - 1; i += 2) {
            int temp = values[i];
            values[i] = values[i + 1];
            values[i + 1] = temp;
        }
    }
    // 24
    public String[][] makeFence(String message) {
        int numRails = 3;  // Default number of rails
        int length = message.length();

        // Create the 2D array (rails x message length)
        String[][] fence = new String[numRails][length];

        // Initialize the fence array with nulls
        for (int i = 0; i < numRails; i++) {
            for (int j = 0; j < length; j++) {
                fence[i][j] = null;
            }
        }

        int row = 0;   // Current row (rail)
        boolean down = true;  // Direction of movement: down or up

        // Place characters in the fence pattern
        for (int col = 0; col < length; col++) {
            // Place the character in the current rail
            fence[row][col] = String.valueOf(message.charAt(col));

            // Determine whether we need to move down or up
            if (down) {
                row++;
                if (row == numRails) {
                    // Reached the bottom, start moving up
                    row = numRails - 2;
                    down = false;
                }
            } else {
                row--;
                if (row == -1) {
                    // Reached the top, start moving down
                    row = 1;
                    down = true;
                }
            }
        }

        return fence;
    }
}
