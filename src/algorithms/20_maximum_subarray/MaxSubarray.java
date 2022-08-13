//tc:o(n)
//sc:o(1)

class Solution {
	public int maxSubArray(int[] nums) {
		int n =nums.length;

		if(n==1) return nums[0];

		//from the first element
		int current_sum = nums[0];
		//can't be 0
		int max_sum = current_sum;

		//traverse the array from seconf element
		//the value of first element has been assigned to current_sum;
		for(int i=1; i<n; i++){
			//there are two cases: adding the element onto subarray or starting a new subarray
			//if adding the new element onto the current sum is less than starting over, then start over
			current_sum = Math.max(current_sum+nums[i], nums[i]);
			//max_sum is always the max of all sum
			max_sum = Math.max(max_sum, current_sum);
		}
		return max_sum;
	}
}

//dp
//when it comes to DP, the first thing for us to figure out is the format of the sub problem
class Solution{
	public int maxSubArray(int[] A) {
		int n = A.length;
		if(n==1) return A[0];

		int[] dp = new int[n];
		dp[0] = A[0];
		int max = dp[0];

		for(int i=1;i<n;i++){
			dp[i] = A[i] + (dp[i-1]>0?dp[i-1]:0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}