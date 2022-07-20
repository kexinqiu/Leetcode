package basic.graph;
//template


//1.bfs
class Solution {

	// 节点访问标识,访问过的节点无需访问（剪枝）
	int[][] visited = new int[m][n];
	// 队列初始化
	Queue<Node> queue = new LinkedList();

	// 【第1步】将起点加入队列, 非空进入循环
	queue.add(第一个数据);

	while(!queue.isEmpty()){
		// 【第2步】 获取当前队列长度即同一层级（辈分）节点个数，并遍历
		int size = queue.size(); // 一定要先获取，queue后面要加入下一层级节点
		for (int i = 0; i < size; i++) {
			// 【第3步】 对同一层级节点逐个寻找下一层有效**路径节点**，找到目标直接返回结果终止搜索。
			Node node = queue.poll();
			// 下一层节点 比如网格上下左右移动
			Node nextNode = node.x + xj;
			//  1. 不符合要求的下一层节点直接过滤（比如越界、已经被visited[][]标记访问了）
			//  2. 找到目标节点 直接返回结果
			//  3. 符合要求的下一层节点放入队列
			queue.offer(nextNode);
		}
	}
	// 【第4步】 BFS搜索完成没找到结果，返回-1
	return -1;
}

//	2.dijkstra
//tc : o((v+e) logv)
class Solution {
	// Adjacency list
	Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

	private void dijkstra(int[] signalReceivedAt, int source, int n) {
		//局部最优，每次选time更少的
		Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>(Comparator.comparing(p->p.getKey()));

		pq.add(new Pair(0, source));

		// Time for starting node is 0
		signalReceivedAt[source] = 0;

		while (!pq.isEmpty()) {
			Pair<Integer, Integer> topPair = pq.remove();

			int currNode = topPair.getValue();
			int currNodeTime = topPair.getKey();

			if (currNodeTime > signalReceivedAt[currNode]) {
				continue;
			}

			if (!adj.containsKey(currNode)) {
				continue;
			}

			// Broadcast the signal to adjacent nodes
			for (Pair<Integer, Integer> edge : adj.get(currNode)) {
				int time = edge.getKey();
				int neighborNode = edge.getValue();

				// Fastest signal time for neighborNode so far
				// signalReceivedAt[currNode] + time :
				// time when signal reaches neighborNode
				if (signalReceivedAt[neighborNode] > currNodeTime + time) {
					signalReceivedAt[neighborNode] = currNodeTime + time;
					pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
				}
			}
		}
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		// Build the adjacency list
		for (int[] time : times) {
			int source = time[0];
			int dest = time[1];
			int travelTime = time[2];

			List tmp = adj.getOrDefault(src, new ArrayList<>());
			tmp.add(new Pair(signalTime, des));
			adj.put(src, tmp);
		}

		int[] signalReceivedAt = new int[n + 1];
		Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

		dijkstra(signalReceivedAt, k, n);

		int answer = Integer.MIN_VALUE;
		//注意要从1开始，因为0不存在
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, signalReceivedAt[i]);
		}

		// INT_MAX signifies atleat one node is unreachable
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
}


//3.floyd - DP
//tc: o(v^3)
//basic template:
class Basic{
	void Floyd(int n, int graph[][], int Path[][]){
		int i, j ,k;
		int[][] dist = new int[n][n];

		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				dist[i][j] = graph[i][j];
				//记录中转点，大部分题目不需要这步
				Path[i][j] = -1;
			}
		}
		//枚举中转点-枚举起点-枚举终点-松弛relax操作
		for(k=0;k<n;k++){
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						Path[i][j] = k;
					}
				}
			}
		}
	}
}

//leetcode 743
//tc o（n^3）
//sc o(n^3)
class Solution {
	public int networkDelayTime(int[][] times, int n, int k) {
		// 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
		int[][] adj = new int[n+1][n+1];

		// 初始化邻接矩阵
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				adj[i][j] = adj[j][i] = i == j ? 0 : Integer.MAX_VALUE;
			}
		}
		// 存图
		for (int[] t : times) {
			int u = t[0], v = t[1], c = t[2];
			adj[u][v] = c;
		}
		// 最短路
		floyd(adj, n);
		// 遍历答案
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, adj[k][i]);
		}
		return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
	}
	void floyd(int[][] adj, int n) {
		// floyd 基本流程为三层循环：
		// 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
		for (int p = 1; p <= n; p++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][p] + adj[p][j]);
				}
			}
		}
	}
}


//4.bellman ford - DP
//tc: o(VE)

//basic template
//1)set every entry in D to Integer.MAX_VALUE
//2)set D[S] = 0;
//3)relax each edge V-1 times
class Edge {
	int from, to, cost;
	Edge(int a, int b, int c) {
		this.from = a;
		this.to = b;
		this.cost = c;
	}
}

class Basic{
	public void bellmanFord(int[][] graph, int n, int start){
		//all edges list
		List<Edge> edges =new ArrayList<>();

		for(int[] g : graph){
			edges.add(new Edge(g[0], g[1], g[2]));
		}
		//从起点到该点的距离
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;

		//for each vertex, apply relaxation for all the edges
		//图有n个点，又不能有回路，所以最短路径最多n-1边。又因为每次循环，至少relax一边所以最多n-1次就行了
		//Relaxation as it is called in the CLRS is called (|G.V| -1) times which is the longest possible stops in the whole graph.
		for(int v=0;v<n-1;v++){
			for(Edge e : edges){
				if(dist[e.from] + e.cost < dist[e.to]){
					dist[e.to] = dist[e.from] + e.cost;
				}
			}
		}

		//second time to detect which nodes are part of negative cycle
		//a negative cycle has occurred if we can find a better path beyond the optimal solution
		for(int v=0;v<n-1;v++){
			for(Edge e : edges){
				if(dist[e.from] + e.cost < dist[e.to]){
					dist[e.to] = Integer.MIN_VALUE;
				}
			}
		}
	}
}
