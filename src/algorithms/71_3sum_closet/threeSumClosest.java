class Solution {
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int res;

		int min = Integer.MAX_VALUE;

		for(int i=0;i<nums.length;i++){
			if(i==0 || (i>0&&nums[i]!=nums[i-1])){
				int l = i+1;
				int r = nums.length-1;

				while(l<r){
					int sum = nums[l]+nums[r]+nums[i];

					if(Math.abs(target-sum)<Math.abs(min)){
						min = target-sum;
					}
					if(sum<target) l++;
					else r--;
				}
			}
		}
		return target-min;
	}
}