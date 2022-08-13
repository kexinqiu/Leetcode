class TrieNode {
	public boolean isEnd;
	public TrieNode[] links;
	// Initialize your data structure here.
	public TrieNode() {
		links = new TrieNode[26];
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}
	// Inserts a word into the trie.
	//tc:o(n)
	//sc:o(n)
	public void insert(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(node.links[c - 'a'] == null){
				node.links[c - 'a'] = new TrieNode();
			}
			node = node.links[c - 'a'];
		}
		node.isEnd = true;
	}
	//tc:o(n)
	//sc:o(1)
	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = searchHelper(word);
		return node != null && node.isEnd;
	}
	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode node = searchHelper(prefix);
		return node!=null;
	}

	public TrieNode searchHelper(String word){
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(node.links[c-'a']==null) return null;
			else node = node.links[c - 'a'];
		}
		return node;
	}
}
