//bfs

//tc: o(v+e)
//sc: o(v)
class Solution {
	public boolean isBipartite(int[][] graph) {
		// 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
		int[] visited = new int[graph.length];
		Queue<Integer> queue = new LinkedList<>();

		for(int i=0;i<graph.length;i++){
			// 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
			if(visited[i]!=0) continue;
			//将顶点存入队列
			queue.offer(i);
			visited[i] = 1;
			// 每出队一个顶点，将其所有邻接点染成相反的颜色并入队。
			while(!queue.isEmpty()){
				int tmp = queue.poll();

				for(int t : graph[tmp]){
					// 如果当前顶点的某个邻接点已经被染过色了，且颜色和当前顶点相同，说明此无向图无法被正确染色，返回 false。
					if(visited[t]==visited[tmp]) return false;
					if(visited[t]==0){
						visited[t] = -visited[tmp];
						queue.offer(t);
					}
				}
			}
		}
		return true;
	}
}

//dfs
//tc: o(v+e)
//sc: o(v)

class Solution {
	public boolean isBipartite(int[][] graph) {
		// 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
		int[] visited = new int[graph.length];

		for(int i=0;i<graph.length;i++){
			if(visited[i]!=0) continue;
			if(visited[i]==0 && !dfs(graph, visited, i, 1)) return false;
		}
		return true;
	}

	public boolean dfs(int[][] graph, int[] visited, int i, int color){
		//// 如果要对某顶点染色时，发现它已经被染色了，则判断它的颜色是否与本次要染的颜色相同，如果矛盾，说明此无向图无法被正确染色，返回 false
		if(visited[i]!=0) {
			return visited[i]==color;
		}

		visited[i] = color;

		for(int n : graph[i]){
			if(!dfs(graph, visited, n, -color)) return false;
		}
		return true;
	}
}