package II_Arrays.Medium;

//Brute force
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0; // reset for each i

            for (int j = i; j < nums.length; j++) {
                sum += nums[j]; // continuously add

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}