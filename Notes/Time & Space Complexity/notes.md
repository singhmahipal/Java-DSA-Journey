# 🧠 Topic: Time & Space Complexity (Complete Notes)

---

## 📌 Definition
Time Complexity measures how the runtime of an algorithm grows with input size (n). Space Complexity measures how much extra memory an algorithm uses.

* **Time Complexity** → Measures how runtime grows with input size (**n**)
* **Space Complexity** → Measures how much extra memory an algorithm uses

---

## ⚙️ Key Components

1. **Input Size (n)**

   * Represents number of elements

2. **Operations Count**

   * Number of basic steps executed

3. **Growth Rate**

   * How runtime increases as n grows

---

## 🔢 Types of Time Complexity

| Complexity | Name        | Example           |
| ---------- | ----------- | ----------------- |
| O(1)       | Constant    | Array access      |
| O(log n)   | Logarithmic | Binary Search     |
| O(n)       | Linear      | Loop              |
| O(n log n) | Linear Log  | Merge Sort        |
| O(n²)      | Quadratic   | Bubble Sort       |
| O(2ⁿ)      | Exponential | Subsets recursion |

---

## ⚡ Constant Time - O(1)

Execution does NOT depend on input size

```java
int x = arr[0];
```

---

## 📈 Big O Notation

* Represents **Worst Case**
* Ignore constants and lower terms

```java
O(2n + 3) → O(n)
```

---

## 📉 Big Omega (Ω) & Theta (Θ)

| Notation  | Meaning      |
| --------- | ------------ |
| Ω (Omega) | Best Case    |
| Θ (Theta) | Average Case |
| O (Big O) | Worst Case   |

---

## 🔁 Complexity Order (Fast → Slow)

```text
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ)
```

---

# 🔍 Algorithm Analysis (NEW TOPICS)

---

## 🔵 Bubble Sort Analysis

### Code

```java
for(int i = 0; i < n-1; i++){
    for(int j = 0; j < n-i-1; j++){
        if(arr[j] > arr[j+1]){
            swap(arr[j], arr[j+1]);
        }
    }
}
```

### Complexity

* Best Case → O(n)
* Average Case → O(n²)
* Worst Case → O(n²)
* Space → O(1)

### Insight

* Repeated swapping
* Inefficient for large data

---

## 🔎 Binary Search Analysis

### Code

```java
int binarySearch(int[] arr, int target){
    int left = 0, right = arr.length - 1;

    while(left <= right){
        int mid = (left + right) / 2;

        if(arr[mid] == target) return mid;
        else if(arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

### Complexity

* Best → O(1)
* Average → O(log n)
* Worst → O(log n)
* Space → O(1)

### Insight

* Divide problem in half each step

---

## 🔁 Recursive Complexity Analysis

### Example

```java
void fun(int n){
    if(n == 0) return;
    fun(n-1);
}
```

### Complexity

* Time → O(n)
* Space → O(n) (call stack)

---

## ➕ Sum of N Numbers (Recursion)

```java
int sum(int n){
    if(n == 0) return 0;
    return n + sum(n-1);
}
```

* Time → O(n)
* Space → O(n)

---

## 🌿 Fibonacci Analysis

```java
int fib(int n){
    if(n <= 1) return n;
    return fib(n-1) + fib(n-2);
}
```

### Complexity

* Time → O(2ⁿ)
* Space → O(n)

### Insight

* Overlapping subproblems
* Can optimize using DP → O(n)

---

## 🔀 Merge Sort Analysis

### Code

```java
void mergeSort(int[] arr, int left, int right){
    if(left >= right) return;

    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid+1, right);
    merge(arr, left, mid, right);
}
```

### Complexity

* Time → O(n log n)
* Space → O(n)

---

## 🔁 Recurrence Relation (Merge Sort)

```text
T(n) = 2T(n/2) + O(n)
```

### Solving

* Using Master Theorem:

```text
T(n) = O(n log n)
```

---

## ⚡ Power Function I (Naive)

```java
int power(int x, int n){
    if(n == 0) return 1;
    return x * power(x, n-1);
}
```

* Time → O(n)
* Space → O(n)

---

## ⚡ Power Function II (Optimized)

```java
int power(int x, int n){
    if(n == 0) return 1;

    int half = power(x, n/2);

    if(n % 2 == 0)
        return half * half;
    else
        return x * half * half;
}
```

* Time → O(log n)
* Space → O(log n)

---

## ⚡ Power Function III (Iterative Fast Power)

```java
int power(int x, int n){
    int result = 1;

    while(n > 0){
        if(n % 2 == 1)
            result *= x;

        x *= x;
        n /= 2;
    }
    return result;
}
```

* Time → O(log n)
* Space → O(1)

---

## 🧠 How to Approach Coding Questions

### Step-by-Step Strategy

1. **Understand Problem**

   * Inputs / Outputs / Constraints

2. **Brute Force First**

   * Simple but slow solution

3. **Optimize**

   * Reduce loops
   * Use better data structures

4. **Analyze Complexity**

   * Time + Space

5. **Dry Run**

   * Test with small cases

---

## 💾 Space Complexity

### Types

1. **Input Space**
2. **Auxiliary Space**

```java
int sum = 0; // O(1)
```

---

## 🔄 Loop Analysis

### 1. Simple Loop → O(n)

```java
for(int i = 0; i < n; i++){}
```

### 2. Nested Loop → O(n²)

```java
for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){}
}
```

### 3. Different Variables → O(n * m)

```java
for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){}
}
```

### 4. Log Loop → O(log n)

```java
for(int i = 1; i < n; i *= 2){}
```

---

## 💡 Key Intuition

* Focus on **growth**, not exact steps
* Drop constants
* Multiply nested loops
* Divide → log complexity
* Recursion → build recurrence

---

## ⚠️ Edge Cases

* Empty input → O(1)
* Single element → O(1)
* Large input → dominant term matters

---

## 🚀 Final Summary (Quick Revision)

```text
• Time = Speed, Space = Memory
• Big O = Worst Case
• Nested loops → Multiply
• Sequential loops → Add → Take dominant
• Binary Search → O(log n)
• Merge Sort → O(n log n)
• Fibonacci (naive) → O(2ⁿ)
• Fast Power → O(log n)
• Recursion → Check stack space
```

---
