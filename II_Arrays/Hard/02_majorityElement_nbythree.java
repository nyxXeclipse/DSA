/* /* package II_Arrays.Hard;

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
//SC - O(1)

ALTERNATE BRUTE FORCE - BASED ON THE IDEA THAT AT MOST THERE CAN BE ONLY 2 MAJORITY ELEMENTS - SLIGHTLY IMPROVED TC BUT STILL SAME FOR WORST CASE
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // avoid duplicate work
            if (res.contains(nums[i])) continue;

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3) {
                res.add(nums[i]);
            }

            //early stopping
            if (res.size() == 2) break;
        }

        return res;
    }
}
//TC - O(N^2)
//SC - O(1)




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
//TC - O(N) -> UNORDERED MAP USE HERE THEREFORE +O(1)*/
//SC - O(N)

//ALTERNATE BETTER
/* class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> element = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.get(nums[i]) > n / 3) {
                if (!element.contains(nums[i])) {
                    element.add(nums[i]);
                }
            }

            //  early break (at most 2 elements possible)
            if (element.size() == 2) break;
        }

        return element;
    }
}
// TC - O(N) 
// SC - O(N) */



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
//SC - O(1) */