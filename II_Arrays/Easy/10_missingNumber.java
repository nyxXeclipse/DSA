package II_Arrays.Easy;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOriginal = n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        int missingNumber = sumOriginal - sum;
        return missingNumber;
    }
}
//Optimal - using sum 
//TC - O(N)
//SC - O(1)



/* class Solution {
    public int missingNumber(int[] nums, int n) {

        int xorAll = 0;
        int xorArr = 0;

        // XOR of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        // XOR of array elements
        for (int num : nums) {
            xorArr ^= num;
        }

        // Missing number
        return xorAll ^ xorArr;
    }
}
 */

//TC-O(N)