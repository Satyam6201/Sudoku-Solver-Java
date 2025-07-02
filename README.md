# 🧩 Sudoku Solver & Puzzle Generator (Java Console App)

This is a fully functional **Sudoku game** written in Java. It includes a **random puzzle generator**, a **solver using backtracking**, **difficulty levels**, **smart hint system**, **lives system**, **move counter**, **timer**, and the ability to **save/load your progress** — all from the **command line interface**.

Built as a modular, object-oriented Java project, this console-based app showcases problem-solving, algorithmic logic, and clean code structure.

---

## 🚀 Features

- 🔢 **Puzzle Generator** with difficulty levels: Easy (40 clues), Medium (30), Hard (22)
- 🧠 **Recursive Backtracking Solver** to solve any valid board
- 💡 **Hint System** that auto-solves a copy and reveals one correct cell
- 💾 **Save & Load Game** progress to/from a `.txt` file
- ❤️ **Lives System** (Max 3 wrong attempts)
- ⏱️ **Timer** to measure how long you take to solve the puzzle
- 🧮 **Move Counter** for tracking total inputs
- ✅ **Input Validation**: Prevent overwriting fixed cells or invalid moves
- 📊 **Board Validity Check** and **Unique Solution Detector**
- 🔁 Cleanly restartable from console after exit or completion

---

## 🎮 How to Play

1. 🖥️ Run the app in the terminal using:
   ```
   javac src/*.java
   java -cp src Main
   🎯 Select a difficulty level (Easy, Medium, Hard)

   🕹️ Use the menu options:

   1: Fill a cell (row, column, number)

   2: Get a smart hint

   3: Auto-solve the puzzle

   4: Save game

   5: Load a saved game

   6: Exit
  
```
✔️ Complete the board to win, or use the solver to finish instantly.
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
 ---------------------
🧩 Technologies Used
   
 * ✅ Java (JDK 8+)
 * ✅ Console I/O
 * ✅ 2D Arrays
 * ✅ Backtracking & Recursion
 * ✅ File Handling
   
 ---
📌 To-Do (Optional Improvements)
   
 * 🖼️ Swing-based GUI (Graphical Interface)
 * 📈 Difficulty-level algorithm improvements
 * 🌐 Multiplayer or network-based Sudoku
 * 📱 Android version using Java
 ---
👨‍💻 Author
 * Name: Satyam Kumar Mishra
 * LinkedIn: https://www.linkedin.com/in/satyam-kumar-mishra-9bb980291/
 * GitHub: https://github.com/Satyam6201
