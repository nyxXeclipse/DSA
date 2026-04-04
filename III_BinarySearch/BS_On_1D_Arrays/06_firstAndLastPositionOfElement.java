//Using concept of ub and lb
class Solution {
    int[] searchRange(int[] arr, int target) {
        int n = arr.length;

        int lb = lowerBound(arr, target); // first occurrence
        int ub = upperBound(arr, target); // first index > target

        if (lb == n || arr[lb] != target) {
            return new int[] { -1, -1 }; // target not found
        }

        int first = lb;
        int last = ub - 1;
        return new int[] { first, last };
    }

    int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}




class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[] { first, last };
    }
}
//TC - O(log n) + O(log n) -> O(log n)




//Using Recursion
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);
        return new int[] { first, last };
    }

    // First Occurrence (Lower Bound)
    public int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1; // move left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Last Occurrence (Upper Bound - 1)
    public int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1; // move right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}