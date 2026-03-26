class Solution {
    public int[] insertionSort(int[] nums) {
        sort(nums, nums.length);
        return nums;
    }

    public void sort(int[] nums, int n) {
        if (n <= 1)
            return;
        sort(nums, n - 1);
        insert(nums, n - 1);
    }

    public void insert(int[] nums, int i) {
        if (i == 0 || nums[i] > nums[i - 1])
            return;

        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp;
        insert(nums, i - 1);
    }
}