class Solution {
    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            } else {
                temp[k] = nums[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = nums[j];
            k++;
            j++;
        }
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}