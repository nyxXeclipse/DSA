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





//Optimal
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int element1 = 0, element2 = 0;
        int count1 = 0, count2 = 0;

        // 1st pass → find potential candidates
        for (int num : nums) {
            if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                element2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass → verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == element1)
                count1++;
            else if (num == element2)
                count2++;
        }

        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        if (count1 > n / 3)
            result.add(element1);

        if (count2 > n / 3)
            result.add(element2);

        return result;
    }
}
//TC - O(n)
//SC - O(1)