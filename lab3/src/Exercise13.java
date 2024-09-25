import java.util.*;

public class Exercise13 {
    public static void main(String[] args) {
        int[] combination1 = selectLotteryCombination();
        ArrayList<Integer> combination2 = selectLotteryCombinationList();

        System.out.println("Combination #1: " + Arrays.toString(combination1));
        System.out.println("Combination #2: " + combination2);
    }

    static ArrayList<Integer> selectLotteryCombinationList() {
        ArrayList<Integer> numbers = new ArrayList<>(49);
        for (int i = 0; i < 49; ++i) {
            numbers.add(i + 1);
        }

        Random random = new Random();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            int index = random.nextInt(numbers.size());
            result.add(numbers.get(index));
            numbers.remove(index);
        }

        Collections.sort(result);
        return result;
    }

    static int[] selectLotteryCombination() {
        int[] numbers = new int[49];
        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = i + 1;
        }

        Random random = new Random();
        int[] result = new int[6];
        for (int i = 0; i < 6; ++i) {
            int index = random.nextInt(numbers.length);
            result[i] = numbers[index];
            int[] tmp;
            tmp = removeItem(numbers, index);
            numbers = tmp;
        }

        Arrays.sort(result);
        return result;
    }

    static int[] removeItem(int[] array, int index) {
        int[] result = new int[array.length - 1];
        for (int i = 0; i < array.length; ++i) {
            if (i != index) {
                int newIndex = i < index ? i : i - 1;
                result[newIndex] = array[i];
            }
        }
        return result;
    }
}
