////O(C(n,k)) = O(n!/(k! * (n-k)!)


class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), n, k, 1);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> comb, int n, int k, int start){
		if(comb.size()==k){
			res.add(new ArrayList<>(comb));
			return;
		}

		for(int i=start;i<=n;i++){
			comb.add(i);
			backtrack(res, comb, n, k, i+1);
			comb.remove(comb.size()-1);
		}

	}
}