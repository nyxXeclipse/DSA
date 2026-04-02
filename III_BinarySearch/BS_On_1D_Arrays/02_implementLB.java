/* package III_BinarySearch.BS_On_1D_Arrays;
//Floor in a Sorted Array - GFG
//Brute Force
class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int i = 0;
        int idx = -1;
        while (i < arr.length && arr[i] <= x) {
            if (arr[i] <= x) {
                idx = i;
            }
            i++;
        }
        return idx;
    }
}
//TC - O(n)
//SC - O(1)



//Optimal
class Solution {
    public int lowerBound(int[] nums, int x) {
        return lb(nums, 0, nums.length - 1, x);
    }

    public int lb(int[] nums, int low, int high, int x) {
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= x) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

//TC - O(log n)
//SC - O(1)
 */