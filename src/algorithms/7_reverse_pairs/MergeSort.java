// 注意 如果 nums[i] > nums[j] * int   与 nums[i] > nums[j] 不同
//如果倍数不为1， 计算数量和排序要分开
//还要注意 2*  可能会超出int范围

class Solution {
	public int reversePairs(int[] nums) {

		int n = mergeSort(nums, 0 , nums.length-1);
		return  n;
	}

	public int mergeSort(int[] arr, int start, int end){
		if(start>=end) return 0;

		int mid = start+end>>1;
		int count = 0;

		count += mergeSort(arr, start, mid);
		count += mergeSort(arr, mid+1, end);

		int k = 0;
		int l = start;
		int r = mid + 1;
		int[] tmp = new int[end-start+1];

		while(l<=mid && r<=end){
			if((long)arr[l]>2*(long)arr[r]){
				count+=mid-l+1;
				r++;
			}else l++;
		}

		l = start;
		r = mid+1;

		while(l<=mid && r<=end){
			if(arr[l]<=arr[r]) tmp[k++]=arr[l++];
			else tmp[k++]=arr[r++];
		}

		while(l<=mid) tmp[k++]=arr[l++];
		while(r<=end) tmp[k++]=arr[r++];

		for(int i=start, j=0; i<=end; i++, j++){
			arr[i]=tmp[j];
		}

		return count;
	}
}

//A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] >  nums[j].
class Solution {
	public int reversePairs(int[] nums) {

		int n = mergeSort(nums, 0 , nums.length-1);
		return  n;
	}

	public int mergeSort(int[] arr, int start, int end){
		if(start>=end) return 0;

		int mid = start+end>>1;
		int count = 0;

		count += mergeSort(arr, start, mid);
		count += mergeSort(arr, mid+1, end);

		int k = 0;
		int l = start;
		int r = mid + 1;
		int[] tmp = new int[end-start+1];

		while(l<=mid && r<=end){
			if(arr[l]<=arr[r]) tmp[k++]=arr[l++];
			else {
				count += mid-l+1;
				tmp[k++]=arr[r++];
			}
		}

		while(l<=mid) tmp[k++]=arr[l++];
		while(r<=end) tmp[k++]=arr[r++];

		for(int i=start, j=0; i<=end; i++, j++){
			arr[i]=tmp[j];
		}

		return count;
	}
}