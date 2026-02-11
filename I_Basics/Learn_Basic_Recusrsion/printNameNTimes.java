package I_Basics.Learn_Basic_Recusrsion;
class Solution {

    void printGfg(int N) {
        if (N == 0)
            return;

        System.out.print("GFG ");
        printGfg(N - 1);
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.printGfg(5);
    }
}
