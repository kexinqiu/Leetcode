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
		int[] char_counts = new int[26];

		while(fast<s.length()){
			//increase the frequency of the current character
			char_counts[s.charAt(fast)-'A']++;

			int current_count = char_counts[s.charAt(fast)-'A'];
			//store the number of the most frequency in the substring
			max_count = Math.max(max_count, current_count);


			//if length of substring - number of times of the maximum occurring character in the substring > k , means that we can't change it to a string containing the same letter
			while((fast-slow+1-max_count)>k){
				//minus the frequency of the character at the front of the string
				char_counts[s.charAt(slow)-'A']--;
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