package I_Basics.Easy;

class Solution {
    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Avoid overflow using division
            if (mid <= x / mid) {
                ans = mid; // mid is a possible answer
                low = mid + 1; // try to find bigger one
            } else {
                high = mid - 1; // reduce search space
            }
        }

        return ans;
    }
}
