//首先这道题实际上求 腐烂的橘子到最远的新鲜橘子的最短距离
//1.一开始，我们找出所有腐烂的橘子，将它们放入队列，作为第 0 层的结点。
//2.然后进行 BFS 遍历，每个结点的相邻结点可能是上、下、左、右四个方向的结点，注意判断结点位于网格边界的特殊情况。
//3.由于可能存在无法被污染的橘子，我们需要记录新鲜橘子的数量。在 BFS 中，每遍历到一个橘子（污染了一个橘子），就将新鲜橘子的数量减一。如果 BFS 结束后这个数量仍未减为零，说明存在无法被污染的橘子。

//tc:o(n) n is the numver of cells
//sc:o(n) n is the numver of cells
class Solution {
	public int orangesRotting(int[][] grid) {


		Queue<int[]> queue = new LinkedList<>();

		//新鲜橘子
		int count = 0;

		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==1) count++;
				else if(grid[i][j]==2) queue.offer(new int[]{i, j});
			}
		}

		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

		//全部腐烂的轮数
		int round = 0;

		while(count>0 && !queue.isEmpty()){
			round++;
			for(int n=queue.size();n>0;n--){
				int[] orange = queue.poll();

				for(int[] d : directions){
					int newI = orange[0]+d[0];
					int newJ = orange[1]+d[1];

					if(newI>=0 && newI<grid.length &&
						newJ>=0 && newJ<grid[0].length &&
						grid[newI][newJ]==1){

						queue.offer(new int[]{newI, newJ});
						count--;
						grid[newI][newJ]=2;
					}
				}
			}
		}
		if(count>0) return -1;
		else return round;
	}
}