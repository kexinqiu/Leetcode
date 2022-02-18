class Solution {
	public int findKthLargest(int[] nums, int k) {
		int m=0;
		m=quickSort(nums,0, nums.length-1, k);
		return m;
	}

	public int quickSort(int[] arr, int start, int end, int k ){
		if(start>=end) return arr[start];

		int left = start-1;
		int right = end+1;
		int x = arr[left+right>>1];

		while(left<right){
			do left++; while(arr[left]<x);
			do right--; while(arr[right]>x);

			if(left<right){
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		}

		int t = right-start+1;
		if(k<t) return quickSort(arr, start, end,  k);
		else return quickSort(arr, right+1, end,k-t);
	}
}