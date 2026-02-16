package II_Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                result.add(arr[i]);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
//TC - O(N)
//SC - O(N)




//Only if the return type is array
/* class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int max  = Integer.MIN_VALUE;
        int[] temp = new int[arr.length];
        int k=0;
        for(int i=arr.length-1; i>=0; i--)
        {
            if(arr[i]>max)
            {
                max = arr[i];
                temp[k] = arr[i];
                k++;
            }
        }
        reverse(temp,0,k-1);
    }
    
    static void reverse(int[] arr, int start, int end)
    {
        while(start<end)
        {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
} */