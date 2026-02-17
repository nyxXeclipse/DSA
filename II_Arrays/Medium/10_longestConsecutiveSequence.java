package II_Arrays.Medium;

//Better
import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int count = 1;
        int max = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                continue; // skip duplicates
            } 
            else if (nums[i] + 1 == nums[i + 1]) 
            {
                count++;
                max = Math.max(max, count);
            } 
            else 
            {
                count = 1;
            }
        }
        return max;
    }
}
//TC - O(N log N) + O(N)
//SC - O(1) (ignoring sort stack)




//Brute
/* class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int count = 1;

            int nextNum = currentNum + 1;

            while (contains(nums, nextNum)) {
                count++;
                nextNum++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target)
                return true;
        }
        return false;
    }
} */
//TC - O(N³)
//SC - O(1)




//Optimal
/* import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // start only if it's the beginning of sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
} */
//TC - O(N) + O(N)
//SC - O(N)