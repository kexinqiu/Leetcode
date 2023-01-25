
//格式1
class Solution {
	private int row;
	private int col;
	private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public int maxAreaOfIsland(int[][] grid) {

		row = grid.length;
		col = grid[0].length;
		boolean[][] used = new boolean[row][col];
		int maxA = 0;

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j]==1){
					maxA = Math.max(maxA, dfs(grid, used, i, j));
				}
			}
		}
		return maxA;
	}

	public int dfs(int[][] grid, boolean[][] used, int i, int j){

		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length ||  grid[i][j]!=1 || used[i][j]==true) return 0;

		used[i][j] = true;
		int currA = 1;

		return currA + dfs(grid, used, i+1, j) + dfs(grid, used, i, j+1) + dfs(grid, used, i-1, j) + dfs(grid, used, i, j-1);
	}
}


//格式2
class Solution {
	private int row;
	private int col;
	private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public int maxAreaOfIsland(int[][] grid) {

		row = grid.length;
		col = grid[0].length;
		boolean[][] used = new boolean[row][col];
		int maxA = 0;

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j]==1){
					maxA = Math.max(maxA, dfs(grid, used, i, j));
				}
			}
		}
		return maxA;
	}

	public int dfs(int[][] grid, boolean[][] used, int i, int j){
		used[i][j] = true;
		int currA = 1;

		for(int[] d: directions){
			int newI = i + d[0];
			int newJ = j + d[1];
			if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid[0].length && used[newI][newJ]==false && grid[newI][newJ]==1){
				currA += dfs(grid, used, newI, newJ);
			}
		}
		return currA;
	}
}