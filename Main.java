import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SudokuGame game = new SudokuGame();

        while (true) {
            System.out.println("\n===== Sudoku Launcher =====");
            System.out.println("1. Start New Game");
            System.out.println("2. Load Saved Game");
            System.out.println("3. Launch GUI Version (Coming Soon)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> game.startGame();
                case 2 -> {
                    game.loadGame();
                    game.startGame(); // continue game after loading
                }
                case 3 -> {
                    System.out.println("🖼️ GUI version not implemented yet.");
                    // Future: new SudokuGUI().launch();
                }
                case 4 -> {
                    System.out.println("👋 Thanks for playing Sudoku!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
}
