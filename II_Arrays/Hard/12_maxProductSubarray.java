/* //Brute Force
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int product = 1;

                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                }

                max = Math.max(max, product);
            }
        }

        return max;
    }
}
//TC - O(N^3)
//SC - O(1)




//Better 
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product = product * nums[j];
                max = Math.max(max,product);
            }
        }
        return max;
    }
}
//TC - O(N^2)
//SC - O(1)




//Optimal - Two approaches - i) Observation ii)kadanes
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
//TC - O(n)
//SC - O(1)

//ii) Kadane
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // if number is negative, swap
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            max = Math.max(max, currMax);
        }

        return max;
    }
}
//Understand again
//TC - O(N)
//SC - O(1) */