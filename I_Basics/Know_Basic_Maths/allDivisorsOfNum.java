package I_Basics.Know_Basic_Maths;

/* import java.util.Scanner;
class Solution {
    public void divisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Solution obj = new Solution();
        obj.divisors(n);
    }
} */
//First Method: won't run in coding platform, just for understanding logic
//TC: O(N)

import java.util.*;

class Solution {
    public int[] divisors(int n) {
        List<Integer> list = new ArrayList<>();
        int limit = (int) Math.sqrt(n); //so that for n = 9, sqrt will be 3.something, so convert in int
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {  //to check eg, n=36, if i=6 then n/i = also 6, this will result in two factors same, this line works as(let i=2, then 36/2 = 18 is also a divisor so add it as well)
                    list.add(n / i);
                }
            }
        }

        Collections.sort(list);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

//Second Method: Optimal
//TC: O(sqrt(N))