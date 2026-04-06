
class Backtracking {

    /* ================= BACKTRACKING ON ARRAY ================= */

 /*
     * This function demonstrates backtracking using an array.
     * i - current index we are working on
     * v - value to assign at index i
     */
    public static void btrackArr(int[] arr, int i, int v) {

        // BASE CASE:
        // If index reaches end of array, print current configuration
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // STEP 1: Choose
        // Assign value v to current index
        arr[i] = v;

        // STEP 2: Explore
        // Move to next index with incremented value
        btrackArr(arr, i + 1, v + 1);

        // STEP 3: Backtrack (Undo the choice)
        // When recursion returns, modify the value
        // This shows how state changes while coming back
        arr[i] = arr[i] - 2;
    }

    // Utility function to print array
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /* ================= SUBSETS (POWER SET) ================= */

 /*
     * Generates all subsets of a string using recursion.
     * str - original string
     * ans - current subset being built
     * i   - current index in string
     */
    public static void findSubsets(String str, String ans, int i) {

        // BASE CASE: If all characters are processed
        if (i == str.length()) {

            // If subset is empty, print "null"
            if (ans.length() == 0) {
                System.out.println("null");
                return;
            }

            // Otherwise print the subset
            System.out.println(ans);
            return;
        }

        // CHOICE 1: Include current character
        findSubsets(str, ans + str.charAt(i), i + 1);

        // CHOICE 2: Exclude current character
        findSubsets(str, ans, i + 1);
    }


    /* ================= PERMUTATIONS ================= */

 /*
     * Generates all permutations of a string.
     * str - remaining characters
     * ans - current permutation being built
     */
    public static void findPermutation(String str, String ans) {

        // BASE CASE: If string becomes empty, we found one permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Try fixing each character at current position
        for (int i = 0; i < str.length(); i++) {

            // Pick current character
            char curr = str.charAt(i);

            // Remaining string after removing current character
            String newStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            findPermutation(newStr, ans + curr);
        }
    }


    /* ================= N-QUEEN PROBLEM ================= */

 /*
     * Checks whether placing a queen at (row, col) is safe or not.
     * We only check upper rows because lower rows are not filled yet.
     */
    public static boolean isSafe(char[][] board, int row, int col) {

        // Check vertically upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Safe position
        return true;
    }

    /*
     * Solves N-Queen problem using backtracking.
     * row - current row where we are placing a queen
     */
    public static void nQueen(char[][] board, int row) {

        // BASE CASE: All queens placed successfully
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // Try placing queen in each column of current row
        for (int i = 0; i < board.length; i++) {

            // Check if it's safe to place queen
            if (isSafe(board, row, i)) {

                // PLACE queen
                board[row][i] = 'Q';

                // RECURSE for next row
                nQueen(board, row + 1);

                // BACKTRACK: remove queen
                board[row][i] = '.';
            }
        }
    }

