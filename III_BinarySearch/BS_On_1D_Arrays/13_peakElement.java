/* //Brute Force
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // check first element
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }

        // check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        // check last element
        return n - 1;
    }
}
//TC - O(n)




//Optimal
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1])
                low = mid + 1;
            else if (nums[mid] > nums[mid + 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}




class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        while(low<high)
        {
            int mid = low + (high-low) / 2;
            if(nums[mid]>nums[mid+1])
            {
                high = mid;
            }
            else 
            {
                low = mid + 1;
            }
        }
        return low;
    }
}
//TC - O(log n) */