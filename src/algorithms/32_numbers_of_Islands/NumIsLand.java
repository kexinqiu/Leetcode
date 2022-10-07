//dfs
//tc o(nm) m is the number of row, n is the number of column
class Solution {
	public int numIslands(char[][] grid) {
		//store the number of lands
		int count = 0;
		//iterate over the given grids
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j] == '1'){
					count++;
					//this recursion will mark all lands as water, and check its adjacent sites
					callDFS(grid, i, j);
				}
			}
		}
		return count;
	}


	//This method approaches the problem as one of depth-first connected components search
	public void callDFS(char[][] grid, int i, int j){
		//check for invalid index and for sites aren't lands, it is the point to exit the recursion
		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0') return;
		//mark the land as water
		grid[i][j]='0';

		// Check all adjacent sites
		//depth first
		callDFS(grid, i+1, j);
		callDFS(grid, i-1, j);
		callDFS(grid, i, j+1);
		callDFS(grid, i, j-1);
	}
}

//dfs
class Solution {
	public int numIslands(char[][] grid) {
		int count = 0;

		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='1'){
					count++;
					callDFS(grid, i, j);
				}
			}
		}
		return count;
	}

	//This method approaches the problem as one of depth-first connected components search
	public void callDFS(char[][] grid, int i, int j){
		grid[i][j] = '2';

		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		for(int[] d : directions){
			int newI = i + d[0];
			int newJ = j + d[1];
			if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid[0].length && grid[newI][newJ]!='0' && grid[newI][newJ]!='2') {
				callDFS(grid, newI, newJ);
			}
		}
	}
}

//bfs
//tc: o(mn)
//sc : o(min(m,n)) because in worst case where the grid is filled with lands, 此时queue里的element最多也是o(min(m,n))
// the size of queue can grow up to min(M,N)
class Solution {
	public int numIslands(char[][] grid) {
		int count = 0;

		Queue<int[]> queue = new LinkedList<>();
		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='1'){
					queue.offer(new int[]{i, j});
					count++;

					while(!queue.isEmpty()){
						int[] cell = queue.poll();

						for(int[] d : directions){
							int newX = cell[0] + d[0];
							int newY = cell[1] + d[1];

							if(newX>=0 && newX<grid.length &&
								newY>=0 && newY<grid[0].length &&
								grid[newX][newY]=='1' ) {

								queue.offer(new int[]{newX, newY});
								grid[newX][newY] = '2';
							}
						}
					}
				}
			}
		}
		return count;
	}
}