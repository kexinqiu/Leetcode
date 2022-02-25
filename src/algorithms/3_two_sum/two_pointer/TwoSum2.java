import java.util.Arrays;
//如果数组是排好序的，双指针更简便；否则哈希表
//如果结果是返回两个数字也可使用双指针，返回index则不使用

class TwoSum2 {

	public static int[] twoSum(int[] nums, int target) {

		int[] tmp= new int[2];

		if(nums.length<2) return tmp;
		Arrays.sort(nums);

		int left = 0;
		int right = nums.length-1;

		while(left<right){
			int sum = nums[left]+nums[right];

			if(sum>target){
				right--;
			}else if(sum<target){
				left++;
			}else{
				tmp[0]=nums[left];
				tmp[1]=nums[right];
				while(left < right && nums[left] == nums[left + 1]) left++;
				while(left < right && nums[right] == nums[right - 1]) right--;
				left++;
				right--;
			}
		}
		return tmp;

	}
}
