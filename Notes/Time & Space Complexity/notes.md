# 🧠 Topic: Time & Space Complexity

---

## 📌 Definition

Time Complexity measures how the runtime of an algorithm grows with input size (n).
Space Complexity measures how much extra memory an algorithm uses.

---

## ⚙️ Key Components

1. **Input Size (n)**

   * Represents the size of input

2. **Operations Count**

   * Number of steps executed

3. **Growth Rate**

   * How performance changes as n increases

---

## 🔢 Types of Time Complexity

| Complexity | Name        | Example             |
| ---------- | ----------- | ------------------- |
| O(1)       | Constant    | Array access        |
| O(log n)   | Logarithmic | Binary Search       |
| O(n)       | Linear      | Single loop         |
| O(n log n) | Linear Log  | Merge Sort          |
| O(n²)      | Quadratic   | Nested loops        |
| O(2ⁿ)      | Exponential | Recursion (subsets) |

---

## ⚡ Constant Time - O(1)

Execution time does NOT depend on input size

```java
int x = arr[0];
```

---

## 📈 Big O Notation

* Represents **worst-case scenario**
* Ignore constants and lower terms

Example:

```java
O(2n + 3) → O(n)
```

---

## 📉 Big Omega (Ω) & Theta (Θ)

* **Ω (Omega)** → Best case
* **Θ (Theta)** → Average case
* **O (Big O)** → Worst case

---

## 🔁 Common Complexity Order

```text
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ)
```

---

## 💾 Space Complexity

Memory used by an algorithm

### Types:

1. **Input Space** → Given input
2. **Auxiliary Space** → Extra memory used

Example:

```java
int sum = 0; // O(1)
```

---

## 🔄 Loop Analysis

### 1. Simple Loop → O(n)

```java
for(int i = 0; i < n; i++){
    // O(n)
}
```

---

### 2. Nested Loop → O(n²)

```java
for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
        // O(n²)
    }
}
```

---

### 3. Different Variables → O(n * m)

```java
for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
        // O(n*m)
    }
}
```

---

### 4. Logarithmic Loop → O(log n)

```java
for(int i = 1; i < n; i *= 2){
    // O(log n)
}
```

---

## 💡 Key Ideas / Intuition

* Focus on growth, not exact steps
* Drop constants and smaller terms
* Always consider worst case
* Count loops carefully

---

## ⚠️ Edge Cases

* Empty input → O(1)
* Single element → O(1)
* Very large input → focus on dominant term

---

## 🚀 Notes Summary

* Time = speed, Space = memory
* Big O = worst case
* Nested loops → multiply
* Separate loops → add & take dominant
