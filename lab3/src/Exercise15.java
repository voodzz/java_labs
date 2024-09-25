import java.util.ArrayList;
import java.util.Arrays;

public class Exercise15 {
    public static void main(String[] args) {
        int[][] pascalTriangle1 = findPascalTriangle(5);
        ArrayList<ArrayList<Integer>> pascalTriangle2 = findPascalTriangleList(5);

        for (int[] row : pascalTriangle1) {
            System.out.println(Arrays.toString(row));
        }

        for (ArrayList<Integer> row : pascalTriangle2) {
            System.out.println(row);
        }
    }

    static int[][] findPascalTriangle(int n) {
        int[][] pascalTriangle = new int[n][];

        for (int i = 0; i < n; ++i) {
            pascalTriangle[i] = new int[i + 1];
            pascalTriangle[i][0] = pascalTriangle[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }

        return pascalTriangle;
    }

    static ArrayList<ArrayList<Integer>> findPascalTriangleList (int n) {
        ArrayList<ArrayList<Integer>> pascalTriangle= new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; ++j) {
                int value = pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j);
                row.add(value);
            }
            if (i > 0) {
                row.add(1);
            }
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }
}
