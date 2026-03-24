/* //Brute Force
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
//TC - O(n²)
//SC - O(1)



//Optimal
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count = count + mergeSort(nums, left, mid);
            count = count + mergeSort(nums, mid + 1, right);
            count = count + countPairs(nums, left, mid, right);
            merge(nums, left, mid, right);
        }
        return count;
    }

    public int countPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int temp[] = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
                k++;
            } else {
                temp[k] = nums[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}
//TC - O(n log n)
//SC - O(n) */