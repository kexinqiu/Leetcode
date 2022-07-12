//图中两个顶点之间的最短路径的长度，可以通过广度优先遍历得到；
//即 bfs - 最短路径

//tc : o(26*mn) m is the length of each word, n is the number of word in wordlist


class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
		Set<String> wordSet = new HashSet<>(wordList);
		if(wordSet.size()==0 || !wordSet.contains(endWord)) return 0;
		//确保beginWord不在set里
		wordSet.remove(beginWord);
		// 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		// 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
		int step = 1;
		while(!queue.isEmpty()){
			int currentSize = queue.size();
			for(int i=0;i<currentSize;i++){
				// 依次遍历当前队列中的单词
				String currentWord = queue.poll();
				if(currentWordMatching(currentWord, endWord, wordSet, queue, visited)){
					return step+1;
				}
			}
			step++;
		}
		return 0;
	}
	//依次修改currentWord字符，判断是否与endword匹配, 若匹配直接返回step+1， 若不匹配，则将同广度的匹配单词加入queue，继续找一下个
	public boolean currentWordMatching(String currentWord, String endWord, Set<String> wordSet, Queue<String> queue, Set<String> visited){
		char[] charArray = currentWord.toCharArray();
		for(int i=0;i<endWord.length();i++){
			char originChar = charArray[i];

			for(char k='a';k<='z';k++){
				if(k==originChar) continue;
				charArray[i] = k;
				String newWord = String.valueOf(charArray);
				if(wordSet.contains(newWord)){
					if(endWord.equals(newWord))
						return true;
					if(!visited.contains(newWord)) {
						queue.add(newWord);
						visited.add(newWord);
					}
				}
			}
			charArray[i] = originChar;
		}
		return false;
	}
}

//双向bfs
//已知顶点和终点，可以从起点和终点分别遍历，直到有交集
//注意： 每次要从单词量少的集合开始扩散
//这里 beginVisited 和 endVisited 交替使用，等价于单向 BFS 里使用队列，每次扩散都要加到总的 visited 里

class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
		Set<String> wordSet = new HashSet<>(wordList);
		if(wordSet.size()==0 || !wordSet.contains(endWord)) return 0;
		//确保beginWord不在set里
		wordSet.remove(beginWord);

		// 第 2 步：
		// 辅助哈希表1:从begin开始的正向搜索
		// 这里存储的是当前层搜到的节点(注意是单层的)
		Set<String> beginVisited = new HashSet<>();
		beginVisited.add(beginWord);
		// 辅助哈希表2:从endWord开始的反向搜索
		Set<String> endVisited = new HashSet<>();
		endVisited.add(endWord);
		// 标记已经搜索过的单词(正+反)
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		visited.add(endWord);

		// 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
		int step = 1;
		while(!beginVisited.isEmpty() && !endVisited.isEmpty()){
			// 优先选择小的哈希表进行扩散，考虑到的情况更少
			if(beginVisited.size()>endVisited.size()){
				Set<String> tmp = beginVisited;
				beginVisited = endVisited;
				endVisited = tmp;
			}
			// 装新一层的节点
			Set<String> nextLevel = new HashSet<>();

			for(String curr: beginVisited){
				// 依次遍历当前队列中的单词
				char[] currArray = curr.toCharArray();

				for(int i=0;i<currArray.length;i++){
					// 记住原来的currArray[i]处的字母以便还原
					char origin = currArray[i];
					// 每个字母可改变范围为'a'-'z'
					for(char k='a';k<='z';k++){
						// 原来的可以跳过
						if(k==origin) continue;
						// 替换为k
						currArray[i] = k;
						// 生成新单词
						String newWord = String.valueOf(currArray);
						// 若wordSet中能找到newWord
						if(wordSet.contains(newWord)){
							// 若相遇了,直接返回搜索节点总个数,此时的路径最短
							if(endVisited.contains(newWord)){
								return step+1;
							}
							// 没相遇且没被搜索过:继续搜索
							if(!visited.contains(newWord)){
								// newWord加入新一层接节点
								nextLevel.add(newWord);
								// 标记搜索过
								visited.add(newWord);
							}
						}
					}
					// 还原currArray[i]并进行下一个字母的搜索(因为只能改变一个字母)
					currArray[i] = origin;
				}
			}
			//nextLevel成为新的beginVisited
			beginVisited = nextLevel;
			// 一层节点搜索完毕,圈数+1
			step++;
		}
		return 0;
	}
}