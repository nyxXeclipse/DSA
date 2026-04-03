/* class Solution {
    public int upperBound(int[] nums, int x) {
        return ub(nums, 0, nums.length - 1, x);
    }

    public int ub(int[] nums, int low, int high, int x) {
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
} */
//TC - O(log n) -> Base 2




