//Brute
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2]; // ans[0] = repeating, ans[1] = missing

        // Check every number from 1 to n*n
        for (int num = 1; num <= n * n; num++) {
            int count = 0;

            // Traverse entire grid
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == num) {
                        count++;
                    }
                }
            }

            if (count == 2) {
                ans[0] = num; // repeating
            } else if (count == 0) {
                ans[1] = num; // missing
            }
        }

        return ans;
    }
}
//TC - O(N^4)




//Better - using hasharray
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;

        int[] freq = new int[size + 1]; // index 1 to n*n

        // Step 1: Count frequency
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        int repeating = -1, missing = -1;

        // Step 2: Find repeating and missing
        for (int num = 1; num <= size; num++) {
            if (freq[num] == 2) {
                repeating = num;
            } else if (freq[num] == 0) {
                missing = num;
            }
        }

        return new int[] { repeating, missing };
    }
}
//TC - O(n²)
//SC - O(n²)




class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(grid[i][j])) {
                    map.put(grid[i][j], 1);
                } else {
                    ans[0] = grid[i][j];
                }
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (!map.containsKey(i)) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
// TC - O(n²)
// SC - O(n²)




//For linear array not grid array i have solved this
//Optimal using maths
class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        long sum = 0, sumSq = 0;

        for (int num : nums) {
            sum += num;
            sumSq += (long) num * num;
        }

        long Sn = (long) n * (n + 1) / 2;
        long Sn2 = (long) n * (n + 1) * (2 * n + 1) / 6;

        long val1 = sum - Sn; // y - x
        long val2 = (sumSq - Sn2) / val1; // y + x

        long y = (val1 + val2) / 2;
        long x = y - val1;

        return new int[] { (int) x, (int) y }; // {missing, repeating}
    }
}
//TC - O(n)




//Optimal using xor
class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int xr = 0;

        // Step 1: XOR all
        for (int i = 0; i < n; i++) {
            xr ^= nums[i];
            xr ^= (i + 1);
        }

        // Step 2: find first set bit manually
        int pos = 0;
        while ((xr & (1 << pos)) == 0) {
            pos++;
        }

        // Step 3: divide into groups
        int zero = 0, one = 0;

        for (int i = 0; i < n; i++) {
            if ((nums[i] & (1 << pos)) != 0)
                one ^= nums[i];
            else
                zero ^= nums[i];

            if (((i + 1) & (1 << pos)) != 0)
                one ^= (i + 1);
            else
                zero ^= (i + 1);
        }

        // Step 4: check which is repeating
        for (int num : nums) {
            if (num == zero) {
                return new int[] { one, zero };
            }
        }

        return new int[] { zero, one };
    }
}
//TC - O(N)
//SC - O(1)