//tc:o(logn)
//sc:o(1)

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
			if(nums[mid]==target){
				index = mid;
				r = mid-1;// lets see if there one more on the left
			}

			else if(nums[mid]>target) r=mid-1;
			else l=mid+1;
		}

		return index;
	}

	public int bsearchRight(int[]nums, int target) {
		int index=-1;

		int l = 0;
		int r = nums.length-1;

		while (l<=r){
			int mid = l + (r-l)/2;
			if(nums[mid]==target){
				index = mid;
				l = mid+1;// lets see if there one more on the right
			}
			else if(nums[mid]<target) l=mid+1;
			else r=mid-1;

			if(nums[mid]==target) index=mid;
		}

		return index;
	}
}