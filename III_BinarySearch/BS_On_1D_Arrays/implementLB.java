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
    public int findFloor(int[] arr, int x) {
        int idx = -1;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                idx = mid; // possible answer
                left = mid + 1; // try to find larger valid value
            } else {
                right = mid - 1; // move left
            }
        }
        return idx;
    }
}
//TC - O(log n)
//SC - O(1)
 */