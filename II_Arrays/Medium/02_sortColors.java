package II_Arrays.Medium;

//Optimal
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//TC - O(N)
//SC - O(1)




//Brute - Bubble sort
/* class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
} */
//TC - O(N^2)
//SC - O(1)




//Better
/* class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // Step 1: Count
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        // Step 2: Rewrite array
        int index = 0;

        for (int i = 0; i < count0; i++) {
            nums[index] = 0;
            index++;
        }

        for (int i = 0; i < count1; i++) {
            nums[index] = 1;
            index++;
        }

        for (int i = 0; i < count2; i++) {
            nums[index] = 2;
            index++;
        }
    }
} */
//TC - O(2N)
//SC - O(1)