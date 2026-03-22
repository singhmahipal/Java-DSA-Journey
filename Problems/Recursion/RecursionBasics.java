class recursionBasics {
    //problem 1
    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(1+" ");
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    //problem 2
    public static void printInc(int n) {
        if (n==1) {
            System.out.print(n+" ");
            return;
        }

        printInc(n-1);
        System.out.print(n+" ");
    }

    //problem 3
    public static int printFact(int n) {
        int fact = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        return fact = n * printFact(n-1);
    }

    //problem 4
    public static int printSum(int n) {
        int sum = 0;
        if (n == 1) {
            return 1;
        }

        return sum = n+printSum(n-1);
    }

    //problem 5
    public static int fibo(int n) {
        if (n==0 || n==1) {
            return n;
        }

        int f1 = fibo(n-1);
        int f2 = fibo(n-2);

        return f1+f2;
    }

    //problem 6
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length-1) {
            return true;
        }

        if (arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    //problem 7
    public static int find1stOcc(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return find1stOcc(arr, i+1, key);
    }

    //problem 8    
    public static int findLastOcc(int arr[], int i, int key) {
        if (i == 0) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return findLastOcc(arr, i-1, key);
    }

    // prob 8-alternative
    public static int findLastOcc2(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = findLastOcc2(arr, i+1, key);

        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    //problem 9
    public static int pow(int x, int n) {
        if (n==0) return 1;

        return x * pow(x, n-1);
    }

    //problem 9 - optimised approach
    public static int pow2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPow = pow2(x, n/2);

        // if half is assign pow2(x, n/2) * pow2(x, n/2) then time complexity will be O(n) but we want an optimised approach t/f we create a new var halfpow and assign it result of pow2(x, n/2) then do sqaure of it & assign it to another new var halfPowSq

        int halfPowSq = halfPow*halfPow;

        // if n is odd
        if (n % 2 != 0) {
            halfPowSq = x*halfPowSq;
        }

        return halfPowSq;
    }

    //problem 11 - tiling problem
    public static int tileProb(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int vChoice = tileProb(n-1);
        int hChoice = tileProb(n-2);

        int totalWays = vChoice+hChoice;

        return totalWays;
    }

    //problem 12 - only lowercase 
    public static void remDup(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar-'a'] == true) {
            remDup(str, idx+1, newStr, map);
        } else {
            map[currChar-'a'] = true;
            remDup(str, idx+1, newStr.append(currChar), map);
        }
    }

    //problem 13 - friends pairing
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) return n;

        return friendsPairing(n-1)+ (n-1) * friendsPairing(n-2);
    }

    //problem 14 - binary string problem
    public static void printBinString(int n, int lastDig, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        
        printBinString(n-1, 0, str+'0');

        if (lastDig == 0) {
            printBinString(n-1, 1, str+'1');
        }

        
    }

    public static void main(String[] args) {
        
        // printDec(10);

        // printInc(10);

        // System.out.println(printFact(6));

        // System.out.println(printSum(4));

        // System.out.println(fibo(6));

        int arr[] = {1,2,3,4,6,66,6,6,6,6,6,6,1,1,2};

        // System.out.println(isSorted(arr, 0));

        // System.out.println(find1stOcc(arr, 0, 56));

        // System.out.println(findLastOcc2(arr, arr.length,  2));

        // System.out.println(findLastOcc2(arr, 0,  2));

        // System.out.println(pow(2, 5));

        // System.out.println(pow2(2, 10));

        // System.out.println(tileProb(5));

        // remDup("abccddesfhggzzz", 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPairing(4));

        printBinString(3, 0, "");
    }
}
