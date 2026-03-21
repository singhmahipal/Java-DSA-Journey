# 🧠 Topic: Recursion

---

## 📌 Definition

Recursion is a technique where a function calls itself to solve smaller subproblems.

---

## ⚙️ Key Components

1. **Base Case (Stopping Condition)**
   - Prevents infinite recursion
   - Example: n == 0

2. **Recursive Case**
   - Function calls itself with smaller input

---

## 🔁 General Structure

```java
function f(n){
    if(base_condition){
        return;
    }

    // work

    f(n-1); // recursive call
}
