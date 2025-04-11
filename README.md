## Minesweeper

This project is a console-based implementation of the classic **Minesweeper** game developed in Java. It was created as part of a Java programming course to practice several fundamental concepts, including:

- Object-Oriented Programming (OOP)
- Exception handling
- Java Streams & Collections
- Recursion
- Unit testing with JUnit
- Package organization
- Console I/O interaction

### How the game works

The player is presented with a grid of tiles. Some tiles are "mined" and others are safe. The goal is to uncover all safe tiles without triggering a mine. The game supports flagging suspected tiles, and recursively opens safe neighbours if no mines are nearby.

**Gameplay features:**
- Recursively open safe tiles
- Mine explosion triggers game over
- Flag tiles to mark suspected mines
- Detect victory when all non-mined tiles are revealed
- Custom exceptions to control game flow (e.g. `ExplosionException`, `ExitException`)

### Technologies Used
- Java 17+ (compatible with Java 21)
- IntelliJ IDEA (recommended)
- JUnit 5 for testing (JUnit Jupiter)

### How to run

#### 1. Clone the repository:
```bash
git clone https://github.com/gianverdum/minesweeper.git
cd minesweeper
```

#### 2. Open the project in IntelliJ
- File > Open > Select the project root
- Wait for indexing

#### 3. Run the game
- Locate the `App.java` file
- Right click > Run `App.main()`

#### 4. Controls (in terminal)
- Input coordinates as: `x,y`
- Choose action: `1` to open, `2` to flag
- Type `exit` at any prompt to end the game

### How to run tests
- Navigate to `TileTest.java`
- Run all tests or individual ones using the green ▶️ icons

### Folder structure
```bash
src/
├── com.github.gv.ms
│   ├── exception        # Custom exceptions (Explosion, Exit)
│   ├── model            # Domain logic (Board, Tile)
│   └── view             # Console UI (BoardConsole, App)
test/
└── com.github.gv.ms.model
    └── TileTest.java    # Unit tests for Tile behavior
```

### Author
This project was developed by Giancarlo Verdum as a Java course exercise to reinforce core programming skills.
