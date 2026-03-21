class recursionBasics {
    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(1+" ");
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n) {
        if (n==1) {
            System.out.print(n+" ");
            return;
        }

        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int printFact(int n) {
        int fact = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        return fact = n * printFact(n-1);
    }

    public static int printSum(int n) {
        int sum = 0;
        if (n == 1) {
            return 1;
        }

        return sum = n+printSum(n-1);
    }

    public static int fibo(int n) {
        if (n==0 || n==1) {
            return n;
        }

        int f1 = fibo(n-1);
        int f2 = fibo(n-2);

        return f1+f2;
    }

    public static void main(String[] args) {
        // printDec(10);

        // printInc(10);

        // System.out.println(printFact(6));

        // System.out.println(printSum(4));

        System.out.println(fibo(6));
    }
}