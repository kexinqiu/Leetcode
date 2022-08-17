//s1=original string s2=stretchy;
//Rule 1: Compressed(word1) must be the same as compressed word2 [what is compressed word? Remove all duplicate characters in a word and keep the original order of the rest characters, you will get a compressed word]
//rule 2: if s1.length()>=3  s1.length()>=s2.length()
//        if s1.length()<3   s1.length()==s2.length()

//tc:O(n*max(len(s), max(len(word in words array)))) where n is the length of words array
//sc:o(1)
class Solution {
	public int expressiveWords(String s, String[] words) {
		int count=0;

		for(String word : words){
			if(isStretchy(s, word)) count++;
		}

		return count;
	}

	//two pointers
	private boolean isStretchy(String s, String stretchy){
		if(stretchy.length()>s.length()) return false;

		int i=0;
		int j=0;

		while(i<s.length() && j<stretchy.length()){
			//check rule 1
			if(s.charAt(i)!=stretchy.charAt(j)) return false;

			int sRepeated = getRepeatedLength(s, i);
			int streRepeated = getRepeatedLength(stretchy, j);
			//check rule 2
			if((sRepeated>=3 && sRepeated<streRepeated) || (sRepeated<=2 && sRepeated!=streRepeated)) return false;

			i+=sRepeated;
			j+=streRepeated;
		}

		return i==s.length() && j==stretchy.length();

	}

	private int getRepeatedLength(String s, int start){
		int end = start;
		while(end<s.length() && s.charAt(start)==s.charAt(end)){
			end++;
		}
		return end-start;
	}
}