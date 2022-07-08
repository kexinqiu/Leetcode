//there are two steps:
//1. move right pointer to expand the window, until we get desirable window
//2. move left pointer to contract the window, until the window ceases to be 'desirable'


class Solution {
	public String minWindow(String s, String t) {

		if(s.length()==0||t.length()==0||t.length()>s.length()) return "";

		int[] map = new int[128];

		//start表示符合最优解的substring的起始位序
		int start = 0;
		int minStart = 0;
		int end = 0;
		//count记录当前窗口中符合need要求的字符的数量,当count == need.size()时即可shrik窗口
		int count = t.length();
		//len用来记录最终窗口的长度，并且以len作比较，淘汰选出最小的substring的len
		int minLength = Integer.MAX_VALUE;

		for(char temp:t.toCharArray()){
			map[temp]++;
		}

		while(end<s.length()){
			if(map[s.charAt(end)]>0) count--;

			map[s.charAt(end)]--;
			//move the end pointer ahead
			end++;
			//shrink左边界，找符合条件的最优解
			while(count==0){

			   //因为最后需要返回substring所以既需要记录minLength， 也需要记录minStart
				if (end - start < minLength) {//不断“打擂”找满足条件的len最短值,并记录最短的子串的起始位序start
					minStart = start;
					minLength = end - start;
				}
				map[s.charAt(start)]++;
				if (map[s.charAt(start)] >= 0) count++;
				map[s.charAt(start)]++;
				//move the start pointer ahead
				start++;
			}
		}
		return minLength==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLength);

	}