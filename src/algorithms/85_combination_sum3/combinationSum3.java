//O(C(9,k)) = O(9!/(k! * (9-k)!)

class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), nums, k, n, 0);
		return res;
	}


	private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] nums, int k, int remain, int start){
		if(comb.size()==k&&remain==0){
			//make a copy of the current combination
			res.add(new ArrayList<>(comb));
			return;
		}else if(comb.size()==k){
			return;
		}

		for(int i=start;i<nums.length;i++){
			if(remain-nums[i]<0) break;

			comb.add(nums[i]);
			backtrack(res, comb, nums, k, remain-nums[i], i+1);
			comb.remove(comb.size()-1);
		}
	}
}