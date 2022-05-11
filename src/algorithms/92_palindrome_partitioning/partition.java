//tc: O(N*2^N)
//For each character in the string we have 2 choices to create new palindrome substrings,
// one is to join with previous substring (for(...end++))
// and another is to start a new palindrome substring (dfs(..end+1..)).
// Thus in the worst case there are 2^N palindrome substrings.
// Each substring will take O(N) time to check if it's palindrome and O(N) time to
// generate substring from start to end indexes.

//sc: O(N), where N is the length of the string s
//This space will be used to store the recursion stack.
// For s = aaa, the maximum depth of the recursive call stack is 3 which is equivalent to N.

class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if(s.length()==0) return res;
		backtrack(res, s, new ArrayList<String>(), 0);
		return res;

	}
	private void backtrack(List<List<String>> res, String s, List<String> currentList, int start){
		if(start>=s.length()){
			res.add(new ArrayList<>(currentList));
		}
		for(int end=start;end<s.length();end++){
			// add current substring in the currentList
			if(isPalindrome(s, start, end)){
				currentList.add(s.substring(start, end+1));
				backtrack(res, s, currentList, end+1);
				// backtrack and remove the current substring from currentList
				currentList.remove(currentList.size()-1);
			}
		}
	}
	private boolean isPalindrome(String s, int left, int right){
		while(left<right){
			if(s.charAt(left)!=s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}

//backtracking with dp
//tc: O(N*2^N)
//sc: O(N*N)
//The recursive call stack would require NN space as in Approach 1.
//Additionally, we also use 2 dimensional array dp of size N*N .
class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if(s.length()==0) return res;
		boolean[][] dp = new boolean[s.length()][s.length()];
		backtrack(res, s, new ArrayList<String>(), dp, 0);
		return res;

	}

	private void backtrack(List<List<String>> res, String s, List<String> currentList, boolean[][] dp, int start){
		if(start>=s.length()){
			res.add(new ArrayList<>(currentList));
		}
		for(int end=start;end<s.length();end++){

			if(s.charAt(start)==s.charAt(end) && (end-start<=2||dp[start+1][end-1])){
				dp[start][end]=true;
				currentList.add(s.substring(start, end+1));
				backtrack(res, s, currentList, dp, end+1);
				currentList.remove(currentList.size()-1);
			}
		}
	}
}