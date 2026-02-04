package I_Basics.Know_Basic_Maths;

class Solution {
    public boolean isPalindrome(int x) {
        int original, rev = 0, rem;
        original = x;
        while (x > 0) {
            rem = x % 10;
            rev = rev * 10 + rem;
            x = x / 10;
        }
        return original == rev;
    }
}