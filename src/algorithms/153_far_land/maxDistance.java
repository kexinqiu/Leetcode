//tc: o(m*n)
//sc: o(min(m, n))
//bfs
class Solution {
	public int maxDistance(int[][] grid) {
		int distance = -1;

		int n = grid.length;
		int m = grid[0].length;

		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

		Queue<int[]> queue = new LinkedList<>();

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==1)
					queue.add(new int[]{i, j});
			}
		}

		if(queue.isEmpty() || queue.size()==n*m) return -1;

		while(!queue.isEmpty()){
			int size = queue.size();
			distance++;

			for(int s=0;s<size;s++){
				int[] tmp = queue.poll();
				int x = tmp[0];
				int y = tmp[1];

				for(int[] d : directions){
					int newX = tmp[0]+d[0];
					int newY = tmp[1]+d[1];

					if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY]==0){
						grid[newX][newY]=2;
						queue.add(new int[]{newX, newY});
					}
				}

			}
		}
		return distance;
	}
}