package II_Arrays.Easy;

class largestElement {
    public static int largest(int[] arr) {
        // code here
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

// brute approach - sort the entire array and return the index of the last element - complexity - O(NlogN)
// optimal approach - soln here is optimal approach
// time-complexity - O(N) - 1 traversal equal to length of array, say N