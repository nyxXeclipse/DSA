/* //Brute
class Solution {
    int maxLength(int arr[]) {
        // code here
        int n = arr.length;
        int maxLength = 0;
        for(int i=0; i<n; i++)
        {
            int sum = 0;
            for(int j =i; j<n; j++)
            {
                sum = sum + arr[j];
                if(sum==0)
                {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}




//Optimal
import java.util.HashMap;

class Solution {
    int maxLength(int arr[]) {
        // code here
        int n = arr.length;
        int maxLength = 0;
        int sum = 0;
        if (n == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == 0) {
                maxLength = i + 1;
            }
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
} */