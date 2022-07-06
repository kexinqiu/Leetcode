//从后往前找第一个升序数列【i，j】
//找到第一个升序区间后，从后往前找到第一个比nums[i]大的数，并进行swap
//为了确保next permutation足够小，将nums[i]后面的区间进行生序排列（因此该区间一定是降序，因此无需排序，只需reverse）
//如果已经是最大的数组，那么无法满足第一步找到生序区间，直接进入第三步，reverse后得到最小的数组

//tc o(n)
//sc o(1)

class Solution {
	public void nextPermutation(int[] nums) {
		//从后往前找
		int i = nums.length-2;
		//找到第一个升序区间 start index
		while(i>=0&&nums[i]>=nums[i+1]){
			i--;
		}
		//如果i<0说明没有找到升序区间，已经是最大数列
		if(i>=0){
			//找到第一个比该数大的数字，swap
			int j = nums.length-1;

			while(i>=0 && j>=0 && nums[j]<=nums[i]){
				j--;
			}
			swap(nums, i, j);
		}
		//可以确定从该数开始往后，一定是降序区间
		reverse(nums, i+1, nums.length-1);
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int start, int end){
		while(start<end){
			swap(nums, start++, end--);
		}
	}
}