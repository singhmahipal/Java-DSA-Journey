class Assignment {

    // ===================== Question 1: Merge Sort for Strings =====================

    // Recursively divides the array into smaller parts and then merges them sorted
    public static String[] mergeSort(String[] arr, int lo, int hi) {

        // Base case: if the array has only one element, it's already sorted
        if (lo == hi) {
            String[] A = {arr[lo]};
            return A;
        }

        // Find middle index to divide the array into two halves
        int mid = lo + (hi - lo) / 2;

        // Recursively sort the left half
        String[] arr1 = mergeSort(arr, lo, mid);

        // Recursively sort the right half
        String[] arr2 = mergeSort(arr, mid + 1, hi);

        // Merge the two sorted halves into one sorted array
        String[] arr3 = merge(arr1, arr2);

        return arr3;
    }

    // Merges two already sorted arrays into a single sorted array
    static String[] merge(String[] arr1, String[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        // New array to store merged result
        String[] arr3 = new String[m + n];

        int i = 0; // pointer for arr1
        int j = 0; // pointer for arr2
        int idx = 0; // pointer for arr3

        // Compare elements from both arrays and insert smaller one into arr3
        while (i < m && j < n) {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[idx++] = arr1[i++];
            } else {
                arr3[idx++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1 (if any)
        while (i < m) {
            arr3[idx++] = arr1[i++];
        }

        // Copy remaining elements of arr2 (if any)
        while (j < n) {
            arr3[idx++] = arr2[j++];
        }

        return arr3;
    }

    // Compares two strings lexicographically (dictionary order)
    static boolean isAlphabeticallySmaller(String str1, String str2) {
        // compareTo returns:
        // negative -> str1 comes before str2
        // zero     -> both are equal
        // positive -> str1 comes after str2
        return str1.compareTo(str2) < 0;
    }


    // ===================== Question 2: Majority Element =====================

    // -------- Brute Force Approach --------
    // Checks each element and counts its occurrences
    // If any element appears more than n/2 times, it's the majority element
    public static int majorityElem(int[] arr) {
        int majorityCount = arr.length / 2;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            // Count how many times arr[i] appears in the array
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // If count exceeds n/2, we found the majority element
            if (count > majorityCount) {
                return arr[i];
            }
        }

        // No majority element found
        return -1;
    }

    // Counts how many times a number 'n' appears in a given range [lo, hi]
    public static int countInRange(int[] arr, int n, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (arr[i] == n) {
                count++;
            }
        }
        return count;
    }

    // -------- Divide & Conquer Approach --------
    // Recursively finds majority element in left and right halves
    public static int majorityElementRec(int[] arr, int lo, int hi) {

        // Base case: single element - it's the majority of this subarray
        if (lo == hi) {
            return arr[lo];
        }

        int mid = lo + (hi - lo) / 2;

        // Find majority element in left half
        int left = majorityElementRec(arr, lo, mid);

        // Find majority element in right half
        int right = majorityElementRec(arr, mid + 1, hi);

        // If both halves agree on the same element, that's the answer
        if (left == right) {
            return left;
        }

        // Otherwise, count occurrences of both candidates in full range
        int leftCount = countInRange(arr, left, lo, hi);
        int rightCount = countInRange(arr, right, lo, hi);

        // Return the element with higher frequency
        return leftCount > rightCount ? left : right;
    }

    // Wrapper function to start recursion
    public static int majorityElement(int[] arr) {
        return majorityElementRec(arr, 0, arr.length - 1);
    }

    // ===================== Question 3: Inversion Count =====================

    // -------- Brute Force Approach --------
    // Time Complexity: O(n^2)
    // Checks every pair (i, j) such that i < j
    // If arr[i] > arr[j], it is an inversion
    public static void inversionCount(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                // If earlier element is greater than later element - inversion
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }


    // -------- Optimized Approach (Modified Merge Sort) --------
    // Time Complexity: O(n log n)
    // Uses divide & conquer to count inversions efficiently

    // Merge function that also counts inversions
    public static int merge(int[] arr, int left, int mid, int right) {

        int inversionCount = 0;

        int i = left;   // pointer for left subarray
        int j = mid;    // pointer for right subarray
        int k = 0;      // pointer for temp array

        int temp[] = new int[right - left + 1];

        // Merge both subarrays while counting inversions
        while (i < mid && j <= right) {

            // If element in left is smaller - no inversion
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // Inversion found
                temp[k++] = arr[j++];

                // All remaining elements in left subarray will form inversions
                inversionCount += (mid - i);
            }
        }

        // Copy remaining elements of left subarray
        while (i < mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back to original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return inversionCount;
    }


    // Recursive merge sort function that returns inversion count
    public static int mergeSort(int[] arr, int left, int right) {

        int inversionCount = 0;

        // Divide array until single element remains
        if (right > left) {

            int mid = (left + right) / 2;

            // Count inversions in left half
            inversionCount += mergeSort(arr, left, mid);

            // Count inversions in right half
            inversionCount += mergeSort(arr, mid + 1, right);

            // Count cross inversions while merging
            inversionCount += merge(arr, left, mid + 1, right);
        }

        return inversionCount;
    }


    // Wrapper function
    public static int getInversions(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {

        // ===================== Question 1 Test =====================
        /*
        String[] arr = {"sun", "earth", "mars", "mercury"};

        // Sort array alphabetically using merge sort
        String[] sorted = mergeSort(arr, 0, arr.length - 1);

        // Print sorted array
        for (String s : sorted) {
            System.out.print(s + " ");
        }
        */

        // ===================== Question 2 Test =====================
        int arr[] = {3, 3, 3, 5, 2, 3, 2};

        // Brute force (O(n^2))
        // System.out.println(majorityElem(arr));

        // Divide & Conquer (O(n log n))
        // System.out.println(majorityElement(arr));

        // ===================== Question 3 Test =====================
        // Brute force (O(n^2))
        int arr1[] = {2,4,1,3,5};
        // inversionCount(arr1);

        // modified merge sort (O(n log n))
        System.out.println(getInversions(arr1));
    }
}
