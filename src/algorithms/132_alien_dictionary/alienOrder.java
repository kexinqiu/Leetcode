//1.Extracting dependency rules from the input.
//2.Representing that information in adjacency list
//3.Topologically sorting the graph nodes


class Solution {
	public String alienOrder(String[] words) {
		//1.create list an
		Map<Character, List<Character>> adjList = new HashMap<>();
		Map<Character, Integer> inDegree = new HashMap<>();
		for(String s : words){
			for(char c : s.toCharArray()){
				inDegree.put(c, 0);
				adjList.put(c, new ArrayList<Character>());
			}
		}

		//2.find the rules/find all edges
		for(int i=0;i<words.length-1;i++){
			String word1 = words[i];
			String word2 = words[i+1];

			if(word1.length()>word2.length() && word1.startsWith(word2)) return "";
			for(int j=0;j<Math.min(word1.length(), word2.length());j++){
				if(word1.charAt(j)!=word2.charAt(j)) {
					adjList.get(word1.charAt(j)).add(word2.charAt(j));
					inDegree.put(word2.charAt(j), inDegree.get(word2.charAt(j))+1);
					break;
				}
			}
		}

		//3.queue-Breadth-first search
		StringBuilder sb = new StringBuilder();
		Queue<Character> queue = new LinkedList<>();
		for(Character c : inDegree.keySet()){
			if(inDegree.get(c)==0) queue.offer(c);
		}

		while(!queue.isEmpty()){
			char c = (char)queue.poll();
			sb.append(c);

			for(char adjC: adjList.get(c)){
				inDegree.put(adjC, inDegree.get(adjC)-1);
				if(inDegree.get(adjC)==0) queue.offer(adjC);
			}
		}

		if(sb.length()<inDegree.size()) return "";

		return sb.toString();
	}
}