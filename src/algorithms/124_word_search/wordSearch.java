
//tc: o(n * 3^L) n is the number of cells in the board and L is the length of the word
// For the backtracking function, initially we could have at most 4 directions to explore,
// but further the choices are reduced into 3 (since we won't go back to where we come from).
// As a result, the execution trace after the first step could be visualized as a 3-ary tree,
// each of the branches represent a potential exploration in the corresponding direction.

//We iterate through the board for backtracking, i.e. there could be NN times

//sc:o(min(nm,L)) L is the length of the word
// The maximum length of the call stack would be the length of the word.
// the boolean array need mn to store

//回溯： 深度优先+状态重置
//在二维平面或二维数组中，要经常食用偏移量数组，即direction

class Solution {

	private static final int[][] direction = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
	int row;
	int col;

	public boolean exist(char[][] board, String word) {

		row = board.length;
		col = board[0].length;

		if(row==0) return false;
		boolean[][] used = new boolean[row][col];


		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(backtracking(board, used, word, i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean backtracking(char[][] board, boolean[][] used, String word, int i, int j, int index){
		//base case
		if(index == word.length()-1) {
			return board[i][j]==word.charAt(index);
		}
		if(board[i][j]==word.charAt(index)){
			used[i][j] = true;
			for(int[] d : direction){
				int newI = i + d[0];
				int newJ = j + d[1];
				if(newI>=0 && newI<row && newJ>=0 && newJ<col && !used[newI][newJ]){
					if(backtracking(board, used, word, newI, newJ, index+1)){
						return true;
					}
				}
			}
			used[i][j]=false;
		}
		return false;
	}
}