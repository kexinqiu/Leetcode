import java.util.Arrays;
//如果数组是排好序的，双指针更简便；否则哈希表
//如果结果是返回两个数字也可使用双指针，返回index则不使用
class TwoSum2 {

	public static int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		Arrays.sort(nums);

		while(left<right){
			int sum = nums[left]+nums[right];
			if(sum>target){
				right-=1;
			}else if(sum<target){
				left+=1;
			}else{
				return new int[]{left,right};
			}
		}
		return new int[]{};

	}
}
