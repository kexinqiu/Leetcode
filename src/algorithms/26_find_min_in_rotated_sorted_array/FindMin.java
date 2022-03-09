class Solution {
	public int findMin(int[] nums) {
		//O(logn) means binary search

		//corner case
		if(nums == null || nums.length == 0){
			return -1;
		}

		int l = 0;
		int r = nums.length-1;
		//leave the while loop when we have only one element
		while(l<r){
			int mid = l + (r-l)/2;

			if(nums[mid]<nums[r]) r=mid;
				//skip the nums[mid] since it is not the candidate
			else l=mid+1;
		}
		//return the only element left
		return nums[l];
	}
}