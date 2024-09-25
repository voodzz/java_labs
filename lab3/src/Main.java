import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException {
        String fileName = "inputWithoutSize.txt";
        int[][] matrix = readInputWithoutSize(fileName);
        double[] solution = solveTriangularSystemOfLinearEquations(matrix);
        for (int i = 0; i < solution.length; ++i) {
            System.out.printf("x_%d = %.5f", i + 1,solution[i]);
            System.out.println();
        }
    }

    static int[][] readInputWithSize(String fileName) throws FileNotFoundException, IllegalArgumentException {
        Scanner scanner = new Scanner(new File(fileName));

        String[] size = scanner.nextLine().split("\\s+");
        if (size.length != 2) {
            throw new IllegalArgumentException("Your matrix is not 2-dimensional.");
        }
        if (Integer.parseInt(size[0]) + 1 != Integer.parseInt(size[1])) {
            throw new IllegalArgumentException("Illegal matrix size.");
        }

        int n = Integer.parseInt(size[0]);
        int[][] matrix = new int[n][n + 1];

        for (int i = 0; i < n; ++i) {
            if (scanner.hasNext()) {
                String[] line = scanner.nextLine().split("\\s+");
                if (line.length != n + 1) {
                    throw new IllegalArgumentException("Lines in your matrix have more or less than n + 1 elements.");
                }
                for (int j = 0; j < n + 1; ++j) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if (i > j && matrix[i][j] != 0) {
                        throw new IllegalArgumentException("Matrix is not upper triangular.");
                    }
                }
            } else {
                throw new IllegalArgumentException("Your matrix has less than n lines.");
            }
        }

        scanner.close();
        return matrix;
    }

    static int[][] readInputWithoutSize(String fileName) throws FileNotFoundException, IllegalArgumentException {
        Scanner scanner = new Scanner(new File(fileName));

        ArrayList<String[]> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine().split("\\s+"));
        }

        int m = lines.getFirst().length;
        if (lines.size() != m - 1) {
            throw new IllegalArgumentException("Matrix has illegal size.");
        }
        for (String[] line : lines) {
            if (line.length != m) {
                throw new IllegalArgumentException("Lines are not of the same size.");
            }
        }

        int[][] matrix = new int[m - 1][m];
        for (int i = 0; i < m - 1; ++i) {
            String[] line = lines.get(i);
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = Integer.parseInt(line[j]);
                if (i > j && matrix[i][j] != 0) {
                    throw new IllegalArgumentException("Matrix is not upper triangular.");
                }
            }
        }
        return matrix;
    }

    static double[] solveTriangularSystemOfLinearEquations(int[][] extendedMatrix) {
        int n = extendedMatrix.length;
        double[] solution = new double[n];

        //Обратный ход
        for (int i = n - 1; i >= 0; --i) {
            double sum = extendedMatrix[i][n]; // b_i
            for (int j = i + 1; j < n; ++j) {
                sum -= extendedMatrix[i][j] * solution[j];
            }
            solution[i] = sum / extendedMatrix[i][i];
        }

        return solution;
    }
}