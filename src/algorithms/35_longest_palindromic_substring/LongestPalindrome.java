//中心扩散
//tc o(n*n)
//sc:o(1)

class Solution {
	int maxLen;
	int start, end;

	public String longestPalindrome(String s) {
		if(s==null || s.length()==0) return "";
		maxLen = 0;
		//expand from the midpoint, return the length of a palindrome
		for(int i=0;i<s.length();i++){
			//奇数字符串
			extendPalindrome(s, i, i);
			//偶数字符串
			extendPalindrome(s, i, i+1);

		}
		return s.substring(start, end+1);

	}

	public void extendPalindrome(String s, int left, int right){

		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right) ) {
			left--;
			right++;
		}

		if(maxLen<right-left-1){
			maxLen = right-left-1;
			start = left+1;
			end = right-1;
		}
	}
}

//dp