//直接使用bfs，把每个node作为root进行便利，tc：o（n*n）
//因此我们使用topological sorting + bfs
//想象一个graph，越是中心的点越有可能组成一个最短的tree
//因此我们利用拓扑排序，不断去掉leaf node，最后留下的node就是中心node

//1.build graph with adjacency list
//2.create a queue which would be used to hold the leaf nodes
//3.run a loop until there are no more than two nodes left in the graph
//4.我们从边缘开始，先找到所有出度为1的leaf node节点，然后把所有出度为1的节点进队列，然后不断地bfs。remove the current leaf nodes from the queue. While removing the nodes, we also remove the edges that are linked to the nodes. As a consequence, some of the non-leaf nodes would become leaf nodes
//最后找到的就是两边同时向中间靠近的节点，那么这个中间节点就相当于把整个距离二分了，那么它当然就是到两边距离最小的点啦，也就是到其他叶子节点最近的节点了

//tc：o（n）n is the number of nodes in the graph
//construct a graph o(n)
//retrieve the initial leaf nodes o(n)
//BFS trimming process o(n+n)

//sc：o（n）
class Solution {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<>();
		//edge cases 如果只有一个或两个节点，那么他就是最小高度树
		if(n<=2){
			for(int i=0;i<n;i++){
				res.add(i);
			}
			return res;
		}
		//dgree of nodes  /*建立各个节点的出度表*/
		int[] degree = new int[n];
		//build the graph /*建立图关系，在每个节点的list中存储相连节点*/
		Map<Integer, List<Integer>> map = new HashMap<>();

		for(int[] e : edges){
			int n1 = e[0];
			int n2 = e[1];
			degree[n1]++;/*出度++*/
			degree[n2]++;
			if(!map.containsKey(n1)){
				map.put(n1, new ArrayList<Integer>());

			}
			if(!map.containsKey(n2)){
				map.put(n2, new ArrayList<Integer>());
			}
			map.get(n1).add(n2);/*添加相邻节点*/
			map.get(n2).add(n1);/*添加相邻节点*/
		}
		/*建立队列*/
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<degree.length;i++){/*把所有出度为1的节点，也就是叶子节点入队*/
			if(degree[i]==1) queue.add(i);
		}

		while(!queue.isEmpty()){
			res = new ArrayList<>();/*这个地方注意，我们每层循环都要new一个新的结果集合，
            这样最后保存的就是最终的最小高度树了*/

			int size = queue.size();/*这是每一层的节点的数量*/

			for(int i=0;i<size;i++){
				int curr = queue.poll();
				res.add(curr);/*把当前节点加入结果集，因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点*/

				List<Integer> neighbors = map.get(curr);
				/*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
				 * 把它们的出度都减1，因为当前节点已经不存在了，所以，
				 * 它的相邻节点们就有可能变成叶子节点*/
				for(int neighbor : neighbors){
					degree[neighbor]--;
					if(degree[neighbor]==1) queue.add(neighbor);/*如果是叶子节点我们就入队*/
				}
			}
		}
		return res;/*返回最后一次保存的list*/
	}
}