//怎么判断能否修完所有课？
//BFS 结束时，如果仍有课的入度不为 0，无法被选，完成不了所有课。否则，能找到一种顺序把所有课上完。
//或者：用一个变量 count 记录入列的顶点个数，最后判断 count 是否等于总课程数。

class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//1. initilize all array we need
		int[] inDegree = new int[numCourses];
		Map<Integer, List<Integer>> adj = new HashMap<>();

		//2. Create the adjacency list representation of the graph

		for(int i=0;i<prerequisites.length;i++){
			int dest = prerequisites[i][0];
			int src = prerequisites[i][1];

			List<Integer> list = adj.getOrDefault(src, new ArrayList<Integer>());
			list.add(dest);
			adj.put(src, list);

			// Record in-degree of each vertex
			inDegree[dest]++;
		}

		//3. Add all vertices with 0 in-degree to the queue
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<numCourses;i++){
			if(inDegree[i]==0) queue.offer(i);
		}

		int i = 0;
		//get the course whose indegree is 0 in queue one by one
		while(!queue.isEmpty()){
			int course = queue.poll();
			//store into the result array
			i++;
			//get the adjacency of the course
			if(adj.containsKey(course)){
				for(int c :adj.get(course)){
					//// Reduce the in-degree of each neighbor by 1
					inDegree[c]--;
					// // If in-degree of a neighbor becomes 0, add it to the queue
					if(inDegree[c]==0) queue.offer(c);
				}
			}
		}


		return i==numCourses;
	}
}
