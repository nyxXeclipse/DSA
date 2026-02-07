package I_Basics.Know_Basic_Maths;

class Solution {
    public int GCD(int n1, int n2) {
        int max = 0;
        int k = 0;
        int gcd = 0;
        if (n1 > n2) {
            max = n1;
        } else {
            max = n2;
        }
        int[] temp = new int[max];
        for (int i = 1; i <= max; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                temp[k] = i;
                k++;
            }
        }
        for (int j = 0; j < k; j++) {
            if (temp[j] > gcd) {
                gcd = temp[j];
            }
        }
        return gcd;
    }
}