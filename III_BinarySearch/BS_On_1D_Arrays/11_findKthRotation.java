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