//tc: o(N*K) N be the number of cells in the grid, and K be the quota to eliminate obstacles.
//In the worst case, we will visit each cell in the grid. And for each cell, at most, it will be visited K times

//sc: o(N*K) In the worst case, the queue will contain the majority of the possible states that we need to visit


class Solution {
	public int shortestPath(int[][] grid, int k) {
		int m=grid.length;
		int n=grid[0].length;
		//特殊情况
		if(m==1&&n==1) return 0;

		//同一个点会由多个路径到达，每个路径的障碍数都不一样，只要横纵坐标和消除障碍数不一致，则说明这条路径没有visited，可以加入队列
		int[][][] visited = new int[m][n][k+1];
		int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		//步数
		int minStep = 0;

		Queue<Point> queue = new LinkedList<>();
		//题目已知，起点非障碍
		queue.offer(new Point(0,0,0));
		visited[0][0][0] = 1;

		while(!queue.isEmpty()){
			minStep++;
			int size = queue.size();
			for(int t=size;t>0;t--){
				Point p = queue.poll();
				int x = p.x;
				int y = p.y;
				int count = p.count;
				for(int[] d:directions){
					int newX = x + d[0];
					int newY = y + d[1];

					if(newX<0 || newX>=m || newY<0 || newY>=n) continue;
					if(newX==m-1 && newY==n-1) return minStep;
					if(grid[newX][newY]==1 && count>=k) continue;

					int newCount = grid[newX][newY]==1 ? count+1 : count;

					if(visited[newX][newY][newCount]==0){
						visited[newX][newY][newCount]=1;
						queue.offer(new Point(newX, newY, newCount));
					}
				}
			}
		}

		return -1;
	}
}

class Point{
	//横坐标
	int x;
	//纵坐标
	int y;
	//消除障碍数
	int count;

	public Point(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}