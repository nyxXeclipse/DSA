package II_Arrays.Easy;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else
                count = 0;
        }
        return max;
    }
}
// TC - O(N)
//SC - O(1)


/* class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] temp = new int[nums.length];
        int k = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                temp[k] = count;
                k++;
            } else
                count = 0;
        }
        int max = 0;
        for (int j = 0; j < k; j++) {
            if (temp[j] >= max) {
                max = temp[j];
            }
        }
        return max;
    }
} */
//very lengthy not good


