# NQueens 

Simple solution for the [n-queens problem](https://en.wikipedia.org/wiki/Eight_queens_puzzle) in Java using recursive backtracking. The program takes in a single numeric argument 'n' - this is the size of the chess board (n x n) and the number of queens that are being placed on the chess board. All possible configurations of queen placement are found and printed out.

# Usage
```bash
java -jar nqueens-0.1.0.jar <n>
```

# Example
```bash
~/shivan/NQueens (master) $ java -jar nqueens-0.1.0.jar 4
| |Q| | |
| | | |Q|
|Q| | | |
| | |Q| |

| | |Q| |
|Q| | | |
| | | |Q|
| |Q| | |

There are 2 solutions to 4-queens problem
```

# Building
This project uses Gradle. 
```bash
./gradlew build
```

The `.jar` file is generated in `build/libs/`.

# Tests
```bash
./gradlew test
```

# Documentation
[JavaDocs.](http://shivankaul.com/NQueens)
