class Solution {
	public int findKthLargest(int[] nums, int k) {

		mergeSort(nums,0, nums.length-1);
		return nums[nums.length-k];


	}


	public void mergeSort(int[] arr, int start, int end){
		if(start>=end) return;

		int mid = start+end >>1;

		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);

		int k=0;
		int left = start;
		int right = mid+1;
		int[] tmp = new int[end-start+1];

		while(left<=mid && right<=end){

			if(arr[left]<=arr[right]) tmp[k++]=arr[left++];
			else tmp[k++]=arr[right++];
		}

		while(left<=mid) tmp[k++]=arr[left++];
		while(right<=end) tmp[k++]=arr[right++];


		for(int i=start, j=0; i<=end; i++,j++){
			arr[i]=tmp[j];
		}

	}
}