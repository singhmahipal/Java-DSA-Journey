
public class assignment {

    // prob 1
    public static void printIdx(int arr[], int i, int key) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        printIdx(arr, i + 1, key);
    }

    // prob 2
    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void printDigits(int n) {
        if (n == 0) {
            return;
        }

        int lastDigit = n % 10;
        printDigits(n / 10);
        System.out.print(digits[lastDigit] + " ");
    }

    // prob 3
    public static int countLength(String str) {
        if (str.length() == 0) {
            return 0;
        }

        return countLength(str.substring(1)) + 1;
    }

    // prob 4
    public static int countSubString(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }

        if (n <= 0) {
            return 0;
        }

        int res = countSubString(str, i + 1, j, n - 1) + countSubString(str, i, j - 1, n - 1) - countSubString(str, i + 1, j - 1, n - 2);

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;
    }

    // prob 5
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);

        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        //    int arr[] = {3,2,4,5,6,2,7,2,2};

        //    printIdx(arr, 0, 2);
        // printDigits(15102340);
        // System.out.println(countLength("smodcxmadrqqwertxtr"));
        // String str = "abab";
        // int n=str.length();
        // System.out.println(countSubString(str, 0, n-1, n));

        int n = 3;
        towerOfHanoi(n, "A", "B", "C");
    }

}
