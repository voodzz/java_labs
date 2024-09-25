import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        System.out.println(isMagicSquare());
    }

    static boolean isMagicSquareList() throws IllegalArgumentException {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // Вводим до пустой строки
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }

            String[] elements = line.split("\\s+");
            ArrayList<Integer> matrixLine = new ArrayList<>();
            for (String element : elements) {
                matrixLine.add(Integer.parseInt(element));
            }
            matrix.add(matrixLine);
        }
        scanner.close();

        int size = matrix.getFirst().size();
        for (ArrayList<Integer> line : matrix) {
            if (line.size() != size) {
                throw new IllegalArgumentException("Lines in matrix have different sizes.");
            }
        }

        size = matrix.size();
        if (size != matrix.getFirst().size()) {
            throw new IllegalArgumentException("Matrix is not square.");
        }

        int sum = 0;
        for (Integer element : matrix.getFirst()) {
            sum += element;
        }

        // Проверяем строки
        for (ArrayList<Integer> line : matrix) {
            int tmpSum = 0;
            for (Integer element : line) {
                tmpSum += element;
            }
            if (tmpSum != sum) {
                return false;
            }
        }

        // Проверяем столбцы
        for (int i = 0; i < size; ++i) {
            int tmpSum = 0;
            for (int j = 0; j < size; ++j) {
                tmpSum += matrix.get(j).get(i);
            }
            if (tmpSum != sum) {
                return false;
            }
        }

        // Проверяем главную диагональ
        int tmpSum = 0;
        for (int i = 0; i < size; ++i) {
            tmpSum += matrix.get(i).get(i);
        }
        if (tmpSum != sum) {
            return false;
        }
        tmpSum = 0;

        // Проверяем побочную диагональ
        int column = size - 1;
        for (int i = 0; i < size; ++i) {
            tmpSum += matrix.get(i).get(column);
            --column;
        }

        return tmpSum == sum;
    }

    static boolean isMagicSquare() throws IllegalArgumentException {
        ArrayList<int[]> matrixList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }

            String[] elements = line.split("\\s+");
            int[] row = new int[elements.length];
            for (int i = 0; i < row.length; ++i) {
                row[i] = Integer.parseInt(elements[i]);
            }

            matrixList.add(row);
        }
        scanner.close();

        int size = matrixList.getFirst().length;
        for (int[] line : matrixList) {
            if (line.length != size) {
                throw new IllegalArgumentException("Lines in matrix have different sizes.");
            }
        }

        size = matrixList.size();
        if (size != matrixList.getFirst().length) {
            throw new IllegalArgumentException("Matrix is not square.");
        }

        int[][] matrix = matrixList.toArray(new int[matrixList.size()][matrixList.size()]);

        int sum = 0;
        for (Integer element : matrix[0]) {
            sum += element;
        }

        // Проверяем строки
        for (int[] line : matrix) {
            int tmpSum = 0;
            for (Integer element : line) {
                tmpSum += element;
            }
            if (tmpSum != sum) {
                return false;
            }
        }

        // Проверяем столбцы
        for (int i = 0; i < size; ++i) {
            int tmpSum = 0;
            for (int j = 0; j < size; ++j) {
                tmpSum += matrix[j][i];
            }
            if (tmpSum != sum) {
                return false;
            }
        }

        // Проверяем главную диагональ
        int tmpSum = 0;
        for (int i = 0; i < size; ++i) {
            tmpSum += matrix[i][i];
        }
        if (tmpSum != sum) {
            return false;
        }
        tmpSum = 0;

        // Проверяем побочную диагональ
        int column = size - 1;
        for (int i = 0; i < size; ++i) {
            tmpSum += matrix[i][column];
            --column;
        }

        return tmpSum == sum;
    }
}
