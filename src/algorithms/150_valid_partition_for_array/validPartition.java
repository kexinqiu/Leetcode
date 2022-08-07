class Solution {
	public boolean validPartition(int[] nums) {

		boolean[] valid = new boolean[nums.length];
		int n = nums.length;

		//base
		valid[0] = false;

		if(nums[0]==nums[1]) valid[1]=true;
		if(n==2) return valid[1];

		if(nums[0]==nums[1] && nums[1]==nums[2]) valid[2]=true;
		if(nums[0]-nums[1]==-1 && nums[1]-nums[2]==-1) valid[2]=true;

		if(n==3) return valid[2];

		for(int i=3;i<n;i++){
			if(nums[i]==nums[i-1] && valid[i-2]) valid[i] = true;
			if(nums[i]==nums[i-1] && nums[i-1]==nums[i-2] && valid[i-3]) valid[i]=true;
			if(nums[i]-nums[i-1]==1 && nums[i-1]-nums[i-2]==1 && valid[i-3]) valid[i]=true;
		}
		return valid[n-1];

	}
}