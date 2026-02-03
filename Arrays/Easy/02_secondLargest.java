package Arrays.Easy;

class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]<largest)
            {
                secondLargest = arr[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
        return secondLargest;
    }
}

//Brute approach - sort the entire array and give the second last index, but there can exist duplicate largest which will add complexity - Complexity - O(NlogN)
//Better approach - one loop to find largest, second loop to find second largest(store slargest=-1 and if arr[i]>slargest && arr[i]!=largest - slargest=arr[i]) - Complexity-O(2N)
//Optimal Approach - soln here is optimal - Complexity - O(N)