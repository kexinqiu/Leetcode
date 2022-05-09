//tc: 最差的情况：不包含重复数字 O(N*N!)  N! permutations of a list of size N
//sc: O(N)

class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0) return res;
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtrack(res, nums, new ArrayList<>(), used);
		return res;
	}

	private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] used) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}
		//最外层的i是每一次排列的第一个数字，进入recursion后，i会逐个循环三个数
		for (int i = 0; i < nums.length; i++) {
			if(used[i] || i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;

			path.add(nums[i]);
			used[i]=true;
			backtrack(res, nums, path, used);
			//重置状态
			//i对应的是boolean array的index
			used[i]=false;
			//临时combination list的最后一个数和boolean以及原array index对应
			path.remove(path.size()-1);
		}
	}
}