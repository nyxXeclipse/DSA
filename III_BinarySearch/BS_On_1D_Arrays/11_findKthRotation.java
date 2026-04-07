//Using the concept of min in arr
class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n = arr.length;
        int low = 0, high = n - 1;
        int idx = -1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    idx = low;
                }
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    idx = low;
                }
                low = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    idx = mid;
                }
                high = mid - 1;
            }
        }
        return idx;
    }
}
//TC - O(log n)
//SC - O(1)




class Solution {
    public int findKRotation(int arr[]) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Minimum is in right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            // Minimum is in left half (including mid)
            else {
                high = mid;
            }
        }
        return low; // index of minimum = number of rotations
    }
}
// TC - O(log n)
// SC - O(1)




