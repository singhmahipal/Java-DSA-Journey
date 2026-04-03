# 🧠 Topic: Backtracking

---

## 📌 Definition

Backtracking is an algorithmic technique used to solve problems by trying all possible solutions and undoing choices (backtracking) when a solution path fails.

👉 It is an extension of recursion where we explore **choices + revert them**.

---

## ⚙️ Key Idea

👉 **Try → Explore → Undo (Backtrack)**

* Make a choice
* Recurse to explore further
* If it fails, undo the choice

---

## 🔁 General Structure

```java
function backtrack(state){
    if(solution_found){
        print/store result;
        return;
    }

    for(choice in choices){
        // make choice
        apply(choice);

        // explore
        backtrack(updated_state);

        // undo choice (backtrack)
        remove(choice);
    }
}
```

---

## 🧩 Types of Backtracking

### 1️⃣ Decision Based

* Yes / No choices
* Example: Subsets

---

### 2️⃣ Permutation Based

* Arrange elements in all possible ways
* Example: Permutations

---

### 3️⃣ Combination Based

* Select elements without caring about order
* Example: Combination Sum

---

### 4️⃣ Constraint Based

* Follow rules / constraints
* Example: N-Queens, Sudoku

---

## 📦 Important Problems

---

### 🔹 1. Subset Problem (Power Set)

👉 Generate all possible subsets of a string

```java
void findSubsets(String str, String ans, int i){
    if(i == str.length()){
        if(ans.length() == 0){
            System.out.println("null");
        } else {
            System.out.println(ans);
        }
        return;
    }

    // include current character
    findSubsets(str, ans + str.charAt(i), i + 1);

    // exclude current character
    findSubsets(str, ans, i + 1);
}
```

💡 Pattern: **Include / Exclude (Decision Tree)**
⏱ Time Complexity: `O(2^n)`

---

### 🔹 2. Permutation Problem

👉 Generate all permutations of a string

```java
void findPermutation(String str, String ans){
    if(str.length() == 0){
        System.out.println(ans);
        return;
    }

    for(int i = 0; i < str.length(); i++){
        char curr = str.charAt(i);

        String newStr = str.substring(0, i) + str.substring(i + 1);

        findPermutation(newStr, ans + curr);
    }
}
```

💡 Pattern: **Fix one element, permute rest**
⏱ Time Complexity: `O(n!)`

---

### 🔹 3. N-Queen Problem

👉 Place N queens so that no queen attacks another

```java
boolean isSafe(char[][] board, int row, int col){

    // check vertical up
    for(int i = row - 1; i >= 0; i--){
        if(board[i][col] == 'Q') return false;
    }

    // check left diagonal
    for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
        if(board[i][j] == 'Q') return false;
    }

    // check right diagonal
    for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
        if(board[i][j] == 'Q') return false;
    }

    return true;
}

void nQueen(char[][] board, int row){
    if(row == board.length){
        printBoard(board);
        return;
    }

    for(int col = 0; col < board.length; col++){
        if(isSafe(board, row, col)){
            board[row][col] = 'Q';   // choose
            nQueen(board, row + 1);  // explore
            board[row][col] = '.';   // undo (backtrack)
        }
    }
}
```

💡 Pattern: **Constraint + Backtracking**
⏱ Time Complexity: ~`O(N!)`

---

## 🧠 Mental Model

👉 Think like this:

* “At every step, I have choices”
* “I will try each choice”
* “If it fails, I go back”

---
