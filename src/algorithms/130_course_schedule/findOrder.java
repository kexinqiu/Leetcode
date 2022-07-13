//dfs - topologic sort

//tc: o(E+V) V represents the number of vertices and E represents the number of edges. We pop each node exactly once from the zero in-degree queue and that gives us V. Also, for each vertex, we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us E.

//SC :o(E+V)
//In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices
//we also use the adjacency list to represent our graph initially. The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent nodes in the form of a list as the value.

class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		//1. initilize all array we need
		int[] courseOrder = new int[numCourses];
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
			courseOrder[i] = course;
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
		// Check to see if topological sort is possible or not.
		if(i==numCourses) return courseOrder;

		return new int[0];
	}
}