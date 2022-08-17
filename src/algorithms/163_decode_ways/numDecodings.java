//dp
//首先确认base case是什么
//其次确定把问题分解为什么sub-problem
//这道题为例：
//base case是 在字符串之外设定先导0 dp[0]=1
//我们只关心「位置 i 自己能否形成独立 item 」和「位置 i 能够与上一位置（i-1）能否形成 item」，而不关心 i-1 之前的位置
//因为只有两种组合可能，1 全部为单个 2.两位数<27
//第一种情况，i是单独的item，dp[i]由i-1转移过来，f[i]=f[i−1]
//第二种情况，i和i-1共同组成item，dp[i]由i-2转移过来，f[i]=f[i−2]
// dp[i] = dp[i-1] && dp[i]=dp[i-2]

//tc:o(n)
//sc:o(n)
class Solution {
	public int numDecodings(String s) {
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		s = " " + s;
		for(int i=1;i<=n;i++){
			if(s.charAt(i)!='0'){
				dp[i] += dp[i-1];
			}
			if(i>0 && (s.charAt(i-1)=='1'|| (s.charAt(i-1)=='2' && s.charAt(i)<'7'))){
				dp[i] += dp[i-2];
			}
		}
		return dp[n];
	}
}