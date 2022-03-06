import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList();
		//since the anagrams has same characters
		//sorted string is the key of hashmap, and put all strings having same characters in list as the value of hashmap
		Map<String, List<String>> hashmap = new HashMap<>();

		for(String current : strs){
			//convert string into char array
			char[] characters = current.toCharArray();
			//sort the char array
			Arrays.sort(characters);
			//convert the sorted char array to string
			String sorted_str = new String(characters);
			//if hashmap doesn'y contain the sorted string, then put the key-value pair into hashmap. the sorted string is the key, and the list is the value contains all strings with same letters
			if(!hashmap.containsKey(sorted_str)){
				hashmap.put(sorted_str, new ArrayList<>());
			}
			//if the hashmap already has the sorted string, add current string into it
			hashmap.get(sorted_str).add(current);
		}

		result.addAll(hashmap.values());
		return result;
	}
}