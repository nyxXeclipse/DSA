package II_Arrays.Easy;

/* class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int p = i; p <= j; p++) {
                    sum += arr[p];
                }

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
} */
//TC - O(N^3)

/* class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
} */
//TC - O(N^2)



//Optimal(This works best for only positive and zeroes)
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int sum = 0;
        int maxLength = 0;
        int left = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            sum += nums[right]; // ✅ add element

            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}
//TC - O(2N) -> This is bcz not everytime the (while) will move for every (for)
//SC - O(1)