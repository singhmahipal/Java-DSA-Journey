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

```java
i *= 2 or i /= 2 → O(log n)
```

---

## 🚫 Mistake 6: Ignoring Space Complexity

**Problem:** Only focused on time

**Why it happened:**
Forgot memory usage

**Fix:**
Check variables, recursion stack, extra arrays

---

# 🔍 NEW TOPIC MISTAKES

---

## 🚫 Mistake 7: Bubble Sort Best Case Misunderstanding

**Problem:** Assuming always O(n²)

**Why it happened:**
Ignored optimized version with swap flag

**Fix:**

* Best case → O(n) (if no swaps)
* Always check if optimization exists

---

## 🚫 Mistake 8: Binary Search on Unsorted Array

**Problem:** Applying binary search incorrectly

**Why it happened:**
Forgot pre-condition

**Fix:**
👉 Binary Search works **only on sorted arrays**

---

## 🚫 Mistake 9: Wrong Mid Calculation

**Problem:** Overflow or incorrect mid

**Why it happened:**
Used:

```java
int mid = (low + high) / 2;
```

**Fix:**

```java
int mid = low + (high - low) / 2;
```

---

## 🚫 Mistake 10: Misunderstanding Recursion Space

**Problem:** Ignoring recursion stack

**Why it happened:**
Only focused on function logic

**Fix:**
👉 Recursive calls use stack → adds space complexity

Example:

* Recursion depth = n → Space = O(n)

---

## 🚫 Mistake 11: Fibonacci Complexity Underestimation

**Problem:** Thinking it's O(n)

**Why it happened:**
Ignored repeated calls

**Fix:**
👉 Naive recursion = O(2ⁿ)
👉 Use DP / memoization → O(n)

---

## 🚫 Mistake 12: Merge Sort Space Ignored

**Problem:** Assuming O(1) space

**Why it happened:**
Focused only on divide & conquer

**Fix:**
👉 Merge Sort uses extra array → O(n) space

---

## 🚫 Mistake 13: Not Understanding Recurrence Relations

**Problem:** Couldn't derive complexity

**Why it happened:**
Skipped recurrence step

**Fix:**

* Write recurrence first
* Then solve using Master Theorem

Example:

```text
T(n) = 2T(n/2) + n → O(n log n)
```

---

## 🚫 Mistake 14: Power Function Inefficiency

**Problem:** Using naive recursion

**Why it happened:**
Did not know optimization

**Fix:**

* Naive → O(n)
* Fast Power → O(log n)

---

## 🚫 Mistake 15: Missing Even/Odd Case in Fast Power

**Problem:** Wrong result

**Why it happened:**
Did not handle odd exponent

**Fix:**

```java
if(n % 2 == 0) return half * half;
else return x * half * half;
```

---

## 🚫 Mistake 16: Confusing Divide & Conquer Complexity

**Problem:** Assuming all recursion is O(n)

**Why it happened:**
Did not track number of subproblems

**Fix:**
👉 Check:

* Number of calls
* Work per call

---

## 🚫 Mistake 17: Not Practicing Dry Runs

**Problem:** Logical errors

**Why it happened:**
Jumped to coding

**Fix:**
👉 Always dry run with small inputs

---

## 🚫 Mistake 18: Ignoring Edge Cases in Analysis

**Problem:** Wrong conclusions

**Why it happened:**
Only tested normal cases

**Fix:**
Check:

* Empty input
* Single element
* Large input

---

## 🚫 Mistake 19: Assuming Faster Code = Better Complexity

**Problem:** Micro-optimizing

**Why it happened:**
Focused on constants

**Fix:**
👉 Big O ignores constants — focus on growth

---

## 🚫 Mistake 20: Not Connecting Pattern to Complexity

**Problem:** Slow problem solving

**Why it happened:**
Memorized instead of understanding

**Fix:**
Recognize patterns:

* Halving → O(log n)
* Nested loops → O(n²)
* Divide & conquer → O(n log n)
* Tree recursion → O(2ⁿ)

---

## 🧠 Reality Check

👉 If wrong → concept unclear
👉 If slow → need practice
👉 If confused → break problem step-by-step
👉 If stuck → identify pattern first

---
