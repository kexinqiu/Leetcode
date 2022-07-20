


//dijkstra
class Solution {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		// Build the adjacency matrix
		int adjMatrix[][] = new int[n][n];

		for (int[] flight: flights) {
			adjMatrix[flight[0]][flight[1]] = flight[2];
		}

		// Shortest distances array
		int[] flightPrice = new int[n];

		// Shortest steps array
		int[] currentStops = new int[n];

		Arrays.fill(flightPrice, Integer.MAX_VALUE);
		Arrays.fill(currentStops, Integer.MAX_VALUE);
		flightPrice[src] = 0;
		currentStops[src] = 0;

		// The priority queue would contain (node, cost, stops)
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		minHeap.offer(new int[]{src, 0, 0});

		while (!minHeap.isEmpty()) {

			int[] info = minHeap.poll();
			int currNode = info[0];

			int currCost = info[1];
			int stops = info[2];

			// If destination is reached, return the cost to get here
			if (currNode == dst) {
				return currCost;
			}

			// If there are no more steps left, continue
			if (stops == K + 1) {
				continue;
			}

			// Examine and relax all neighboring edges if possible
			for (int neibor = 0; neibor < n; neibor++) {
				if (adjMatrix[currNode][neibor] > 0) {

					// Better cost?
					if (currCost + adjMatrix[currNode][neibor] <  flightPrice[neibor]) {
						minHeap.offer(new int[]{neibor, currCost + adjMatrix[currNode][neibor], stops + 1});
						flightPrice[neibor] = currCost + adjMatrix[currNode][neibor];
						currentStops[neibor] = stops;
					}
					// 如果当前经过的stop比之前记录的少, 表明我们还有可能抢救一下
					//已经遍历过的node且价格已为目前最低，仍要加入queue，因为目前stop少后续node相加仍可能出现低价
					else if (stops < currentStops[neibor]) {
						minHeap.offer(new int[]{neibor, currCost + adjMatrix[currNode][neibor], stops + 1});
					}
				}
			}
		}

		return flightPrice[dst] == Integer.MAX_VALUE? -1 : flightPrice[dst];
	}
}


//bellman ford
//注意1. 在k+1内循环
//注意2. 需要clone

//tc O(k∗（m+n）) 共进行 k + 1 次迭代，每次迭代备份数组复杂度为 O(n)，然后遍历所有的边进行松弛操作，复杂度为 O(m)
//sc O(n + m)
class Solution {

	class Edge{
		int from;
		int to;
		int price;

		public Edge(int v, int e, int price){
			this.from = v;
			this.to = e;
			this.price = price;
		}
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		List<Edge> list = new ArrayList<>();

		for(int[] flight : flights){
			int from = flight[0];
			int to = flight[1];
			int price = flight[2];

			list.add(new Edge(from, to, price));
		}

		int[] flightPrice = new int[n];
		Arrays.fill(flightPrice, Integer.MAX_VALUE);

		flightPrice[src] = 0;

		//迭代一次，只能保证一条边为最短路径
		for(int v=0;v<K+1;v++){
			// 需要克隆因为可能找到一条最短的路不在k之内
			// you cannot successively get two shortest path along the line! This means with k+1 times relaxations you cannot even change c[dest]'s value of infinity if theoretical shortest path has more than k stops.
			int[] clone = flightPrice.clone();
			for(Edge e : list){
				int from = e.from;
				int to = e.to;
				int price = e.price;
				if(clone[from]==Integer.MAX_VALUE) continue;
				if(price + clone[from]<flightPrice[to]){
					flightPrice[to] = price + clone[from];
				}
			}
		}

		return flightPrice[dst]==Integer.MAX_VALUE?-1:flightPrice[dst];

	}
}