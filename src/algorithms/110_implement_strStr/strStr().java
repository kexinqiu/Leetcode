//朴素解法，tc：o(m*n)

class Solution {
	public int strStr(String haystack, String needle) {
		if(needle==null) return 0;
		if(needle.length()>haystack.length()) return -1;

		int count=0;

		for(int i=0;i<=haystack.length()-needle.length();i++){
			int a = i;
			for(int j=0;j<needle.length();j++){
				if(needle.charAt(j)==haystack.charAt(a)) {
					count++;
					if(count==needle.length()) return i;
					a++;
				}else{
					count = 0;
					break;
				}
			}
		}
		return -1;
	}
}