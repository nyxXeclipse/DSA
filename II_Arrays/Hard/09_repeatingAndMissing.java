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