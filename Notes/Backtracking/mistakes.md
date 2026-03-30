# ❌ Mistakes & Struggles - Backtracking

---

## 🚫 Mistake 1: Forgot to Undo Choice

**Problem:** Wrong results / duplicates  

**Why it happened:**  
I made a choice but didn’t revert it  

**Fix:**  
Always write **remove() after recursive call**

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
