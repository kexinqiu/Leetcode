Kadane Algorithms  O(n)





Brute force:   two slow !

whenever we want to find the maximum or minimum , we can generate all those some things and then find
the maximum or minimum

O(n^2)

class Solution {
	public int maxSubArray(int[] nums) {
		int n =nums.length;

        if(n==1) return nums[0];

        int sum = 0;
        //can't be 0
        int max_sum = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            sum = nums[i];
            max_sum = Math.max(max_sum, sum);
            for(int j=i+1; j<n;j++){
                sum += nums[j];
                max_sum = Math.max(max_sum, sum);
            } 
        }
        return max_sum;
    }
}