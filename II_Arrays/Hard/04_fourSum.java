//package II_Arrays.Hard;
/* //Brute
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            if (!result.contains(quad)) {
                                result.add(quad);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}




//Better
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        if (!result.contains(quad)) {
                            result.add(quad);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}




//Optimal
// import java.util.*;
// class Solution {
// public List<List<Integer>> fourSum(int[] nums, int target) {

// List<List<Integer>> result = new ArrayList<>();
// int n = nums.length;
// //Edge case
// if (n < 4) return result;

// Arrays.sort(nums);

// for (int i = 0; i < n - 3; i++) {

// // skip duplicate i
// if (i > 0 && nums[i] == nums[i - 1]) continue;

// for (int j = i + 1; j < n - 2; j++) {

// // skip duplicates for j
// if (j > i + 1 && nums[j] == nums[j - 1]) continue;

// long remainingTarget = (long) target - nums[i] - nums[j];

// int left = j + 1;
// int right = n - 1;
// // two pointer search

// while (left < right) {

// long sum = nums[left] + nums[right];

// if (sum < remainingTarget) {
// left++;
// }
// else if (sum > remainingTarget) {
// right--;
// }
// else {
// result.add(Arrays.asList(
// nums[i], nums[j], nums[left], nums[right]
// ));

// // skip duplicates for left & right
// while (left < right && nums[left] == nums[left + 1]) left++;
// while (left < right && nums[right] == nums[right - 1]) right--;

// left++;
// right--;
// }
// }
// }
// }
// return result;
// }
// }
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // Edge Case
        if (n < 4)
            return result;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                long remainingTarget = (long) target - nums[i] - nums[j];
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = nums[left] + nums[right];
                    if (sum < remainingTarget) {
                        left++;
                    } else if (sum > remainingTarget) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // skip duplicate for left and right
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    }
                }

            }
        }
        return result;
    }
}
 */