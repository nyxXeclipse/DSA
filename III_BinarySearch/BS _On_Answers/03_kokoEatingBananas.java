/* class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int low = 1, high = max;
        int ans = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalHrs = func(piles, mid);
            if (totalHrs <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public long func(int[] piles, int hourly) {
        long totalHrs = 0;
        for (int pile : piles) {
            totalHrs += (pile + hourly - 1) / hourly;
        }
        return totalHrs;
    }
}
//TC - O(n) * O(log max(element)) -> O(n) for calculating totalHrs function




//Same without using ans
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1, high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalHrs = func(piles, mid);

            if (totalHrs <= h) {
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1; // need more speed
            }
        }

        return low; // this is the answer
    }

    public long func(int[] piles, int hourly) {
        long totalHrs = 0;

        for (int pile : piles) {
            totalHrs += (pile + hourly - 1) / hourly;
        }

        return totalHrs;
    }
} */