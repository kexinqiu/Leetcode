//time complexity: O(4^N ⋅N), where N is the length of digits
//The worst-case is where the input consists of only 7s and 9s.
// In that case, we have to explore 4 additional paths for every extra digit.
// Then, for each combination, it costs up to NN to build the combination.(String object is immutable, so concanating Strings result in O(N))

//space complexity:O(N)

class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits.length()==0) return res;
		HashMap<Character, String> phoneLetters = new HashMap<>(){{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}};
		// Initiate backtracking with an empty stringbuilder and starting index of 0
		backtrack(res, phoneLetters, digits, new StringBuilder(), 0);
		return res;
	}

	private void backtrack(List<String> res, HashMap<Character, String> phoneLetters, String digits,  StringBuilder comb, int start){
		// If the comb is the same length as digits, we have a complete combination
		if(comb.length()==digits.length()){
			res.add(comb.toString());
			return;
		}
		// Get letters that the current digit maps to, and loop through them
		char digit = digits.charAt(start);
		String letter = phoneLetters.get(digit);

		for(int i=0;i<letter.length();i++){
			comb.append(letter.charAt(i));
			backtrack(res, phoneLetters, digits, comb, start+1);
			comb.deleteCharAt(comb.length() - 1);
		}
	}
}