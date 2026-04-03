/* //Optimal
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




//GFG - CEIL 
class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        return ceil(arr, 0, arr.length - 1, x);

    }

    public int ceil(int[] arr, int low, int high, int x) {
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}
// TC - O(log n) */