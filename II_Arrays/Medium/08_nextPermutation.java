package II_Arrays.Medium;

class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int i = n - 1; i > idx; i--) {
            int temp = 0;
            if (nums[i] > nums[idx]) {
                temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        reverse(nums, idx + 1, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
//Optimal
//TC - O(3N)
//SC - O(1) -> no extra space used but if asked array modified then O(N)

//Brute - by using recursion
//Better - using next_permutation stl in c++