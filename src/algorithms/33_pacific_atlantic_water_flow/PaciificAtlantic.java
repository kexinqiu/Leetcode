class Solution {
	// if we start from the cells connected to pacific ocean (at the edge) and visit all cells having height greater than current cell (water can only flow from a cell to another one with height equal or lower), we are able to get a subset that contains all cells connecting to the pacific ocean
//we do the same thing to get the subsets that contains all cells connecting to the atlantic ocean
// The final answer we get will be the intersection of two sets
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> res = new ArrayList<>();

		int m = heights.length;
		if(m==0) return res;
		int n = heights[0].length;

		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		// denotes cells reachable starting from atlantic and pacific edged cells respectively
		//top and bottom
		for(int col=0; col<n; col++){
			callDFS(heights, 0, col, heights[0][col], pacific);
			callDFS(heights, m-1, col, heights[m-1][col], atlantic);
		}
		// denotes cells reachable starting from atlantic and pacific edged cells respectively
		//left and right
		for(int row=0;row<m;row++){
			callDFS(heights, row, 0, heights[row][0], pacific);
			callDFS(heights, row, n-1, heights[row][n-1], atlantic);
		}

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(pacific[i][j] && atlantic[i][j]){
					List<Integer> tmp = new ArrayList<>();
					tmp.add(i);
					tmp.add(j);
					res.add(tmp);
				}
			}
		}
		return res;
	}
	public void callDFS(int[][] height, int row, int col, int prevH, boolean[][] ocean){
		if(row<0 ||
			row>= height.length ||
			col<0 ||
			col>=height[row].length ||
			height[row][col]<prevH ||
			ocean[row][col]) return;

		ocean[row][col] = true;
		//check for adjacent cell
		callDFS(height, row+1, col, height[row][col], ocean);
		callDFS(height, row-1, col, height[row][col], ocean);
		callDFS(height, row, col+1, height[row][col], ocean);
		callDFS(height, row, col-1, height[row][col], ocean);
	}
}