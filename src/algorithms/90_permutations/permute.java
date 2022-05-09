//tc: O(N*N!)  N! permutations of a list of size N
//sc: O(N)

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0) return res;
		//not necessary
		Arrays.sort(nums);
		backtrack(res, nums, new ArrayList<>(), 0);
		return res;
	}

	private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> path, int depth) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(path.contains(nums[i])) continue;
			path.add(nums[i]);
			backtrack(res, nums, path, depth + 1);
			//重置状态
			path.remove(path.size()-1);
		}
	}
}

//判断数字是否使用过
class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0) return res;
		//not necessary
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

		for (int i = 0; i < nums.length; i++) {
			if(used[i]) continue;
			path.add(nums[i]);
			used[i] = true;
			backtrack(res, nums, path, used);
			//重置状态
			used[i]=false;
			path.remove(path.size()-1);
		}
	}
}