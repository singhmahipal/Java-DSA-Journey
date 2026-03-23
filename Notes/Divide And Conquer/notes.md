# 🧠 Topic: Divide & Conquer (Quick Sort & Merge Sort)

---

## 📌 Definition

Divide & Conquer is an algorithmic paradigm where a problem is solved by:
1. Breaking it into smaller subproblems  
2. Solving them recursively  
3. Combining their results  

---

## ⚙️ Core Idea

f(n) = f(n/2) + f(n/2) + merge work

---

## 🔁 General Template

    void solve(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        solve(arr, low, mid);
        solve(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

---

## 🔀 MERGE SORT

---

### 💡 Intuition

- Divide array until single elements  
- Merge them in sorted order  

---

### 🔧 Merge Function

    void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }

---

### ⏱ Time Complexity

- Best: O(n log n)  
- Average: O(n log n)  
- Worst: O(n log n)  

---

### 📦 Space Complexity

- O(n)

---

### ✅ Properties

- Stable  
- Good for linked lists  
- Predictable  

---

## ⚡ QUICK SORT

---

### 💡 Intuition

- Pick pivot  
- Place it correctly  
- Left → smaller  
- Right → larger  

---

### 🔧 Partition (Lomuto)

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

---

### 🔁 Quick Sort Function

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

---

### ⏱ Time Complexity

- Best: O(n log n)  
- Average: O(n log n)  
- Worst: O(n²)  

---

### 📦 Space Complexity

- O(log n)

---

### ⚠️ Worst Case

- Already sorted array  
- Bad pivot  

---

### 🚀 Optimizations

- Random pivot  
- Median of three  

---

## ⚖️ Merge vs Quick

| Feature | Merge Sort | Quick Sort |
|--------|------------|-----------|
| Stable | Yes | No |
| Space | O(n) | O(log n) |
| Worst | O(n log n) | O(n²) |
| Speed | Moderate | Fast |

---

## 🧠 Interview Tips

- Write base case first  
- Dry run merge  
- Explain partition clearly  
