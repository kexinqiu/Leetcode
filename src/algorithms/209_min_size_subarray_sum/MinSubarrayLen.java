package algorithms

class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int length = Integer.MAX_VALUE;

		int l = 0;
		int sum = 0;

		for (int r = 0; r < nums.length; r++) {
			sum += nums[r];
			while (sum >= target) {
				length = Math.min(length, r - l + 1);
				sum = sum - nums[l];
				l++;
			}
		}

		return length == Integer.MAX_VALUE? 0 : length;
	}
}