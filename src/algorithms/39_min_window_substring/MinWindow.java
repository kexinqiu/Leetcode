import java.util.HashMap;
class Solution {
	public String minWindow(String s, String t) {
		//there are two steps:
		//1. move right pointer to expand the window, until we get desirable window
		//2. move left pointer to contract the window, until the window ceases to be 'desirable'


		if(t.length()==0 || s.length()==0) return "";
		//// Dictionary which keeps a count of all the unique characters in t.
		Map<Character, Integer> targetStr = new HashMap<Character, Integer>();
		for(int i=0;i<t.length();i++){
			int count = targetStr.getOrDefault(t.charAt(i), 0);
			targetStr.put(t.charAt(i), count+1);
		}
		// Number of unique characters in t, which need to be present in the desired window.
		int required = targetStr.size();
		//number of unique character in s
		int current = 0;
		// Dictionary which keeps a count of all the unique characters in the current window.
		Map<Character, Integer> searchingStr = new HashMap<Character, Integer>();
		//left and right pointer
		int l=0;
		int r=0;
		//this array stores the shortest length of window , the index of left and right pointer
		int[] ans = {-1,0,0};

		while(r<s.length()){

			char c = s.charAt(r);
			// Add one character pointed by right pointer from the right to the window
			int searchingCount = searchingStr.getOrDefault(c,0) ;
			searchingStr.put(c, searchingCount+1);
			// If the frequency of the current character added equals to the
			// desired count in t then increment the formed count by 1.
			if(targetStr.containsKey(c) && searchingStr.get(c).intValue()==targetStr.get(c).intValue()){
				current++;
			}
			// Try and contract the window till the point where it ceases to be 'desirable'.
			while(l<=r && current==required){
				// Save the smallest window until now.
				if(ans[0]==-1 || ans[0]>r-l+1){
					ans[0]=r-l+1;
					ans[1]=l;
					ans[2]=r;
				}

				c = s.charAt(l);
				// The character at the position pointed by the
				// `Left` pointer is no longer a part of the window.
				searchingStr.put(c, searchingStr.get(c)-1);

				if(targetStr.containsKey(c) && searchingStr.get(c).intValue()<targetStr.get(c).intValue()){
					current --;
				}
				// Move the left pointer ahead, this would help to look for a new window.
				l++;
			}
			// Keep expanding the window once we are done contracting.
			r++;
		}
		return ans[0]>-1?s.substring(ans[1], ans[2]+1):"";
	}
}