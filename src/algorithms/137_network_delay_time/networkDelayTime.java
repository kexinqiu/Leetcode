//我们需要求出节点 kk 到其余所有点的最短路，其中的最大值就是答案。若存在从 k 出发无法到达的点，则返回 -1。

//PriorityQueue - heap
//V is the number of vertices, E is the number of Edge
//using adjacency list representation of the graph and a min-heap to store the unvisited vertices
//the time to visit each vertex becomes O(V+E)
// and the time required to process all the neighbours of a vertex becomes O(logV).
//tc:O((V+E)logV)

//The space complexity in this case will also improve to O(V)
// as both the adjacency list and min-heap require O(V) space
//sc:O(V)+O(V)=O(2V) = O(V)

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


//bfs
//tc:O(N⋅E)
//sc:O(N⋅E)
class Solution {
	// Adjacency list
	Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

	private void BFS(int[] signalReceivedAt, int sourceNode) {
		Queue<Integer> q = new LinkedList<>();
		q.add(sourceNode);

		// Time for starting node is 0
		signalReceivedAt[sourceNode] = 0;

		while (!q.isEmpty()) {
			int currNode = q.remove();

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
				int arrivalTime = signalReceivedAt[currNode] + time;
				if (signalReceivedAt[neighborNode] > arrivalTime) {
					signalReceivedAt[neighborNode] = arrivalTime;
					q.add(neighborNode);
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

			adj.putIfAbsent(source, new ArrayList<>());
			adj.get(source).add(new Pair(travelTime, dest));
		}

		int[] signalReceivedAt = new int[n + 1];
		Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

		BFS(signalReceivedAt, k);

		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, signalReceivedAt[i]);
		}

		// INT_MAX signifies atleat one node is unreachable
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
}
