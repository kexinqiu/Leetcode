class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] tmp = new int[2];
		tmp[0] = bsearchLeft(nums, target);
		tmp[1] = bsearchRight(nums, target);
		return tmp;
	}

	public int bsearchLeft(int[] nums, int target) {
		int index=-1;

		int l=0;
		int r=nums.length-1;

		while(l<=r){
			int mid = l+(r-l)/2;

			if(nums[mid]==target) index=mid;
			//mid has been checked, so mid+1 or mid-1
			else if (nums[mid]>target) r=mid-1;
			else l=mid+1;

		}

		return index;
	}

	public int bsearchRight(int[]nums, int target) {
		int index=-1;

		int l = 0;
		int r = nums.length-1;

		while (l<=r){
			//overflow
			int mid = l + (r-l)/2;
			if(nums[mid]==target) index=mid;
			else if(nums[mid]<target) l=mid+1;
			else r=mid-1;

		}

		return index;
	}
}