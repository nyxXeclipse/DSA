class Solution {
    public int[] bubbleSort(int[] nums) {
        sort(nums, nums.length);
        return nums;
    }

    public void sort(int[] nums, int n) {
        if (n == 1)
            return;

        // one pass of bubble
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }

        sort(nums, n - 1);
    }
}
