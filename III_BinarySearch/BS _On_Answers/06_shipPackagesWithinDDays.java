class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalSum = 0;
        int maxWeight = Integer.MIN_VALUE;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalSum = totalSum + weight;
        }
        int low = maxWeight, high = totalSum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canShip(int[] weights, int capacity, int days) {
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = w;
            } else {
                currentLoad = currentLoad + w;
            }
        }
        return daysNeeded <= days;
    }
}