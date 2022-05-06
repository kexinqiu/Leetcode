//think about this problem as a dfs problem. Go deep untill there is no more element and
//move to next branch

//time complexity: O(N^(T/M+1))
// Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
// The maximal depth of the tree, would be T/M
// the maximal number of nodes in N-ary tree of T/M height would N^(T/M+1)

//space complexity: 0(T/M)

class Solution {
	private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] candidates, int remain, int start){

		if(remain==0) {
			// make a deep copy of the current combination
			res.add(new ArrayList<>(comb));
			return;
		}else if(remain<0){
			// exceed the scope, stop exploration.
			return;
		}

		for(int i=start;i<candidates.length;i++){
			// add the number into the combination
			comb.add(candidates[i]);
			// not i + 1 because we can reuse same elements
			backtrack(res, comb, candidates, remain-candidates[i], i);
			// backtrack, remove the last number from the combination
			comb.remove(comb.size()-1);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}
}

//optimize
//如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，同样搜索不到结果
class Solution {
	private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] candidates, int remain, int start){

		if(remain==0) {
			// make a deep copy of the current combination
			res.add(new ArrayList<>(comb));
			return;
		}

		for(int i=start;i<candidates.length;i++){
			// 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
			if(remain-candidates[i]<0) break;

			// add the number into the combination
			comb.add(candidates[i]);
			// not i + 1 because we can reuse same elements
			backtrack(res, comb, candidates, remain-candidates[i], i);
			// backtrack, remove the last number from the combination
			comb.remove(comb.size()-1);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		//sort the array
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}
}