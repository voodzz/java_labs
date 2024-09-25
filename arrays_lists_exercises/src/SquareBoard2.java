import java.util.Scanner;

// 15
public class SquareBoard2
{
    private String[][] board;
    private int length;

    /**
     Constructs an empty square game board.
     @param sideLength the length of each side
     */
    public SquareBoard2(int sideLength)
    {
        length = sideLength;
        board = new String[length][length];
        // Fill with spaces
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                board[i][j] = " ";
    }

    /**
     Creates a string representation of the board, such as
     |x o|
     | x |
     | o |.
     @return the string representation
     */
    public String toString()
    {
        String r = "";
        for (int i = 0; i < length; i++)
        {
            r = r + "|";
            for (int j = 0; j < length; j++)
                r = r + board[i][j];
            r = r + "|\n";
        }
        return r;
    }

    /**
     Fills the borders of this board with "*" strings.
     */
    public void fillBorders()
    {
        for (int i = 0; i < length; i++) {
            board[i][0] = "*";
            board[0][i] = "*";
            board[length - i - 1][length - 1] = "*";
            board[length - 1][length-i-1] = "*";
        }
    }

    // This method is used to check your work.

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        SquareBoard2 board = new SquareBoard2(n);
        board.fillBorders();
        System.out.println(board.toString());
    }
}