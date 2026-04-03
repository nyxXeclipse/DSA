/* GFG - FLOOR
class Solution {
    public int findFloor(int[] arr, int x) {
        return floor(arr, 0, arr.length - 1, x);
    }

    public int floor(int[] arr, int low, int high, int x) {
        int idx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                idx = mid; // possible answer
                low = mid + 1; // move right for larger valid
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }
} */
//TC - O(log n)




/* //Optimal
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
}
//TC - O(n log n) + O(log n) -> O(n log n)
 */