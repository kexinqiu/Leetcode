//从边界出发，进行dfs
//与其他岛屿问题不同在于，不是从起点出发逐个dfs，而是从边界出发

class Solution {
	public void solve(char[][] board) {
		if (board == null || board.length == 0) return;

		int row = board.length;
		int col = board[0].length;

		//找到所有边界值，将其变为E
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if((i==0 || i==row-1 || j==0 || j==col-1) && board[i][j]=='O'){
					dfs(board, i, j);
				}
			}
		}
		//将剩下的O（非边界）变为X， 将边界E变回O
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]=='O') board[i][j]='X';
				if(board[i][j]=='E') board[i][j]='O';
			}
		}
	}

	public void dfs(char[][] board, int i, int j){
		//在recursion过程中，可能变为无效值，要一直check valid
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='E' || board[i][j]=='X') return;

		board[i][j] = 'E';

		dfs(board, i+1, j);
		dfs(board, i, j+1);
		dfs(board, i-1, j);
		dfs(board, i, j-1);
	}
}

