//package II_Arrays.Hard;
/*
 * //Brute
 * class Solution {
 * public List<List<Integer>> fourSum(int[] nums, int target) {
 * List<List<Integer>> result = new ArrayList<>();
 * Arrays.sort(nums);
 * int n = nums.length;
 * for (int i = 0; i < n; i++) {
 * for (int j = i + 1; j < n; j++) {
 * for (int k = j + 1; k < n; k++) {
 * for (int l = k + 1; l < n; l++) {
 * int sum = nums[i] + nums[j] + nums[k] + nums[l];
 * if (sum == target) {
 * List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
 * if (!result.contains(quad)) {
 * result.add(quad);
 * }
 * }
 * }
 * }
 * }
 * }
 * return result;
 * }
 * }
 * 
 * ALTERNATE BRUTE USING HASHSET
 * import java.util.*;
 * 
 * class Solution {
 * public List<List<Integer>> fourSum(int[] nums, int target) {
 * Set<List<Integer>> set = new HashSet<>();
 * int n = nums.length;
 * 
 * for (int i = 0; i < n - 3; i++) {
 * for (int j = i + 1; j < n - 2; j++) {
 * for (int k = j + 1; k < n - 1; k++) {
 * for (int l = k + 1; l < n; l++) {
 * 
 * long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
 * 
 * if (sum == target) {
 * List<Integer> quad = Arrays.asList(
 * nums[i], nums[j], nums[k], nums[l]
 * );
 * 
 * Collections.sort(quad); // avoid duplicates
 * set.add(quad);
 * }
 * }
 * }
 * }
 * }
 * 
 * return new ArrayList<>(set);
 * }
 * }
 * //TC - O(N^4)
 * //SC - O(no. of quads) * 2
 * 
 * 
 * 
 * 
 * //Better
 * import java.util.*;
 * 
 * class Solution {
 * public List<List<Integer>> fourSum(int[] nums, int target) {
 * Set<List<Integer>> res = new HashSet<>();
 * int n = nums.length;
 * 
 * for (int i = 0; i < n; i++) {
 * for (int j = i + 1; j < n; j++) {
 * 
 * Set<Long> seen = new HashSet<>();
 * 
 * for (int k = j + 1; k < n; k++) {
 * 
 * long fourth = (long) target - nums[i] - nums[j] - nums[k];
 * 
 * if (seen.contains(fourth)) {
 * List<Integer> quad = Arrays.asList(
 * nums[i], nums[j], nums[k], (int) fourth
 * );
 * 
 * Collections.sort(quad); // ensure uniqueness
 * res.add(quad);
 * }
 * 
 * seen.add((long) nums[k]);
 * }
 * }
 * }
 * 
 * return new ArrayList<>(res);
 * }
 * }
 * //TC - O(n³) * logm
 * //SC - O(N) + O(quads)*2
 * 
 * 
 * 
 * 
 * //Optimal
 * import java.util.*;
 * 
 * class Solution {
 * public List<List<Integer>> fourSum(int[] nums, int target) {
 * List<List<Integer>> result = new ArrayList<>();
 * int n = nums.length;
 * 
 * if (n < 4) return result;
 * 
 * Arrays.sort(nums);
 * 
 * for (int i = 0; i < n - 3; i++) {
 * 
 * // skip duplicate i
 * if (i > 0 && nums[i] == nums[i - 1]) continue;
 * 
 * for (int j = i + 1; j < n - 2; j++) {
 * 
 * // skip duplicate j
 * if (j > i + 1 && nums[j] == nums[j - 1]) continue;
 * 
 * int left = j + 1;
 * int right = n - 1;
 * 
 * while (left < right) {
 * 
 * long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
 * 
 * if (sum < target) {
 * left++;
 * }
 * else if (sum > target) {
 * right--;
 * }
 * else {
 * result.add(Arrays.asList(
 * nums[i], nums[j], nums[left], nums[right]
 * ));
 * 
 * // skip duplicates for left & right
 * while (left < right && nums[left] == nums[left + 1]) left++;
 * while (left < right && nums[right] == nums[right - 1]) right--;
 * 
 * left++;
 * right--;
 * }
 * }
 * }
 * }
 * 
 * return result;
 * }
 * }
 * TC - O(N^3) * 
 * SC - O(no. of quads)
 */