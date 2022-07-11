//dfs
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