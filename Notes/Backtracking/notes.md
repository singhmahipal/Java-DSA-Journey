# 🧠 Topic: Backtracking

---

## 📌 Definition

Backtracking is an algorithmic technique used to solve problems by trying all possible solutions and undoing choices (backtracking) when a solution path fails.

👉 It is an extension of recursion where we explore **choices + revert them**.

---

## ⚙️ Key Idea

👉 **Try → Explore → Undo (Backtrack)**

- Make a choice  
- Recurse to explore further  
- If it fails, undo the choice  

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
- Yes / No choices  
- Example: Subsets

---

### 2️⃣ Permutation Based
- Arrange elements in all possible ways  
- Example: Permutations of array

---

### 3️⃣ Combination Based
- Select elements without caring about order  
- Example: Combination Sum

---

### 4️⃣ Constraint Based
- Follow rules / constraints  
- Example: N-Queens, Sudoku

---

## 📦 Backtracking in Arrays

### ✔ Use Cases
- Generating subsets  
- Finding permutations  
- Combination problems  

---

### 💡 Example: Subsets

```java
void backtrack(int[] nums, int index, List<Integer> current){
    result.add(new ArrayList<>(current));

    for(int i = index; i < nums.length; i++){
        current.add(nums[i]);              // choose
        backtrack(nums, i + 1, current);  // explore
        current.remove(current.size()-1); // undo
    }
}
```

---

## 🧠 Mental Model

👉 Think like this:

- “At every step, I have choices”  
- “I will try each choice”  
- “If it fails, I go back”  

---
