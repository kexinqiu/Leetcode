class Solution {
	public int[] sortArray(int[] nums) {

		mergeSort(nums, 0, nums.length-1);

		return nums;
	}

	public static void mergeSort(int[] nums, int start, int end){
		if(start>=end) return;

		int mid = start+end >> 1;

		mergeSort(nums, start, mid);
		mergeSort(nums, mid+1, end);

		int count = 0;
		int left = start;
		int right = mid+1;
		int[] tmp = new int[end-start+1];

		while(left<=mid && right <=end){
			if(nums[left]<nums[right]) tmp[count++]=nums[left++];
			else tmp[count++]=nums[right++];
		}
		while(left<=mid) tmp[count++]=nums[left++];
		while(right<=end) tmp[count++]=nums[right++];

		for(int i=start, j=0; i<=end; i++, j++){
			nums[i]=tmp[j];
		}
	}
}