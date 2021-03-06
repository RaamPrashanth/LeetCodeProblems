/* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function. */

class NumArray {

    /*  Without memoization
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        while (i <= j) {
            sum += this.nums[i];
            i++;
        }
        return sum;
    }*/
    
    // Using memoization
    int sums[];
    public NumArray(int[] nums) {
         if (nums.length != 0) {
            sums = new int[nums.length];

            sums[0] = nums[0];
            for (int i = 1; i<nums.length; i++) {
                sums[i] = nums[i] + sums[i-1];
            }
         }
    }
    
    public int sumRange(int i, int j) {
      return (i == 0)? sums[j] : sums[j] - sums[i-1]; 
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

