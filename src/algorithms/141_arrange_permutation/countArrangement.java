//tc: o(n!)
//sc: o(n)

class Solution {
	int count = 0;

	public int countArrangement(int n) {
		if(n==1)  return 1;

		boolean[] used = new boolean[n+1];

		backtracking(n, 1, used);

		return count;
	}

	public void backtracking(int n, int pos, boolean[] used){

		if(pos>n) {
			count++;
			return;
		}

		for(int i=1;i<=n;i++){//i is perm[pos], pos is the index
			if(!used[i] && (i%pos==0 || pos%i==0)){
				used[i]=true;
				backtracking(n, pos+1, used);
				used[i]=false;
			}
		}
	}
}