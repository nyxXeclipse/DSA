//Brute Force
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n && j >= 0) {
            while (i < j) {
                if (nums[i] > 2L * nums[j]) {
                    count++;
                }
                i++;
            }
            i = 0;
            j--;
        }
        return count;
    }
}
