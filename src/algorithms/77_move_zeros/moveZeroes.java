//two pointers
//l is the end of integer which is not 0
//r is the start of integer which is 0
//as same as quicksort

class Solution {
	public void moveZeroes(int[] nums) {
		int l = -1;

		for(int r=0;r<nums.length;r++){
			if(nums[r]!=0){
				l++;
				int tmp = nums[l];
				nums[l] = nums[r];
				nums[r] = tmp;
			}
		}
	}
}