    // Prints the chess board
    public static void printBoard(char board[][]) {
        System.out.println("--------N Queen--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    /* ================= COUNT GRID WAYS ================= */
 /*
     * Counts the number of ways to move from top-left (i,j) to
     * bottom-right (row-1,col-1) by only moving right or down.
     *
     * i   - current row
     * j   - current column
     * row - total rows
     * col - total columns
     *
     * BASE CASE:
     * - Reached destination → return 1
     * - Out of bounds → return 0
     *
     * RECURSION:
     * - Move down (i+1, j)
     * - Move right (i, j+1)
     * - Sum of both moves gives total ways
     *
     * FUTURE NOTES:
     * - Can optimize using DP / memoization to avoid recomputation
     * - Useful in grid path and robot movement problems
     */
    public static int gridWays(int i, int j, int row, int col) {
        //base case
        if (i == row - 1 && j == col - 1) {
            return 1;
        } else if (i == row || j == row) {
            return 0;
        }

        int w1 = gridWays(i + 1, j, row, col);
        int w2 = gridWays(i, j + 1, row, col);

        return w1 + w2;
    }


    /* ================= SUDOKU SOLVER ================= */
 /*
     * Solves a 9x9 Sudoku puzzle using backtracking.
     *
     * isSafe(sudoku, row, col, digit):
     * - Checks if placing 'digit' at (row,col) is valid
     * - Ensures row, column, and 3x3 cell constraints
     *
     * sudokuSolver(sudoku, row, col):
     * - Recursive backtracking to fill Sudoku
     * - BASE CASE: row == 9 → entire board solved
     * - NEXT POSITION:
     *     - Move to next column
     *     - If end of row, move to next row, column = 0
     * - If cell already filled → skip
     * - Try digits 1-9:
     *     - If safe → place digit, recurse
     *     - Backtrack if recursion fails
     *
     * FUTURE NOTES:
     * - Useful template for constraint satisfaction problems
     * - Can extend to larger boards or other constraint puzzles
     * - Visualize recursion tree to debug placements
     */
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        //row
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        //col
        for (int j = 0; j <= 8; j++) {
            if (sudoku[j][col] == digit) {
                return false;
            }
        }

        // cell
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int k = sr; k < sr + 3; k++) {
            for (int l = sc; l < sc + 3; l++) {
                if (sudoku[k][l] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        //base case
        if (row == 9) {
            return true;
        }

        //recursion
        int nextRow = row;
        int nextCol = col + 1;

        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println("");
        }
    }


    /* ================= MAIN FUNCTION ================= */
    public static void main(String[] args) {

        /* -------- Backtracking Array -------- */
 /*
        int arr[] = new int[5];
        btrackArr(arr, 0, 1);
        printArr(arr);
         */

 /* -------- Subset Problem -------- */
        // String str = "abc";
        // findSubsets(str, "", 0);

        /* -------- Permutation Problem -------- */
        // findPermutation(str, "");
        /* -------- N-Queen Problem -------- */
        // int n = 2;
        // char board[][] = new char[n][n];
        // // Initialize board with '.'
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board.length; j++) {
        //         board[i][j] = '.';
        //     }
        // }
        // // Start solving from row 0
        // nQueen(board, 0);
        /* -------- Grid Ways -------- */
        // int row = 3;
        // int col = 3;
        // System.out.println(gridWays(0, 0, row, col));
        /* -------- Sudoku -------- */
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("solution possible");
            printSudoku(sudoku);
        } else {
            System.out.println("solution not available");
        }

    }
}
        }
        System.out.println();
    }


    /* ================= SUBSETS (POWER SET) ================= */

    /*
     * Generates all subsets of a string using recursion.
     * str - original string
     * ans - current subset being built
     * i   - current index in string
     */
    public static void findSubsets(String str, String ans, int i) {

        // BASE CASE: If all characters are processed
        if (i == str.length()) {

            // If subset is empty, print "null"
            if (ans.length() == 0) {
                System.out.println("null");
                return;
            }

            // Otherwise print the subset
            System.out.println(ans);
            return;
        }

        // CHOICE 1: Include current character
        findSubsets(str, ans + str.charAt(i), i + 1);

        // CHOICE 2: Exclude current character
        findSubsets(str, ans, i + 1);
    }


    /* ================= PERMUTATIONS ================= */

    /*
     * Generates all permutations of a string.
     * str - remaining characters
     * ans - current permutation being built
     */
    public static void findPermutation(String str, String ans) {

        // BASE CASE: If string becomes empty, we found one permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Try fixing each character at current position
        for (int i = 0; i < str.length(); i++) {

            // Pick current character
            char curr = str.charAt(i);

            // Remaining string after removing current character
            String newStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            findPermutation(newStr, ans + curr);
        }
    }


    /* ================= N-QUEEN PROBLEM ================= */

    /*
     * Checks whether placing a queen at (row, col) is safe or not.
     * We only check upper rows because lower rows are not filled yet.
     */
    public static boolean isSafe(char[][] board, int row, int col) {

        // Check vertically upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Safe position
        return true;
    }

    /*
     * Solves N-Queen problem using backtracking.
     * row - current row where we are placing a queen
     */
    public static void nQueen(char[][] board, int row) {

        // BASE CASE: All queens placed successfully
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // Try placing queen in each column of current row
        for (int i = 0; i < board.length; i++) {

            // Check if it's safe to place queen
            if (isSafe(board, row, i)) {

                // PLACE queen
                board[row][i] = 'Q';

                // RECURSE for next row
                nQueen(board, row + 1);

                // BACKTRACK: remove queen
                board[row][i] = '.';
            }
        }
    }

    // Prints the chess board
    public static void printBoard(char board[][]) {
        System.out.println("--------N Queen--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    /* ================= MAIN FUNCTION ================= */

    public static void main(String[] args) {

        /* -------- Backtracking Array -------- */
        /*
        int arr[] = new int[5];
        btrackArr(arr, 0, 1);
        printArr(arr);
        */

        /* -------- Subset Problem -------- */
        // String str = "abc";
        // findSubsets(str, "", 0);

        /* -------- Permutation Problem -------- */
        // findPermutation(str, "");

        /* -------- N-Queen Problem -------- */
        int n = 2;
        char board[][] = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        // Start solving from row 0
        nQueen(board, 0);
    }
}
