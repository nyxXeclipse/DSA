//package II_Arrays.Hard;
/*
 * //Brute
 * import java.util.*;
 * 
 * class Solution {
 * public List<List<Integer>> threeSum(int[] nums) {
 * List<List<Integer>> result = new ArrayList<>();
 * int n = nums.length;
 * Arrays.sort(nums);
 * for (int i = 0; i < n - 2; i++) {
 * for (int j = i + 1; j < n - 1; j++) {
 * for (int k = j + 1; k < n; k++) {
 * 
 * if (nums[i] + nums[j] + nums[k] == 0) {
 * 
 * List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
 * 
 * // avoid duplicates
 * if (!result.contains(triplet)) {
 * result.add(triplet);
 * }
 * }
 * }
 * }
 * }
 * 
 * return result;
 * }
 * }
 * 
 * 
 * 
 * 
 * //Optimal
 * import java.util.*;
 * 
 * class Solution {
 * public List<List<Integer>> threeSum(int[] nums) {
 * List<List<Integer>> result = new ArrayList<>();
 * Arrays.sort(nums);
 * 
 * int n = nums.length;
 * 
 * for (int i = 0; i < n - 2; i++) {
 * if (i > 0 && nums[i] == nums[i - 1])
 * continue;
 * int left = i + 1;
 * int right = n - 1;
 * 
 * while (left < right) {
 * int sum = nums[i] + nums[left] + nums[right];
 * 
 * if (sum < 0) {
 * left++;
 * } else if (sum > 0) {
 * right--;
 * } else {
 * result.add(Arrays.asList(nums[i], nums[left], nums[right]));
 * while (left < right && nums[left] == nums[left] + 1)
 * left++;
 * while (left < right && nums[right] == nums[right - 1])
 * right--;
 * 
 * left++;
 * right--;
 * }
 * }
 * }
 * return result;
 * }
 * }
 */