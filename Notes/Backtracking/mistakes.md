
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

**Fix:**  
👉 Recursion = go deeper  
👉 Backtracking = go deeper + undo  

---

## 🚫 Mistake 5: Not Visualizing Tree

**Problem:** Hard to debug  

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
👉 Use correct substring split  

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
**Example:**  
Used wrong index movement  

**Fix:**  
- Use `i + 1` for combinations  
- Use visited array for permutations  

---

## 🚫 Mistake 4: Confusion Between Recursion & Backtracking

**Problem:** Couldn’t structure solution  

**Why it happened:**  
Did not understand “undo step”  

**Fix:**  
👉 Recursion = solve smaller problem  
👉 Backtracking = solve + undo  

---

## 🚫 Mistake 5: Not Visualizing Tree

**Problem:** Hard to debug  

**Why it happened:**  
Tried to think linearly  

**Fix:**  
Draw **decision tree / recursion tree**

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
