package II_Arrays.Easy;

class Solution {
    public int linearSearch(int nums[], int target) {
        // Your code goes here
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)
