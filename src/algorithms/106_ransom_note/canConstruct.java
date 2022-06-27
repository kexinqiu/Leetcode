//tc: o(n)+o(m)+0(n)=0(m)  n is the number of characters in ransom, m is the number of characters in magazine
//sc: o(k) k=26
class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		Map<Character, Integer> noteMap = new HashMap<>();
		Map<Character, Integer> magazineMap = new HashMap<>();

		for(char c : ransomNote.toCharArray()){
			noteMap.put(c, noteMap.getOrDefault(c, 0)+1);
		}

		for(char c : magazine.toCharArray()){
			magazineMap.put(c, magazineMap.getOrDefault(c, 0)+1);
		}

		for(char c : noteMap.keySet()){
			if(!magazineMap.containsKey(c)) return false;
			else{
				if(magazineMap.get(c)<noteMap.get(c)) return false;
			}
		}

		return true;
	}
}


//tc: 0(m+n)  n is the number of characters in ransom, m is the number of characters in magazine
//sc: o(k) k=26
class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		int[] cnt = new int[26];

		for(char c : magazine.toCharArray()){
			cnt[c-'a']++;
		}

		for(char c : ransomNote.toCharArray()){
			cnt[c-'a']--;
			if(cnt[c-'a']<0) return false;
		}

		return true;
	}
}
