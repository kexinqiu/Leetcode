class Solution {
	public int findKthLargest(int[] nums, int k) {
		mergeSort(nums,0, nums.length-1);
		return nums[nums.length-k];
	}


	public void mergeSort(int[] arr, int start, int end){
		if(start>=end) return;

		int mid = start+(end-start)/2;

		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);

		merge(arr, start, end, mid);
	}

	private void merge(int[] arr, int start, int end, int mid){
		int l = start;
		int r = mid+1;
		int count = 0;
		int[] tmp = new int[end-start+1];

		while(l<=mid&&r<=end){
			if(arr[l]<arr[r]) tmp[count++] = arr[l++];
			else tmp[count++] = arr[r++];
		}
		while(l<=mid){
			tmp[count++] = arr[l++];
		}
		while(r<=end){
			tmp[count++] = arr[r++];
		}
		for(int i=start, j=0;i<=end;i++, j++){
			arr[i]=tmp[j];
		}
	}
}