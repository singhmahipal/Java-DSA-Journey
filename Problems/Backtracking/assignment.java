class Assignment {

    // -------------------- Q1: Rat in a Maze --------------------

    // Utility function to print the solution matrix
    public static void printSoln(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if a cell is valid:
    // - inside the grid
    // - and not blocked (value should be 1)
    public static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < maze.length &&
                y >= 0 && y < maze.length &&
                maze[x][y] == 1);
    }

    // Main function that sets up the solution matrix
    public static boolean solveMaze(int maze[][]) {
        int n = maze.length;

        // This will store the path (1 = part of path, 0 = not)
        int sol[][] = new int[n][n];

        // Start from top-left corner (0,0)
        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("solution does not exist");
            return false;
        }

        printSoln(sol);
        return true;
    }

    // Recursive function that tries to find a path
    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {

        // If we've reached the bottom-right cell, we're done
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if current position is valid
        if (isSafe(maze, x, y)) {

            // Avoid revisiting the same cell
            if (sol[x][y] == 1) return false;

            // Mark current cell as part of solution path
            sol[x][y] = 1;

            // Try moving DOWN
            if (solveMazeUtil(maze, x + 1, y, sol)) return true;

            // Try moving RIGHT
            if (solveMazeUtil(maze, x, y + 1, sol)) return true;

            // If neither works, backtrack (unmark this cell)
            sol[x][y] = 0;
            return false;
        }

        return false;
    }


    // -------------------- Q2: Phone Keypad Combinations --------------------

    // Mapping digits to letters (like old mobile keypads)
    final static char[][] L = {
        {}, {},
        {'a', 'b', 'c'},        // 2
        {'d', 'e', 'f'},        // 3
        {'g', 'h', 'i'},        // 4
        {'j', 'k', 'l'},        // 5
        {'m', 'n', 'o'},        // 6
        {'p', 'q', 'r', 's'},   // 7
        {'t', 'u', 'v'},        // 8
        {'w', 'x', 'y', 'z'}    // 9
    };

    // Entry function
    public static void letterCombinations(String D) {
        int len = D.length();

        // Edge case: empty input
        if (len == 0) {
            System.out.println("");
            return;
        }

        // Start recursive generation
        bfs(0, len, new StringBuilder(), D);
    }

    // Recursive function to build combinations
    // (not really BFS, more like DFS/backtracking)
    public static void bfs(int pos, int len, StringBuilder sb, String D) {

        // If we've used all digits, print the combination
        if (pos == len) {
            System.out.println(sb.toString());
        } else {

            // Get letters corresponding to current digit
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];

            // Try each possible letter
            for (int i = 0; i < letters.length; i++) {

                // Append letter and move to next digit
                bfs(pos + 1, len,
                    new StringBuilder(sb).append(letters[i]), D);
            }
        }
    }


    // -------------------- Q3: Knight’s Tour --------------------

    static int N = 8; // Chessboard size

    // Check if the next move is valid
    // - inside board
    // - not already visited
    public static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N &&
                y >= 0 && y < N &&
                sol[x][y] == -1);
    }

    // Print the board with move numbers
    public static void printSol(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main function to solve Knight's Tour
    public static boolean solveKT() {

        int sol[][] = new int[N][N];

        // Initialize all cells as unvisited (-1)
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sol[i][j] = -1;

        // All 8 possible moves of a knight
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Knight starts from (0,0)
        sol[0][0] = 0;

        // Try solving
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("solution does not exist");
            return false;
        } else {
            printSol(sol);
        }

        return true;
    }

    // Recursive backtracking function
    public static boolean solveKTUtil(int x, int y, int movei,
                                      int[][] sol,
                                      int xMove[], int yMove[]) {

        // If all squares are visited, we're done
        if (movei == N * N) return true;

        // Try all possible moves
        for (int k = 0; k < 8; k++) {

            int next_x = x + xMove[k];
            int next_y = y + yMove[k];

            if (isSafe(next_x, next_y, sol)) {

                // Make the move
                sol[next_x][next_y] = movei;

                // Recurse
                if (solveKTUtil(next_x, next_y, movei + 1,
                                sol, xMove, yMove)) {
                    return true;
                }

                // If it fails, undo (backtrack)
                sol[next_x][next_y] = -1;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        /* Rat in a Maze */
        // int maze[][] = {
        //     {1,0,0,0},
        //     {1,1,0,1},
        //     {0,1,0,0},
        //     {1,1,1,1}
        // };
        // solveMaze(maze);

        /* Keypad Combinations */
        letterCombinations("23");

        /* Knight’s Tour */
        // solveKT();
    }
}
