/* class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sq = (long) mid * mid;
            if (sq <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
//TC - O(log n)




class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
//TC - O(log n) */