//Brute Force
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n && j >= 0) {
            while (i < j) {
                if (nums[i] > 2L * nums[j]) {
                    count++;
                }
                i++;
            }
            i = 0;
            j--;
        }
        return count;
    }
}



//Optimal
class Solution {
    public int mergesort(int[] nums, int left, int right) {
        int count = 0;
        if (left >= right)
            return count;

        int mid = left + (right - left) / 2;

        count += mergesort(nums, left, mid);
        count += mergesort(nums, mid + 1, right);

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // optimization
        if (nums[mid] <= nums[mid + 1])
            return count;

        merge(nums, left, right, mid);

        return count;
    }

    public void merge(int[] nums, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];

        for (i = left, k = 0; k < temp.length; i++, k++) {
            nums[i] = temp[k];
        }
    }

    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }
}
