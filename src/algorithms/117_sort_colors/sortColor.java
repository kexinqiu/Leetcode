//o(n)
//o(1)
class Solution {
	public void sortColors(int[] nums) {

		int low = 0;
		int high = nums.length-1;
		int curr = 0;

		while(curr<=high){
			if(nums[curr]==0) swap(nums, low++, curr++);
			else if(nums[curr]==2) swap(nums, curr, high--);
			else if(nums[curr]==1)  curr++;
		}
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}