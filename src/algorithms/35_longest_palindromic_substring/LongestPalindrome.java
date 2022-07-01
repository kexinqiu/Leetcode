//中心扩散
//tc o(n*n)
//sc:o(1)

class Solution {
	public String longestPalindrome(String s) {
		if(s==null || s.length()==0) return "";

		int start=0;
		int end=0;
		//expand from the midpoint, return the length of a palindrome
		for(int i=0;i<s.length();i++){
			//奇数字符串
			int len1 = extendPalindrome(s, i, i);
			/偶数字符串
			int len2 = extendPalindrome(s, i, i+1);
			//get the length of longest palindrome
			int max_len = Math.max(len1, len2);
			//get the index of the longest palindrome
			if(max_len>end-start+1){
				start = i - (max_len-1)/2;
				end = i + max_len/2;
			}
		}
		return s.substring(start, end+1);

	}

	public int extendPalindrome(String s, int left, int right){
		int max_length = 0;

		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right) ) {
			max_length = right-left+1;
			left--;
			right++;
		}
		return max_length;
	}
}

//dp