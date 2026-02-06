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
//this is not very better because for larger array it will not be able to store in int type


/* class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int xorOriginal = 0;
        int xorArr = 0;

        // XOR of numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xorOriginal ^= i;
        }

        // XOR of array elements
        for (int i = 0; i < n; i++) {
            xorArr ^= nums[i];
        }

        int missingNumber = xorOriginal ^ xorArr;
        return missingNumber;
    }
}
//TC - O(2N) */




/* class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        return xor ^ n;
    }
} */
//TC-O(N)