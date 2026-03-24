/* //Brute
class Solution {
    static int inversionCount(int arr[]) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
//TC - O(n²)
//SC - O(1)




//Optimal
class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count = count + mergeSort(arr, left, mid);
            count = count + mergeSort(arr, mid + 1, right);
            count = count + merge(arr, left, mid, right);
        }
        return count;
    }

    static int merge(int arr[], int left, int mid, int right) {
        int count = 0;
        int temp[] = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                count = count + mid - i + 1;
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        return count;
    }
}
//TC - O(n log n)
//SC - O(n) */