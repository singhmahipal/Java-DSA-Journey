# ❌ Mistakes & Struggles - Divide & Conquer

---

## 🚫 Mistake 1: Missing Base Case

Problem: Infinite recursion  

Why it happened:  
Did not define stopping condition  

Fix:

    if (low >= high) return;

---

## 🚫 Mistake 2: Wrong Mid Calculation

Problem: Incorrect split  

Why it happened:  
Used unsafe formula  

Fix:

    int mid = low + (high - low) / 2;

---

## 🚫 Mistake 3: Merge Logic Errors

Problem: Unsorted output  

Why it happened:  
Wrong pointer handling  

Fix:
- Use two pointers  
- Compare correctly  
- Copy remaining elements  

---

## 🚫 Mistake 4: Forgetting Remaining Elements

Problem: Missing values  

Why it happened:  
Stopped early  

Fix:

    while (left <= mid) { ... }
    while (right <= high) { ... }

---

## 🚫 Mistake 5: Partition Mistakes

Problem: Pivot incorrect  

Why it happened:  
Misunderstood logic  

Fix:
- Track index `i`  
- Swap correctly  
- Place pivot at correct position  

---

## 🚫 Mistake 6: Not Reducing Range

Problem: Infinite recursion  

Why it happened:  
Same indices reused  

Fix:

    quickSort(arr, low, pIndex - 1);
    quickSort(arr, pIndex + 1, high);

---

## 🚫 Mistake 7: Ignoring Worst Case

Problem: Slow execution  

Why it happened:  
Bad pivot selection  

Fix:
- Random pivot  
- Shuffle array  

---

## 🚫 Mistake 8: Cannot Trace Recursion

Problem: Confusion  

Why it happened:  
No visualization  

Fix:
- Draw recursion tree  
- Dry run step-by-step  

---

## 📉 Weak Areas

- Merge confusion  
- Partition logic  
- Recursion tracing  

---

## 🔄 Improvement Plan

✔ Practice daily  
✔ Dry run on paper  
✔ Re-implement from scratch  

---

## 🧠 Reality Check

👉 If stuck → lack of practice  
👉 If wrong → logic gap  
👉 If slow → need repetition  
