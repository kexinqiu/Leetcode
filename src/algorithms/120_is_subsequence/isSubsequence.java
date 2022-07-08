//tc:o(n)
//sc o(1)
//two pointers
class Solution {
	public boolean isSubsequence(String s, String t) {

		int sP = 0;
		int tP = 0;
		int count = 0;

		while(sP<s.length()&&tP<t.length()){

			if(s.charAt(sP)==t.charAt(tP)) {
				count++;
				sP++;
			}

			tP++;

		}
		return count==s.length()?true:false;
	}
}

//follow up
//dp

class Solution {
	public boolean isSubsequence(String s, String t) {
		//考虑到  对第一个字符的处理 ，在t 之前一个空字符
		t = ' '+t;
		//对t长字符串 做预处理
		int[][] dp = new int[t.length()][26];//存储每一个位置上  a--z的下一个字符出现的位置

		for(char c='a';c<='z';c++){//依次对每个字符作处理
			int nextPos = -1;//表示接下来不会在出现该字符
			for(int i=t.length()-1;i>=0;i--){//从最后一位开始处理
				dp[i][c-'a'] = nextPos;//dp[i][c-'a']  加上外层循环  就是对每一个位置的a---z字符的处理了
				if(c==t.charAt(i)) {//表示当前位置有该字符  那么指向下一个该字符出现的位置就要被更新  为i
					nextPos = i;
				}
			}
		}
		//数据的利用 ，开始匹配
		int index = 0;
		for(char c : s.toCharArray()){
			index = dp[index][c-'a'];//因为加了' '，所以之后在处理第一个字符的时候  如果是在第一行，就会去第一行，不影响之后字符的判断
			if(index==-1) return false;
		}
		return true;
	}
}

//dp
class Solution {

	public boolean isSubsequence(String s, String t) {

		Integer sourceLen = s.length(), targetLen = t.length();
		// the source string is empty
		if (sourceLen == 0)
			return true;

		int[][] dp = new int[sourceLen + 1][targetLen + 1];
		// DP calculation, we fill the matrix column by column, bottom up
		for (int col = 1; col <= targetLen; ++col) {
			for (int row = 1; row <= sourceLen; ++row) {
				if (s.charAt(row - 1) == t.charAt(col - 1))
					// find another match
					dp[row][col] = dp[row - 1][col - 1] + 1;
				else
					// retrieve the maximal result from previous prefixes
					dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
			}
			// check if we can consume the entire source string,
			// with the current prefix of the target string.
			if (dp[sourceLen][col] == sourceLen)
				return true;
		}

		// matching failure
		return false;
	}
}
