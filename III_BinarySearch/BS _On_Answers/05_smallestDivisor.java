class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int divisor : nums) {
            max = Math.max(divisor, max);
        }
        int low = 1, high = max;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = divide(nums, mid);
            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int divide(int[] nums, int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + ((nums[i] + mid - 1) / mid);
        }
        return sum;
    }
}