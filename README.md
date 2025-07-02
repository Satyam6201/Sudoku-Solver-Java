# 🧩 Sudoku Solver & Puzzle Generator (Java Console App)

This is a fully functional **Sudoku game** written in Java. It includes a puzzle generator, solver using backtracking, difficulty levels, hint system, lives, timer, and the ability to save/load your progress — all from the console!

---

## 🚀 Features

- 🔢 Puzzle Generator with difficulty levels (Easy, Medium, Hard)
- 🧠 Sudoku Solver using recursive backtracking
- 🎯 Hint system with smart suggestion
- 💾 Save and Load your game
- ❤️ Lives system (max 3 wrong attempts)
- 🧮 Move counter and timer
- ✅ Input validation for fixed cells
- 📊 Board validity and unique solution detection

---

## 🎮 How to Play

1. Run the program in terminal
2. Select a difficulty level
3. Choose actions:
   - Fill a cell
   - Get a hint
   - Solve the puzzle
   - Save/Load your progress
   - Exit anytime

---

## 📂 Folder Structure

```
Sudoku-Solver-Java/
├── src/
│ ├── Main.java // Entry point
│ ├── SudokuGame.java // Game logic & menu
│ ├── SudokuSolver.java // Backtracking solver
│ ├── SudokuGenerator.java // Puzzle generator
├── sudoku_save.txt // Generated file when game is saved
├── README.md

```
```
+-------+-------+-------+
| 3 . . | . . . | . 5 . |
| . . . | 5 . . | 7 . . |
| 5 . 7 | 4 . 2 | 6 1 . |
+-------+-------+-------+
| . . 4 | 2 1 9 | 3 8 6 |
| . 3 . | . . . | 1 7 . |
| . . . | 3 7 5 | 9 4 . |
+-------+-------+-------+
| 6 7 8 | . . 3 | . 2 . |
| 1 . . | 9 4 8 | 5 6 . |
| 9 . 5 | . . 6 | . . 1 |
+-------+-------+-------+
```
/*
 ---------------------
 * 🧩 Technologies Used
   
 * ✅ Java (JDK 8+)
 * ✅ Console I/O
 * ✅ 2D Arrays
 * ✅ Backtracking & Recursion
 * ✅ File Handling
   
 ---
 * 📌 To-Do (Optional Improvements)
   
 * 🖼️ Swing-based GUI (Graphical Interface)
 * 📈 Difficulty-level algorithm improvements
 * 🌐 Multiplayer or network-based Sudoku
 * 📱 Android version using Java
 
 * 👨‍💻 Author
 * Name: Satyam Kumar Mishra
 * LinkedIn: https://www.linkedin.com/in/satyam-kumar-mishra-9bb980291/
 * GitHub: https://github.com/Satyam6201
