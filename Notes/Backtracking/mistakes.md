# ❌ Mistakes & Struggles - Backtracking

---

## 🚫 Mistake 1: Forgot to Undo Choice

**Problem:** Wrong results / wrong paths  

**Why it happened:**  
Made a choice but didn’t revert it  

**Fix:**  
Always write undo step after recursion  

General:
```
remove() / unmark
```

Grid problems:
```
sol[x][y] = 0;   // maze
sol[x][y] = -1;  // knight tour
```

---

## 🚫 Mistake 2: Wrong Base Case

**Problem:** Missing or extra answers  

**Why it happened:**  
Did not clearly define when solution is complete  

**Fix:**  

Clearly define base cases:

- Subset / permutation → when input exhausted  
- Maze:
```
if (x == n-1 && y == n-1)
```
- Keypad:
```
if (pos == len)
```
- Knight Tour:
```
if (movei == N*N)
```

---

## 🚫 Mistake 3: Index Handling Mistake

**Problem:** Duplicate / missing combinations  

**Fix:**  
- Use `i + 1` → Subsets / combinations  
- Use removal or visited → Permutations  

---

## 🚫 Mistake 4: Confusion Between Recursion & Backtracking

**Problem:** Couldn’t structure solution  

**Why it happened:**  
Did not understand “undo step”  

**Fix:**  
👉 Recursion = go deeper  
👉 Backtracking = go deeper + undo  

---

## 🚫 Mistake 5: Not Visualizing Tree / Grid

**Problem:** Hard to debug  

**Why it happened:**  
Tried to think linearly  

**Fix:**  
Draw:
- Recursion tree (subset, keypad)  
- Grid (maze, knight)  

---

## 🚫 Mistake 6: Subset Problem Mistakes

❌ Forgot include/exclude pattern  
❌ Printed before base case  
❌ Confused empty subset  

**Fix:**  
👉 Always follow:
- include  
- exclude  

---

## 🚫 Mistake 7: Permutation Problem Mistakes

❌ Forgot to remove used character  
❌ Wrong substring logic  
❌ Duplicate permutations  

**Fix:**  
👉 Remove current character before recursion  
👉 Use:
```
str.substring(0,i) + str.substring(i+1)
```

---

## 🚫 Mistake 8: N-Queen Problem Mistakes

❌ Didn’t check diagonals  
❌ Forgot to remove queen (backtrack)  
❌ Checked full board instead of above rows  

**Fix:**  
👉 Only check:
- vertical up  
- left diagonal  
- right diagonal  

👉 Always:
- place → recurse → remove  

---

## 🚫 Mistake 9: Grid Ways Bug (IMPORTANT)

**Problem:** Wrong number of paths  

**Why it happened:**  
Wrong boundary condition  

❌ Wrong:
```
j == row
```

✅ Correct:
```
j == col
```

---

## 🚫 Mistake 10: Sudoku Backtracking Errors

❌ Didn’t reset cell  
❌ Wrong 3x3 grid calculation  
❌ Tried invalid digits repeatedly  

**Fix:**  

👉 Always reset:
```
sudoku[row][col] = 0;
```

👉 Correct subgrid:
```
sr = (row/3)*3
sc = (col/3)*3
```

---

## 🚫 Mistake 11: Mutable State Confusion

**Problem:** Values changing unexpectedly  

**Why it happened:**  
Same array/board reused across recursion  

**Fix:**  
👉 Always undo changes before returning  

---

## 🚫 Mistake 12: Infinite Recursion

**Problem:** Stack overflow  

**Why it happened:**  
- Missing base case  
- Wrong recursive movement  

**Fix:**  
👉 Ensure progress toward base case every call  

---

## 🚫 Mistake 13: Not Marking Visited (Grid Problems)

**Problem:** Infinite loops / revisiting same cell  

**Where it happened:**  
Maze, Knight Tour  

**Fix:**  
Mark before recursion:
```
sol[x][y] = 1;
```

Undo later

---

## 🚫 Mistake 14: Direction Handling Mistake (Maze)

❌ Tried only one direction  
❌ Missed valid paths  

**Fix:**  
Always try:
- Down → `(x+1, y)`  
- Right → `(x, y+1)`  

---

## 🚫 Mistake 15: String Handling Mistake (Keypad)

❌ Same string reused  
❌ Output overwritten  

**Fix:**  
```
new StringBuilder(sb).append(letter)
```

---

## 🚫 Mistake 16: Digit Mapping Mistake (Keypad)

❌ Wrong index access  

**Fix:**  
```
Character.getNumericValue(D.charAt(pos))
```

---

## 🚫 Mistake 17: Safe Function Errors

**Problem:** Out of bounds / invalid moves  

**Fix:**  
```
x >= 0 && x < n
y >= 0 && y < n
```

Plus:
- Maze → `maze[x][y] == 1`  
- Knight → `sol[x][y] == -1`  

---

## 🚫 Mistake 18: Knight Move Logic Confusion

❌ Missing moves  

**Fix:**  
Use all 8 moves:
```
{2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}
```

---

## 🚫 Mistake 19: Printing Too Early

**Problem:** Incomplete output  

**Fix:**  
Print only at base case  

---

# 🧠 Debugging Checklist

Before coding:
- ✅ Base case defined?
- ✅ Choices clear?
- ✅ Backtracking step present?

During debugging:
- 🔍 Print recursion calls
- 🔍 Track array/board changes
- 🔍 Check undo step

---

# 🔥 Pro Tips

- Always visualize recursion tree  
- Use small inputs to debug  
- Dry run manually  
- Think in patterns (grid / tree / permutation)  

---

# ⚡ Golden Rule

👉 **"Every change you make must be undone"**

---

## 📉 Current Weak Areas

- ❌ Choosing correct pattern  
- ❌ Handling duplicates  
- ❌ Visualizing recursion  

---

## 🔄 Improvement Plan

✔ Solve 2–3 problems daily  
✔ Classify problem type first  
✔ Draw recursion tree / grid  
✔ Practice dry run  

---

## 🧠 Reality Check

👉 If stuck → Pattern not clear  
👉 If confused → Didn’t visualize  
👉 If wrong output → Undo step missing  

---
