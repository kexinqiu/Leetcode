//tc: O(2^N * N)
//SC: O(N)

class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		//must sort the array
		Arrays.sort(nums);
		backtrack(res, nums, new ArrayList<Integer>(), 0);
		return res;
	}

	private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> comb, int start){
		//此题非常特殊，所有路径都应该加入结果集，所以不存在结束条件
		////加入结果集
		res.add(new ArrayList<Integer>(comb));
		//i+1时，同level的加入combination
		for(int i=start;i<nums.length;i++){
			//skip duplication
			if(i>start&&nums[i]==nums[i-1]) continue;
			comb.add(nums[i]);
			////递归进入下一层，注意i+1
			backtrack(res, nums, comb, i+1);
			//回溯
			comb.remove(comb.size()-1);
		}
	}
}