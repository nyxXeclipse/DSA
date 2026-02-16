package II_Arrays.Medium;

//Optimal
class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}
//TC - O(N)




//Better
/* import java.util.HashMap;
class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }

            // Check immediately
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }

        return -1; // For cases where majority not guaranteed
    }
} */
//TC - O(NlogN) + O(N)
//SC - O(N) -> if all elements are unique




//Brute
/* class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // just for safety
    }
} */
//TC - O(N^2)