class Solution {
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> list = new LinkedList();

		for(int i=0; i<nums.length-2; i++){
			//skip duplication
			if(i==0 || (i>0 && nums[i] != nums[i-1])){
				int target = 0 - nums[i];

				int l = i + 1;
				int r = nums.length-1;

				while(l<r){

					int sum = nums[l]+nums[r];

					if(sum<target) l++;
					else if(sum>target) r--;
					else {
						//convert array to list
						list.add(Arrays.asList(nums[i], nums[l], nums[r]));
						//skip duplication
						while(l<r && nums[l]==nums[l+1]) l++;
						while(l<r && nums[r]==nums[r-1]) r--;
						//move two pointers
						l++;
						r--;
					}
				}
			}
		}
		return list;
	}
}