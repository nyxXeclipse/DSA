/* package II_Arrays.Hard;

//Brute Force
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> element = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > nums.length / 3) {
                if (!element.contains(nums[i]))
                    element.add(nums[i]);
            }
        }
        return element;
    }
}
//TC - O(N^2)




//Better
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> element = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > nums.length / 3) {
                if (!element.contains(nums[i]))
                    element.add(nums[i]);
            }
        }
        return element;
    }
}
//TC - O(NlogN) + O(N) */