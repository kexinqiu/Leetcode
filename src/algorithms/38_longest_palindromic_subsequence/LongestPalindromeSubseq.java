public class Solution {

	public int longestPalindromeSubseq(String s) {
		//dp[i][j] stores the length of the longest palindromic subsequence in s[i...j]
		//i is the start index, j is the end index
		int[][] dp = new int[s.length()][s.length()];
		//traverse from right to left, from short length to long length
		//so that we can use the cache
		//i is the start index, from right to left
		for (int i = s.length() - 1; i >= 0; i--) {
			//if start index is equal to end index, means that the longest length is 1
			dp[i][i] = 1;
			//j is the end index, from short length to long length
			//j starts from i+1
			for (int j = i+1; j < s.length(); j++) {
				//if the characters at both ends are equal,  we add up 2
				//and shrink our window i+1,j-1, whose length has been stored
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] + 2;
					//if the characters at both ends are not equal, we need shrink our window
				} else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		//get the max length
		return dp[0][s.length()-1];
	}
}