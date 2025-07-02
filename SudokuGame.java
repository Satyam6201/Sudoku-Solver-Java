import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class SudokuGame {
    private int[][] board;
    private final Scanner scanner = new Scanner(System.in);
    private boolean[][] fixedCells = new boolean[9][9];
    private int moves = 0;
    private int lives = 3;

    public void startGame() {
        System.out.println("Choose Difficulty Level: (1) Easy (2) Medium (3) Hard");
        int choice = scanner.nextInt();
        int clues;

        switch (choice) {
            case 1 -> clues = 40;
            case 2 -> clues = 30;
            case 3 -> clues = 22;
            default -> {
                System.out.println("Invalid! Defaulting to Medium.");
                clues = 30;
            }
        }

        board = SudokuGenerator.generatePuzzle(clues);
        markFixedCells();

        long startTime = System.currentTimeMillis();

        while (true) {
            printBoard();
            System.out.println("❤️ Lives: " + lives + "   ✅ Moves: " + moves);
            long currentTime = System.currentTimeMillis();
            System.out.println("⏱ Elapsed: " + (currentTime - startTime) / 1000 + " seconds");

            System.out.println("Options: (1) Fill Cell (2) Hint (3) Solve (4) Save (5) Load (6) Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> fillCell();
                case 2 -> giveHint();
                case 3 -> {
                    SudokuSolver.solve(board);
                    System.out.println("✅ Puzzle Solved!");
                    printBoard();
                    return;
                }
                case 4 -> saveGame();
                case 5 -> {
                    loadGame();
                    markFixedCells();
                }
                case 6 -> {
                    System.out.println("👋 Thanks for playing!");
                    return;
                }
                default -> System.out.println("❌ Invalid Option!");
            }

            if (isComplete()) {
                long endTime = System.currentTimeMillis();
                printBoard();
                System.out.println("🎉 Puzzle Completed!");
                System.out.println("✅ Total Moves: " + moves);
                System.out.println("❤️ Lives Left: " + lives);
                System.out.println("⏱ Time Taken: " + (endTime - startTime) / 1000 + " seconds");
                break;
            }
        }
    }

    private void fillCell() {
        System.out.print("Enter row (0–8): ");
        int row = scanner.nextInt();
        System.out.print("Enter col (0–8): ");
        int col = scanner.nextInt();

        if (row < 0 || row > 8 || col < 0 || col > 8) {
            System.out.println("❌ Invalid cell coordinates!");
            return;
        }

        if (fixedCells[row][col]) {
            System.out.println("❌ You cannot change a fixed cell!");
            return;
        }

        System.out.print("Enter number (1–9): ");
        int num = scanner.nextInt();

        if (num < 1 || num > 9) {
            System.out.println("❌ Invalid number!");
            return;
        }

        if (SudokuSolver.isSafe(board, row, col, num)) {
            board[row][col] = num;
            moves++;
            System.out.println("✅ Move #" + moves);
        } else {
            lives--;
            System.out.println("❌ Wrong move! Lives remaining: " + lives);
            if (lives == 0) {
                System.out.println("💀 Game Over!");
                System.exit(0);
            }
        }
    }

    private void giveHint() {
        int[][] copy = deepCopy(board);
        if (SudokuSolver.solve(copy)) {
            outer:
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = copy[i][j];
                        System.out.println("✅ Hint added at (" + i + "," + j + ")");
                        return;
                    }
                }
            }
        } else {
            System.out.println("❌ No solution found!");
        }
    }

    private void saveGame() {
        try (PrintWriter writer = new PrintWriter("sudoku_save.txt")) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    writer.print(board[i][j] + " ");
            System.out.println("✅ Game saved.");
        } catch (Exception e) {
            System.out.println("❌ Failed to save game.");
        }
    }

    public void loadGame() {
        try (Scanner fileScanner = new Scanner(new File("sudoku_save.txt"))) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    board[i][j] = fileScanner.nextInt();
            System.out.println("✅ Game loaded.");
        } catch (Exception e) {
            System.out.println("❌ Could not load saved game.");
        }
    }

    private boolean isComplete() {
        for (int[] row : board)
            for (int num : row)
                if (num == 0) return false;
        return true;
    }

    private void printBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("+-------+-------+-------+");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+\n");
    }

    private int[][] deepCopy(int[][] original) {
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++)
            System.arraycopy(original[i], 0, copy[i], 0, 9);
        return copy;
    }

    private void markFixedCells() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                fixedCells[i][j] = board[i][j] != 0;
    }
}
