//tc: o(n) n is the number of cells
//sc: o(1)

class Solution {
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;

		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==1){
					perimeter += 4;
					perimeter = dfs(grid, i, j, perimeter);
				}
			}
		}
		return perimeter;
	}

	public int dfs(int[][] grid, int i, int j, int perimeter){
		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

		for(int[] d : directions){
			int newI = i + d[0];
			int newJ = j + d[1];
			if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid[0].length){
				perimeter -= grid[newI][newJ];
			}
		}
		return perimeter;
	}
}