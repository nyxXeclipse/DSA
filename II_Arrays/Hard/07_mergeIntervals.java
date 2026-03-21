import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
                end = Math.max(intervals[i + 1][1], end);
                i++;
            }
            result.add(new int[] { start, end });
        }
        return result.toArray(new int[result.size()][]);
    }
}