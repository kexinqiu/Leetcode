class Solution {
	class TrieNode {
		private TrieNode[] children;
		private int wordIndex = -1;
		private List<Integer> restIsPalindrome;

		public TrieNode() {
			children = new TrieNode[26];
			restIsPalindrome = new ArrayList<>();
		}
	}

	TrieNode root = new TrieNode();
	List<List<Integer>> res = new ArrayList<>();
	int len;

	public List<List<Integer>> palindromePairs(String[] words) {
		len = words.length;

		for (int i = 0; i < len; i++) {
			insert(words[i], i);
		}

		for (int i = 0; i < len; i++) {
			search(words[i], i);
		}

		return res;
	}

	public void search(String word, int wordIndex) {
		char[] chs = word.toCharArray();
		TrieNode curr = root;

		//第一种情况 abcll cba ： 第一个string的后面包含palindrome
		//正序搜索
		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			//第一种情况 abc llcba ： 第一个string的后面包含palindrome
			if (curr.wordIndex != -1 && isPalindrome(chs, i, chs.length-1)) {
				res.add(Arrays.asList(wordIndex, curr.wordIndex));
			}

			if(curr.children[c - 'a'] == null) return;
			curr = curr.children[c - 'a'];

		}

		//第二种情况 abcll cba ： 第二个string的前面包含palindrome
		for (int j : curr.restIsPalindrome) {
			res.add(Arrays.asList(wordIndex, j));
		}

		//第三种情况 abc  cba ： 两个string互为palindrome
		if (curr.wordIndex != -1 && wordIndex != curr.wordIndex) {
			res.add(Arrays.asList(wordIndex, curr.wordIndex));
		}

	}

	public void insert(String word, int wordIndex) {
		char[] chs = word.toCharArray();
		TrieNode curr = root;

		//逆序保存
		for (int i = chs.length - 1; i >= 0; i--) {
			char c = chs[i];

			if (isPalindrome(chs, 0, i)) {
				curr.restIsPalindrome.add(wordIndex);
			}

			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}

			curr = curr.children[c - 'a'];
		}
		curr.wordIndex = wordIndex;

	}

	private boolean isPalindrome(char[] chs, int l, int r) {
		while (l < r) {
			if (chs[l++] != chs[r--]) return false;
		}
		return true;
	}
}