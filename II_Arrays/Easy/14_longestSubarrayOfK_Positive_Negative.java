package II_Arrays.Easy;

import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {

        // HashMap to store prefix sum and its first index
        // Key -> prefix sum
        // Value -> index where this sum first occurred
        HashMap<Integer, Integer> map = new HashMap<>();

        // Variable to store running prefix sum
        int sum = 0;

        // Variable to store maximum subarray length with sum = k
        int maxLen = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Add current element to prefix sum
            sum += arr[i];

            // If prefix sum equals k,
            // subarray from index 0 to i has sum = k
            if (sum == k) {
                maxLen = i + 1;
            }

            // If (sum - k) exists in map,
            // then subarray from (map.get(sum - k) + 1) to i has sum = k
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Store the first occurrence of this prefix sum even if the same sum is achieved later then also do not store its index keep the index of its first occurrence ony, so to find the longest subarray (eg: (2,0,0) -> here sum = 2 is occuring at 2,0 ; 2,1 ; 2,2 but keep only 2,0 do not store rest as 2,0 will be used to give the length of ongest subarray)
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        // Return the longest subarray length found
        return maxLen;
    }
}

//This is the better for soln for positive, negative and zeroes but optimal exists only for positive and zeroes bcz we use sliding window approach in it
//TC - O(N)
//SC - O(N) -> for hashmap
