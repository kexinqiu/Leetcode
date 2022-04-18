class Solution {
	public int[] sortArray(int[] nums) {

		mergeSort(nums, 0, nums.length-1);
		return nums;
	}

	private void mergeSort(int[] nums, int start, int end){
		if(start>=end) return;

		int mid = start+(end-start)/2;

		mergeSort(nums, start, mid);
		mergeSort(nums, mid+1, end);

		merge(nums, start, end, mid);
	}

	private void merge(int[] nums, int start, int end, int mid){
		int left = start;
		int right = mid+1;
		int[] tmp = new int[end-start+1];
		int count = 0;

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