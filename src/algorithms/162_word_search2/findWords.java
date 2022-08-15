//backtracking
//tc:o()
class Solution {
	int row;
	int col;
	boolean[][] visited;
	int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	Set<String> wordsSet;
	List<String> res;


	public List<String> findWords(char[][] board, String[] words) {
		row = board.length;
		col = board[0].length;
		visited = new boolean[row][col];
		wordsSet = new HashSet<String>();
		res = new ArrayList<>();

		for(String s : words){
			wordsSet.add(s);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				visited[i][j] = true;
				sb.append(board[i][j]);
				backtracking(board, i, j, sb);
				visited[i][j]=false;
				sb.deleteCharAt(sb.length()-1);
			}
		}
		return res;

	}

	private void backtracking(char[][] board, int i, int j, StringBuilder sb){
		if(sb.length()>10) return;
		if(wordsSet.contains(sb.toString())) {
			res.add(sb.toString());
			wordsSet.remove(sb.toString());
		}

		for(int[] d:directions){
			int newRow = i + d[0];
			int newCol = j + d[1];
			if(newRow>=0 && newRow<row && newCol>=0 && newCol<col && visited[newRow][newCol]==false){
				visited[newRow][newCol]=true;
				sb.append(board[newRow][newCol]);
				backtracking(board, newRow, newCol, sb);
				//reset
				visited[newRow][newCol]=false;
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
}


//backtracking + trie
class Solution {
	int row;
	int col;
	int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	TrieNode root;
	List<String> res;


	public List<String> findWords(char[][] board, String[] words) {
		row = board.length;
		col = board[0].length;
		root = buildeTrieNode(words);
		res = new ArrayList<>();

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				backtracking(board, i, j, root);
			}
		}
		return res;
	}

	private void backtracking(char[][] board, int i, int j, TrieNode p){
		char c = board[i][j];
		if(p.links[c-'a']==null) return;
		p=p.links[c-'a'];
		if(p.word!=null) {
			res.add(p.word);// found one
			p.word = null;// de-duplicate
		}

		board[i][j]='#';// de-duplicate
		for(int[] d : directions){
			int newI = i + d[0];
			int newJ = j + d[1];
			if(newI>=0 && newI<row && newJ>=0 && newJ<col && board[newI][newJ]!='#'){
				backtracking(board, newI, newJ, p);
			}
		}
		board[i][j]=c;// reset
	}

	private TrieNode buildeTrieNode(String[] words){
		TrieNode root = new TrieNode();
		for(String w : words){
			TrieNode p = root;
			for(char c : w.toCharArray()){
				if(p.links[c-'a']==null) p.links[c-'a'] = new TrieNode();
				p = p.links[c-'a'];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode{
		String word;
		TrieNode[] links = new TrieNode[26];
	}
}