# ❌ Mistakes & Struggles - Time & Space Complexity

---

## 🚫 Mistake 1: Counting Every Operation

**Problem:** Overcomplicated analysis

**Why it happened:**
Tried to count each step exactly

**Fix:**
Focus only on growth rate, ignore constants

---

## 🚫 Mistake 2: Not Dropping Constants

**Problem:** Writing O(2n) or O(n + 5)

**Why it happened:**
Did not simplify expression

**Fix:**
Always reduce:

```java
O(2n + 5) → O(n)
```

---

## 🚫 Mistake 3: Confusing Nested vs Separate Loops

**Problem:** Wrong complexity

**Example:**

```java
for(int i = 0; i < n; i++){}
for(int j = 0; j < n; j++){}
```

**Why it happened:**
Thought it's O(n²)

**Fix:**
Separate loops → O(n + n) = O(n)

---

## 🚫 Mistake 4: Ignoring Worst Case

**Problem:** Incorrect complexity

**Why it happened:**
Focused on best/average case

**Fix:**
Always calculate **worst case (Big O)**

---

## 🚫 Mistake 5: Log Loop Confusion

**Problem:** Couldn't identify O(log n)

**Why it happened:**
Missed multiplication/division pattern

**Fix:**
If variable changes like:

```java
i *= 2 or i /= 2
```

→ Complexity is O(log n)

---

## 🚫 Mistake 6: Ignoring Space Complexity

**Problem:** Only focused on time

**Why it happened:**
Forgot memory usage

**Fix:**
Check extra variables, arrays, recursion stack

---


## 🧠 Reality Check

👉 If wrong → concept not clear
👉 If slow → need practice
👉 If confused → simplify step-by-step
