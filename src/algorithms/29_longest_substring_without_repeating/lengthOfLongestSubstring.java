import java.util.HashSet;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		//sliding window
		//slow pointer stay at the beginning, fast pointer move and expand the window
		//make sure no character is same in the window
		//we need to find the longest window

		HashSet<Character> set = new HashSet<>();

		int slow = 0;
		int fast = 0;
		int max = 0;

		while(fast<s.length()){
			//check if character in fast pointer is in the hash set or not, if not, great, add it to the hash set, move fast pointer forward and update the max length,
			if(!set.contains(s.charAt(fast))){
				set.add(s.charAt(fast));
				fast++;
				max = Math.max(max,set.size());
			}else{
				// otherwise, delete from the head by using a slow pointer and move slow pointer forward
				set.remove(s.charAt(slow));
				slow++;
			}
		}
		return max;
	}
}

//2.
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
            while(counter>0) {
				//如果>1，说明是重复的char，那么将其跳过后，substring又符合条件
				if (map[s.charAt(start)] > 1) counter--;
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

//3.
//sliding window
class Solution {
	public int lengthOfLongestSubstring(String s) {

		if (s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}