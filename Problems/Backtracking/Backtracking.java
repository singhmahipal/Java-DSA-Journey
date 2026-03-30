
class Backtracking {

    // This function fills the array using backtracking
    // i -> current index
    // v -> value to be inserted at index i
    public static void btrackArr(int[] arr, int i, int v) {

        // Base case: if we reach the end of the array, print it
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // Step 1: assign the current value to the current index
        arr[i] = v;

        // Step 2: move to the next index with incremented value
        btrackArr(arr, i + 1, v + 1);

        // Step 3 (Backtracking step):
        // After returning from recursion, modify the current index
        // This shows how values change when we "come back" in recursion
        arr[i] = arr[i] - 2;
    }

    // Utility function to print the array
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create an array of size 5 (initially all values are 0)
        int arr[] = new int[5];

        // Start backtracking from index 0 and initial value 1
        btrackArr(arr, 0, 1);

        // Print final state of array after backtracking completes
        printArr(arr);
    }
}
