/* class Solution {
    public int upperBound(int[] nums, int x) {
        return ub(nums, 0, nums.length - 1, x);
    }

    public int ub(int[] nums, int low, int high, int x) {
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
} */
//TC - O(log n) -> Base 2




/* GFG
import java.util.Arrays;

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        
        Arrays.sort(arr);
        
        int floor = -1, ceil = -1;
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                return new int[]{x, x}; 
            }
            else if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        
        return new int[]{floor, ceil};
    }
} */