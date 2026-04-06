# Backtracking Notes

## 🚀 What is Backtracking?
Backtracking is a problem-solving technique where we:
- Try a solution
- Move forward recursively
- If it fails → undo (backtrack) and try another path

### 🔍 Intuition
Think of it like:
- Solving a maze 🧩
- If a path is blocked → go back and try another

### 🔁 Relation with Recursion
- Recursion explores possibilities
- Backtracking controls and reverses choices

---

## 🧠 Core Pattern

### 🔄 Template
```
choose
recurse
undo (backtrack)
```

### 💡 Explanation
- **Choose** → Make a decision
- **Explore** → Recurse deeper
- **Un-choose** → Undo decision (IMPORTANT)

---

## 🔁 Dry Run (Subset "ab")

```
                ""
             /      \
           "a"      ""
          /   \     /  \
       "ab"  "a"  "b"  ""
```

Output:
```
ab
a
b
null
```

---

# 📚 Problems Covered

---

## 1. Backtracking on Array

### 🔍 Problem
Fill an array with values and show how values change during backtracking.

### 💡 Intuition
We modify array while going forward and revert while coming back.

### ⚙️ Approach
- Assign value
- Recurse
- Subtract value (undo)

### 🔁 Backtracking Flow
```
arr[i] = v        (choose)
recurse
arr[i] -= 2       (undo)
```

### ⏱ Complexity
- Time: O(n)
- Space: O(n recursion)

### 🧠 Key Insight
Backtracking = modifying SAME structure and undoing it.

---

## 2. Subsets (Power Set)

### 🔍 Problem
Generate all subsets of a string.

### 💡 Intuition
Each character has 2 choices:
- Include
- Exclude

### ⚙️ Approach
- Include char → recurse
- Exclude char → recurse

### 🔁 Flow
```
include → recurse
exclude → recurse
```

### ⏱ Complexity
- Time: O(2^n)
- Space: O(n)

### 🧠 Key Insight
Every element doubles possibilities.

---

## 3. Permutations

### 🔍 Problem
Generate all possible arrangements.

### 💡 Intuition
Fix one character, permute remaining.

### ⚙️ Approach
- Pick a character
- Remove it
- Recurse

### ⏱ Complexity
- Time: O(n!)
- Space: O(n)

### 🧠 Key Insight
Permutation = fixing position one by one.

---

## 4. N-Queens

### 🔍 Problem
Place N queens so no one attacks another.

### 💡 Intuition
Try placing queen row by row safely.

### ⚙️ Approach
- Try each column
- Check safety
- Place → recurse → remove

### 🔁 Flow
```
if safe:
   place
   recurse
   remove
```

### ⏱ Complexity
- Time: ~O(N!)
- Space: O(N)

### 🧠 Key Insight
Prune invalid positions early.

---

## 5. Grid Ways

### 🔍 Problem
Count ways from (0,0) to (n-1,m-1)

### 💡 Intuition
Only 2 moves:
- Right
- Down

### ⚙️ Approach
```
ways(i,j) = down + right
```

### ⏱ Complexity
- Time: O(2^(n+m))
- Space: O(n+m)

### 🧠 Key Insight
This is recursion + overlapping (can optimize using DP).

---

## 6. Sudoku Solver

### 🔍 Problem
Fill grid following rules.

### 💡 Intuition
Try digits 1–9 and backtrack if invalid.

### ⚙️ Approach
- Find empty cell
- Try digit
- Check safe
- Recurse
- Undo if fails

### 🔁 Flow
```
place digit
recurse
if fail → remove digit
```

### ⏱ Complexity
- Very high (worst exponential)

### 🧠 Key Insight
Constraint checking = pruning.

---

## 🧩 When to Use Backtracking
Use when:
- "Find all ways"
- "All combinations"
- "All permutations"
- Constraint satisfaction problems

---

## ⚡ Optimization Ideas
- Pruning (stop early)
- Avoid unnecessary recursion
- Use memoization (if overlapping)

---

## 🎯 Interview Tips
- Always explain:
  - Choices
  - Base case
  - Backtracking step
- Draw recursion tree
- Start brute-force → optimize
