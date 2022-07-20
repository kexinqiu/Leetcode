class Solution {
	public int shortestPathBinaryMatrix(int[][] grid) {
		if(grid[0][0]!=0 || grid[grid.length - 1][grid[0].length - 1]!=0) return -1;
		if(grid.length==1) return 1;

		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[]{0,0});
		grid[0][0] = 2;
		int path = 1;

		int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

		while(!queue.isEmpty()){
			path++;
			int size = queue.size();
			for(int n=size;n>0;n--){
				int[] cell = queue.poll();
				for(int[] d : directions){
					int newI = cell[0]+d[0];
					int newJ = cell[1]+d[1];
					if(newI>=0 && newI<grid.length &&
						newJ>=0 && newJ<grid[0].length &&
						grid[newI][newJ]==0){
						//要记住判断是否能够到达目标终点
						if(newI == grid.length-1 && newJ == grid[0].length-1) return path;

						grid[newI][newJ]=2;
						queue.offer(new int[]{newI, newJ});
					}
				}
			}
		}
		return -1;
	}
}