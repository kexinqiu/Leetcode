//time complexity: O(2^N)
//The number of combinations of a list of size N is 2^N
//space complexity: O(N)

class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] candidates, int remain, int start){
		if(remain==0){
			res.add(new ArrayList<Integer>(comb));
			return;
		}

		for(int i=start;i<candidates.length;i++){
			// 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
			if(remain-candidates[i]<0) break;
			//skip duplicates
			// 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
			//i>start 保证了同一层级不会出现两次同样的
			if(i>start&&candidates[i]==candidates[i-1]) continue;

			comb.add(candidates[i]);
			//// 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
			backtrack(res, comb, candidates, remain-candidates[i], i+1);
			comb.remove(comb.size()-1);
		}
	}
}