
class Solution {
	public boolean isAnagram(String s, String t) {

		if(s.length() != t.length() || s.length() <1) return false;

		//char_count store the number of characters, and the largest index is 'z'-'a'=26
		int[] char_count = new int[26];

		//tarverse s and t
		for(int i=0; i<s.length();i++){
			//get the index of characters, and store the amount of the characters
			//for a same character, increase the amount in s and decrease the amount in t
			char_count[s.charAt(i)-'a'] ++;
			char_count[t.charAt(i)-'a'] --;
		}

		//if a character has same amount both in s and t, then the number should be 0
		for(int count:char_count){
			if(count!=0) return false;
		}
		return true;
	}
}

//hashmap
class Solution {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length() || s.length()<1) return false;

		HashMap<Character, Integer> map = new HashMap<>();

		for(int i=0;i<s.length();i++){
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
		}

		for(char c : map.keySet()){
			if(map.get(c)!=0) return false;
		}
		return true;
	}
}