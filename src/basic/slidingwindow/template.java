//template
class template {
	public int findSubstring(String s) {
		int[] map = new int[128];
		// check whether the substring is valid
		int counter = 0;
		//two pointers
		int start = 0;
		int end = 0;

		int len;

		//initalize the array here
		for () {
		}

		while (end < s.size()) {

			if (map[s.charAt(end)]>0) {  /* modify counter here */ }
			map[s.charAt(end)]++;
			end++;

			while (/* counter condition */) {

				// update len here if finding minimum

				//increase begin to make it invalid/valid again

				if (map[s.charAt(start)] > 0) { /*modify counter here*/ }
				map[s.charAt(start)]++;
				start++;
			}
			/* update len here if finding maximum*/
		}
		return len;
	}
}

// minWindow 76
class Solution {
	public String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) return "";

		int[] map = new int[128];

		//start表示符合最优解的substring的起始位序
		int start = 0;
		int minStart = 0;
		int end = 0;
		//count记录当前窗口中符合need要求的字符的数量,当count == need.size()时即可shrik窗口
		int count = t.length();
		//len用来记录最终窗口的长度，并且以len作比较，淘汰选出最小的substring的len
		int minLength = Integer.MAX_VALUE;

		for (char temp : t.toCharArray()) {
			map[temp]++;
		}

		while (end < s.length()) {
			if (map[s.charAt(end)] > 0) count--;

			map[s.charAt(end)]--;
			//move the end pointer ahead
			end++;
			//shrink左边界，找符合条件的最优解
			while (count == 0) {
				if (end - start < minLength) {//不断“打擂”找满足条件的len最短值,并记录最短的子串的起始位序start
					minStart = start;
					minLength = end - start;
				}

				if (map[s.charAt(start)] >= 0) count++;

				map[s.charAt(start)]++;
				//move the start pointer ahead
				start++;
			}
		}
		return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
	}
}

//3. Longest Substring Without Repeating Characters
class Solution {
	public int lengthOfLongestSubstring(String s) {

		int[] map = new int[128];

		int start = 0;
		int end = 0;
		//check if the substring is valid
		int counter = 0;
		int maxLen = 0;

		//expand right pointer
		while(end<s.length()){
			if(map[s.charAt(end)]>0) counter++;
			map[s.charAt(end)]++;

			//when the substring is not valid
			while(counter>0){
				//如果>1，说明是重复的char，那么将其跳过后，substring又符合条件
				if(map[s.charAt(start)]>1) counter--;
				map[s.charAt(start)]--;
				start++;
			}

			maxLen = Math.max(maxLen, end-start+1);

			//move ahead
			end++;
		}
		return maxLen;
	}
}

//424. Longest Repeating Character Replacement
class Solution {
	public int characterReplacement(String s, int k) {
		//sliding window
		//we need to expand the window, until there is no time to change diffrent characters
		//then we need to move the slow pointer to right and expand again
		int slow = 0;
		int fast = 0;
		int max_length = 0;
		int max_count = 0;
		//this array stores the frequency of characters
		//there are 26 upercase letters in total
		int[] char_counts = new int[128];

		while(fast<s.length()){
			//increase the frequency of the current character
			char_counts[s.charAt(fast)]++;

			int current_count = char_counts[s.charAt(fast)];
			//store the number of the most frequency in the substring
			max_count = Math.max(max_count, current_count);


			//if length of substring - number of times of the maximum occurring character in the substring > k , means that we can't change it to a string containing the same letter
			while((fast-slow+1-max_count)>k){
				//minus the frequency of the character at the front of the string
				char_counts[s.charAt(slow)]--;
				//move the slow pointer to right
				slow++;
			}

			max_length = Math.max(max_length, (fast-slow+1));
			//move right
			fast++;
		}
		return max_length;
	}
}


//Longest Substring - at most K distinct characters
class Solution{
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] map = new int[256];
		int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

		while (end < s.length()) {
			char c1 = s.charAt(end);
			if (map[c1] == 0) counter++;
			map[c1]++;
			end++;

			while (counter > k) {
				char c2 = s.charAt(start);
				if (map[c2] == 1) counter--;
				map[c2]--;
				start++;
			}

				maxLen = Math.max(maxLen, end - start);
			}

		return maxLen;
	}
}

//Longest Substring - at most 2 distinct characters
class Solution{
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] map = new int[128];
		int start = 0, end = 0, maxLen = 0, counter = 0;

		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] == 0) counter++;
			map[c1]++;
			end++;

			while (counter > 2) {
				final char c2 = s.charAt(start);
				if (map[c2] == 1) counter--;
				map[c2]--;
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}
}

//209. Minimum Size Subarray Sum
class Solution {
	public int minSubArrayLen(int target, int[] nums) {

		int start = 0;
		int end = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;

		while(end<nums.length){
			sum += nums[end];
			end++;

			while(sum>=target){
				minLen = Math.min(minLen, end-start);
				sum -= nums[start];
				start++;
			}
		}
		return minLen==Integer.MAX_VALUE?0:minLen;
	}
}