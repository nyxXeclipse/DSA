package I_Basics.Learn_Basic_Recursion;

class solution {
    public void printNumbers(int n) {
        // base case
        if (n == 0) {
            return;
        }

        // recursive call
        printNumbers(n - 1);

        // print after recursion (to get increasing order)
        System.out.println(n);
    }
}
