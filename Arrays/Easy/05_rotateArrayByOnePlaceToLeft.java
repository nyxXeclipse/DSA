package Arrays.Easy;

class Solution {
    public static void rotateLeftByOne(int[] arr) {
        int n = arr.length;

        int temp = arr[0]; // save first element

        for (int i = 1; i < n - 1; i++) {
            arr[i-1] = arr[i]; // shift left
        }

        arr[n - 1] = temp; // put first at end
    }
}

//Run Time Complexity: O(N)
//Space Complexity: O(N) - space used in algo
//Space Complexity(extra space): O(1)