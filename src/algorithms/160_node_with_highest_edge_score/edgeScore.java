//hashmap
//tc:o(n)
//sc:o(n)
//Pay attention to the overflow error  10^5 * 10 ^5 > 2^31 -1
class Solution {
	public int edgeScore(int[] edges) {

		Map<Integer, List<Integer>> graph = new HashMap<>();
		int res = -1;
		//to avoid overflow we will take long size
		long max = -1;

		for(int i=0;i<edges.length;i++){
			if(!graph.containsKey(edges[i])) graph.put(edges[i], new ArrayList<Integer>());
			graph.get(edges[i]).add(i);
		}

		for(int k : graph.keySet()){
			//to avoid overflow we will take long size
			long sum = 0;
			List<Integer> tmp = graph.get(k);
			for(int n : tmp){
				sum += n;
			}
			if(max<sum) {
				res = k;
				max = sum;
			}

			else if(max==sum){
				if(res>k)  res=k;
			}
		}
		return res;
	}
}


//array
class Solution {
	public int edgeScore(int[] edges) {
		int n = edges.length;

		int score_index = -1;
		long max_score = -1;

		long[] edge_score = new long[n];

		for(int i=0;i<n;i++){
			edge_score[edges[i]] += i;
		}

		for(int i=0;i<edge_score.length;i++){
			if(edge_score[i]>max_score){
				max_score = edge_score[i];
				score_index = i;
			}
		}
		return score_index;
	}
}