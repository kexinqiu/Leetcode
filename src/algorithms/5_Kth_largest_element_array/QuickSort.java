class Solution {
	public int findKthLargest(int[] nums, int k) {
		quickSort(nums, 0, nums.length-1);
		return nums[nums.length-k];
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private int partition(int[] nums, int l, int r){
		int pivot = nums[r];
		int i = l-1;

		for(int j=l;j<r;j++){
			if(nums[j]<=pivot){
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i+1, r);
		return i+1;
	}

	private void quickSort(int[] nums, int l, int r){
		if(l<r){
			int pivot = partition(nums, l, r);
			quickSort(nums, l, pivot-1);
			quickSort(nums, pivot+1, r);
		}
	}
}