class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first = -1, last = -1;
        int count = 0;
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (first == -1)
            return 0;
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        count = last - first + 1;
        return count;
    }
}
//TC - O(log n)




class Solution {
    int countFreq(int[] arr, int target) {
        int first = firstOcc(arr, target, 0, arr.length - 1);

        if (first == -1)
            return 0; // target not found

        int last = lastOcc(arr, target, 0, arr.length - 1);

        return last - first + 1;
    }

    // First occurrence
    int firstOcc(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            int left = firstOcc(arr, target, low, mid - 1);
            return (left == -1) ? mid : left;
        } else if (arr[mid] < target) {
            return firstOcc(arr, target, mid + 1, high);
        } else {
            return firstOcc(arr, target, low, mid - 1);
        }
    }

    // Last occurrence
    int lastOcc(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            int right = lastOcc(arr, target, mid + 1, high);
            return (right == -1) ? mid : right;
        } else if (arr[mid] < target) {
            return lastOcc(arr, target, mid + 1, high);
        } else {
            return lastOcc(arr, target, low, mid - 1);
        }
    }
}