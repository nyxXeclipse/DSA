package II_Arrays.Medium;

//Better and Optimal in this case(where we have to return indexes)
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[] { map.get(needed), i };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}

//TC - O(N)
//SC - O(1)



//Brute Force
/* class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }
} */
//TC - O(N^2)
//SC - O(1)




//Optimal only if we want to return yes or no and no indexes
//Also note that two pointers approach work only when the array is sorted otherwise it does not work
/* import java.util.Arrays;

class Solution {
    public boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }

        return false;
    }
} */
//TC - O(NLOGN) Because of sorting
//sc - O(1) -> this is because indices are not returned in this, if indexes were to returned it will take O(N)
