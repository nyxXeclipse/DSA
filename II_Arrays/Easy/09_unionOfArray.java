package II_Arrays.Easy;
//Optimal soln
class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {

        int i = 0, j = 0, k = 0;
        int[] temp = new int[nums1.length + nums2.length];

        // main comparison loop
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                if (k == 0 || nums1[i] != temp[k - 1]) {
                    temp[k] = nums1[i];
                    k++;
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (k == 0 || nums2[j] != temp[k - 1]) {
                    temp[k] = nums2[j];
                    k++;
                }
                j++;
            } else { // nums1[i] == nums2[j]
                if (k == 0 || nums1[i] != temp[k - 1]) {
                    temp[k] = nums1[i];
                    k++;
                }
                i++;
                j++;
            }
        }

        // remaining elements of nums1
        while (i < nums1.length) {
            if (k == 0 || nums1[i] != temp[k - 1]) {
                temp[k] = nums1[i];
                k++;
            }
            i++;
        }

        // remaining elements of nums2
        while (j < nums2.length) {
            if (k == 0 || nums2[j] != temp[k - 1]) {
                temp[k] = nums2[j];
                k++;
            }
            j++;
        }

        // copy result into array of exact size
        int[] ans = new int[k];
        for (int idx = 0; idx < k; idx++) {
            ans[idx] = temp[idx];
        }
        return ans;
    }
}
//TC - O(n1 + n2)
//SC - O(n1 + n2) -> not for actual solving just for returning the union array



//Brute force approach
/* import java.util.*;

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {

        // TreeSet keeps elements unique and sorted
        Set<Integer> set = new TreeSet<>();

        // Add elements of first array
        for (int num : nums1) {
            set.add(num);
        }

        // Add elements of second array
        for (int num : nums2) {
            set.add(num);
        }

        // Convert set to array
        int[] union = new int[set.size()];
        int index = 0;

        // Auto-iteration over set
        for (int num : set) {
            union[index++] = num;
        }

        return union;
    }
} */
//TC - O(n1logN + n2logN) + O(n1 + n2)
//SC - O(n1 + n2) + O(n1 + n2)
  


