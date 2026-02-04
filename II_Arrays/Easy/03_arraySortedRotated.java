package II_Arrays.Easy;
class arraySortedRotated {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }
        }
        return count <= 1;
    }
}

//Complexity - O(N)
//Here Brute = Optimal Approach