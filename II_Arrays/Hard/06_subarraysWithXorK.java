/* //Brute
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int xor = 0;

                // compute XOR of subarray i → j
                for (int x = i; x <= j; x++) {
                    xor ^= nums[x];
                }

                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
//TC - O(N^3)
//SC - O(1)




//Better Force
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor ^ nums[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
//TC - O(N^2)
//SC - O(1)




//Optimal
import java.util.*;

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int xr = 0; // prefix XOR
        int count = 0;

        // Important: handles subarrays starting from index 0
        map.put(0, 1);

        for (int num : nums) {
            xr ^= num; // update prefix XOR

            int needed = xr ^ k;

            // if this exists, we found subarrays
            if (map.containsKey(needed)) {
                count += map.get(needed);
            }

            // store current XOR
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return count;
    }
}
//TC - O(N)
//SC - O(N) -> for hashmap */