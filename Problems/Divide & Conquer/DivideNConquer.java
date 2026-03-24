class DivideNConquer {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // print each number
        }
        System.out.println();
    }

    // MERGE SORT 

    public static void mergeSort(int arr[], int si, int ei) {

        // If there's only one element (or invalid range), it's already sorted
        if (si >= ei) {
            return;
        }

        // Find middle - this is where we split the array
        int mid = si + (ei - si) / 2;

        // First, sort the left half
        mergeSort(arr, si, mid);

        // Then, sort the right half
        mergeSort(arr, mid + 1, ei);

        // Now both halves are sorted - time to merge them
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {

        // Temporary array to store sorted result
        int temp[] = new int[ei - si + 1];

        // i - left half starting point
        int i = si;

        // j - right half starting point
        int j = mid + 1;

        // k - position in temp array
        int k = 0;

        // Compare both halves and pick the smaller one each time
        while (i <= mid && j <= ei) {

            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++]; // take from left
            } else {
                temp[k++] = arr[j++]; // take from right
            }
        }

        // If something is still left in left half, copy it
        // (this happens when right side finishes first)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Same for right half
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Now copy everything back to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // QUICK SORT

    public static void quickSort(int arr[], int si, int ei) {

        // Same base case - nothing to sort
        if (si >= ei) {
            return;
        }

        // Partition the array - returns the correct position of pivot
        int pivotIdx = partition(arr, si, ei);

        // Everything left of pivot should be smaller - sort it
        quickSort(arr, si, pivotIdx - 1);

        // Everything right of pivot should be bigger - sort it
        quickSort(arr, pivotIdx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {

        // Choosing last element as pivot 
        int pivot = arr[ei];

        // i will mark the end of "smaller elements" area
        int i = si - 1;

        for (int j = si; j < ei; j++) {

            // If current element is smaller than pivot
            if (arr[j] <= pivot) {

                i++; // expand the smaller-elements region

                // swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // Now place pivot in its correct position
        i++;

        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        // return pivot index - this is now fixed in sorted array
        return i;
    }

    // Modified Binary Search
    public static int search(int arr[], int tar, int si, int ei) {

        // return -1 as the element didn't exist in the array
        if (si > ei) {
            return -1;
        }

        // Find's the mid Index
        int mid = si + (ei-si)/2;

        if (arr[mid] == tar) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {

            // case 1: tar on left side
            if (arr[si] <= tar && tar <= arr[mid]) {
                
                return search(arr, tar, si, mid-1);
            } 

            //case 2: tar on right side
            else {
                
                return search(arr, tar, mid+1, ei);
            }
        } 
        
        // mid on L2
        else {
            //case 3: tar on right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            }
            //case 4: tar on left
            else {
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {  4, 5,6,7, 0,1,2};

        // mergeSort(arr, 0, arr.length - 1);

        // quickSort(arr, 0, arr.length - 1);
        // printArr(arr);

        int target = 1;
        int tarIdx = search(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}
