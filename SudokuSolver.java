public class SudokuSolver {
    public static int steps = 0;

    // Main solver method using backtracking
    public static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            steps++;
                            if (solve(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false; // backtrack
                }
            }
        }
        return true; // solution found
    }

    // Check if a number is safe to place at given cell
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Row and column check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        // 3x3 subgrid check
        int boxRow = row - row % 3, boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    // Reset step counter
    public static void resetSteps() {
        steps = 0;
    }

    // Check if board is currently valid (no duplicates)
    public static boolean isValidBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[10];
            boolean[] colCheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int rowVal = board[i][j];
                int colVal = board[j][i];

                if (rowVal != 0) {
                    if (rowCheck[rowVal]) return false;
                    rowCheck[rowVal] = true;
                }

                if (colVal != 0) {
                    if (colCheck[colVal]) return false;
                    colCheck[colVal] = true;
                }
            }
        }

        // Check 3x3 subgrids
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] boxCheck = new boolean[10];
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        int val = board[i][j];
                        if (val != 0) {
                            if (boxCheck[val]) return false;
                            boxCheck[val] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    // Check if the board is fully and correctly solved
    public static boolean isSolved(int[][] board) {
        return isValidBoard(board) && !hasEmptyCell(board);
    }

    private static boolean hasEmptyCell(int[][] board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == 0)
                    return true;
        return false;
    }

    // Count how many solutions the board has (used for puzzle validation)
    public static int countSolutions(int[][] board) {
        return countHelper(board, 0);
    }

    private static int countHelper(int[][] board, int count) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            count = countHelper(board, count);
                            board[row][col] = 0;
                        }
                    }
                    return count;
                }
            }
        }
        return count + 1; // One valid solution found
    }
}
