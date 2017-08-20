import java.util.HashMap;
import java.util.Map;

/**
 * Simple NQueens solution in Java using depth-first search and recursive backtracking.
 */

public class NQueens {

    /* Initialized by argument */
    private static int n = 0;
    /* Incremented every time we reach a solution */
    private static int num_solutions = 0;
    private static boolean print = true;

    public static void main(String[] args) {
        /* Get n from command line. Only 1 numeric argument is accepted */
        if (args.length == 1) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
        } else {
            System.err.println("There must be only 1 argument (n).");
            System.exit(1);
        }
        Map<Integer, Integer> placed = new HashMap<>();
        solveNQueens(placed, 0);
        System.out.println("There are " + num_solutions + " solutions to " + n + "-queens problem");
    }

    /**
     * We step through all the rows  0 -> n.
     * If we make it to last row, we have a valid solution and it's printed. We also increment the number of solutions.
     * At every step:
     * We iterate over all the columns and check if placing a queen at the current row and column would be valid.
     * If valid given currently placed queens, we add queen's position to placed map and recursively solve for row + 1
     * Because we want to print out all solutions, we don't return anything. If it's successful, it will get printed.
     *
     * @param placed : currently placed queens
     * @param row : current row
     */
        static void solveNQueens(Map<Integer, Integer> placed, int row) {
        if (row == n) {
            num_solutions++;
            if (print) printBoard(placed);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, placed)) {
                placed.put(row, col);
                solveNQueens(placed, row + 1);
                placed.remove(row);
            }
        }
    }

    /**
     * Check if placing a queen at this row and column would be a valid placement, given already placed queens.
     *
     * @param row : row to check
     * @param col : column to check
     * @param placed : currently placed queens
     * @return true if valid placement, else false
     */
    private static boolean isValid(int row, int col, Map<Integer, Integer> placed) {
        /* Row is guaranteed to be unique */
        for (Integer r : placed.keySet()) {
            /* Check column */
            Integer c = placed.get(r);
            if (c == col) return false;
            /* Check diagonals */
            if (isOnDiagonal(row, col, r, c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if two points are on each other's diagonals.
     *
     * @param row1 : row of point 1
     * @param col1 : column of point 1
     * @param row2 : row of point 2
     * @param col2 : column of point 2
     * @return true if on diagonal, else false
     */
    private static boolean isOnDiagonal(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) == Math.abs(col1 - col2);
    }

    /**
     * Print the entire board, given the placed queens
     *
     * @param placed : queens placed
     */
    private static void printBoard(Map<Integer, Integer> placed) {
        for (int row = 0; row < n; row++) {
            System.out.print("|");
            for (int col = 0; col < n; col++) {
                Integer c = placed.get(row);
                String Q = " ";
                if (c == col) {
                    Q = "Q";
                }
                System.out.print(Q + "|");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    static int getNum_solutions() {
        return num_solutions;
    }

    static int getN() {
        return n;
    }

    static void setN(int n) {
        NQueens.n = n;
    }

    static void setPrint(boolean print) {
        NQueens.print = print;
    }

    static void reset() {
        n = 0;
        num_solutions = 0;
    }
}

