class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {

            // If current range is already sorted
            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }
            // Right half is sorted
            else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
//TC - O(log n)
//SC - O(1)