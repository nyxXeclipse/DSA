package Arrays.Easy;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int unique = 1; // first element is always unique

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[unique - 1]) {
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
    }
}
