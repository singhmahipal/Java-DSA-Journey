# ❌ Mistakes & Struggles - Backtracking

---

## 🚫 Mistake 1: Forgot to Undo Choice

**Problem:** Wrong results / duplicates  

**Why it happened:**  
I made a choice but didn’t revert it  

**Fix:**  
Always write **remove() / undo step after recursion**

---

## 🚫 Mistake 2: Wrong Base Case

**Problem:** Missing or extra answers  

**Why it happened:**  
Did not clearly define when solution is complete  

**Fix:**  
Clearly define:
👉 When to add answer  
👉 When to stop recursion  

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

## 🚫 Mistake 5: Not Visualizing Tree

**Problem:** Hard to debug  

**Why it happened:**  
Tried to think linearly  

**Fix:**  
Draw **recursion tree / decision tree**

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
- If stuck → check base case + undo  

---

# ⚡ Golden Rule

👉 **"Every change you make must be undone"**

---

## 📉 Current Weak Areas

- ❌ Choosing correct pattern (subset / permutation / combination)  
- ❌ Handling duplicates  
- ❌ Writing clean recursive structure  

---

## 🔄 Improvement Plan

✔ Solve 2–3 problems daily  
✔ Classify problem type first  
✔ Always draw recursion tree  
✔ Practice dry run on paper  

---

## 🧠 Reality Check

👉 If stuck → Pattern not clear  
👉 If confused → Didn’t visualize tree  
👉 If wrong output → Undo step missing  

---
