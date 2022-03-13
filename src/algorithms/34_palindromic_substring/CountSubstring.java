class Solution {
	public int countSubstrings(String s) {
		if(s==null || s.length()==0) return 0;

		int count = 0;

		// i is the mid point
		for(int i=0;i<s.length();i++){
			//begin with odd length
			count+=extendSubstring(s, i, i);
			//begin with even length
			count+=extendSubstring(s, i, i+1);
		}
		return count;
	}

	//expand with two pointers
	public int extendSubstring(String s, int left, int right){

		int count = 0;
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			count++;
			left--;
			right++;
		}
		return count;
	}

}