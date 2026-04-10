/* //Brute Force
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // check first element
        if (n == 1 || nums[0] != nums[1]) {
            return nums[0];
        }

        // check last element
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        // check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return -1; // should never happen
    }
}
//TC - O(n)




//Optimal - BS
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            if (mid % 2 == 1 && nums[mid] == nums[mid - 1] || mid % 2 == 0 && nums[mid] == nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}




class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
//TC - O(log n)
//SC - O(1) */