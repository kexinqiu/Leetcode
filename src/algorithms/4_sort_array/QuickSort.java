public class QuickSort {

	public int[] sortArray(int[] nums) {

		quickSort(nums, 0, nums.length-1);

		return nums;
	}

	public static void quickSort(int[] nums, int start, int end){
		if(start>=end) return;

		int left = start-1;
		int right = end+1;
		int x = nums[left+right>>1];

		while(left<right){
			do left++; while(nums[left]<x);
			do right--; while(nums[right]>x);
			if(left<right){
				int tmp = nums[left];
				nums[left]= nums[right];
				nums[right]= tmp;
			}
		}

		quickSort(nums, start, right);
		quickSort(nums, right+1, end);
	}

}
