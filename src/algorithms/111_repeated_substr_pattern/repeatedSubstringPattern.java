//tc o(n*n)

class Solution {
	public boolean repeatedSubstringPattern(String s) {
		if(s==null || s.length()<=1) return false;

		int n = s.length();
		// pattern must repeat at least twice, i.e. pattern length is at most n/2
		for(int len=1;len<=n/2;len++){
			// s length must can be divided by the pattern length
			if(n%len!=0) continue;
			// pattern string
			String pattern = s.substring(0, len);
			// start index of 2nd pattern
			int start = len;
			// end index of 2nd pattern
			int end = start+len-1;

			while(end<n){
				String substr = s.substring(start, end+1);
				// failed for this pattern, try next patter
				if(!pattern.equals(substr)) break;

				start+=len;
				end+=len;
			}
			// if it past the last substring check, i will be n
			if(start==n) return true;
		}
		return false;
	}
}

