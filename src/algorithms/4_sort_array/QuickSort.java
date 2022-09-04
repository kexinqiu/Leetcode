class Solution {
	public int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length-1);
		return nums;
	}

	private void quickSort(int[] nums, int start, int end){
		if(start<end){
			int pivot = partition(nums, start, end);
			quickSort(nums, start, pivot-1);
			quickSort(nums, pivot+1, end);
		}
	}

	private int partition(int[] nums, int start, int end){
		int pivot = nums[end];
		int i = start-1;

		for(int j=start;j<end;j++){
			if(nums[j]<=pivot){
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i+1, end);
		return i+1;
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}



class Solution {
	public int[] sortArray(int[] nums) {
		if (nums == null || nums.length == 0) return nums;
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}
	private void quickSort(int[] nums, int l, int r) {
		if (l < r) {
			int mid = partition(nums, l, r);
			quickSort(nums, l, mid-1);
			quickSort(nums, mid + 1, r);
		}
	}
	private int partition(int[] nums, int l, int r) {
		int pivot = nums[l];
		while (l < r) {
			while (l < r && nums[r] >= pivot) r--;
			nums[l] = nums[r];
			while (l < r && nums[l] <= pivot) l++;
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		return l;
	}
}