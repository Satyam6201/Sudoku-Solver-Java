import java.util.Random;

public class SudokuGenerator {
    private static final int SIZE = 9;
    private static final int EMPTY = 0;
    private static final Random rand = new Random();

    // Generate a fully filled valid Sudoku board
    public static int[][] generateFullBoard() {
        int[][] board = new int[SIZE][SIZE];
        fillBoard(board);
        return board;
    }

    // Backtracking to fill board with valid numbers
    private static boolean fillBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    int[] numbers = shuffledNumbers();
                    for (int num : numbers) {
                        if (SudokuSolver.isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard(board)) return true;
                            board[row][col] = EMPTY;
                        }
                    }
                    return false; // backtrack
                }
            }
        }
        return true;
    }

    // Generate a puzzle with given number of clues (by removing numbers)
    public static int[][] generatePuzzle(int clues) {
        int[][] board = generateFullBoard();
        int attempts = 0;

        int removed = SIZE * SIZE - clues;

        while (removed > 0 && attempts < 1000) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);

            if (board[row][col] != EMPTY) {
                int backup = board[row][col];
                board[row][col] = EMPTY;

                int[][] tempBoard = deepCopy(board);
                int solutions = SudokuSolver.countSolutions(tempBoard);

                if (solutions != 1) {
                    // If not uniquely solvable, restore the value
                    board[row][col] = backup;
                } else {
                    removed--;
                }
                attempts++;
            }
        }

        if (attempts >= 1000) {
            System.out.println("⚠️ Warning: Puzzle generation took too many attempts. Regenerating...");
            return generatePuzzle(clues); // fallback: try again
        }

        return board;
    }

    // Shuffle numbers 1-9
    private static int[] shuffledNumbers() {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = i + 1;
        for (int i = 0; i < SIZE; i++) {
            int j = rand.nextInt(SIZE);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    // Create a deep copy of a board
    private static int[][] deepCopy(int[][] board) {
        int[][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, SIZE);
        }
        return copy;
    }
}
