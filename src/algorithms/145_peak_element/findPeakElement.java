//对于任意数组而言，一定存在峰值（一定有解）
//想象任意一个数a，如果它左边的数b比它大， 那么左边一定存在峰值
//因为，相邻的数不相等，假设b左边一直降序，那么b不是峰值，nums[0]一定是峰值

class Solution {
	public int findPeakElement(int[] nums) {
		int n = nums.length;

		if(n==1 || nums[0]>nums[1]) return 0;

		if(nums[n-1]>nums[n-2]) return n-1;

		int l = 0;
		int r = nums.length-1;

		while(l<=r){
			int mid = l + (r-l)/2;

			if(nums[mid]>nums[mid+1]){
				//必须判断这个edge case，如果nums[mid]>nums[mid-1]，说明mid就是结果，如果直接r = mid - 1，会错过
				if(nums[mid]>nums[mid-1]) return mid;
				r = mid - 1;
			}else{
				l = mid + 1;
			}
		}
		return l;
	}
}