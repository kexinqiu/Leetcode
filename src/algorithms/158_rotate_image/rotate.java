//tc:o(n*n) n 是 matrix 的边长
//sc:o(n*n)
//对于矩阵中的元素 matrix[row][col]，在旋转后，它的新位置为matrix_new[col][n-row-1]
class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int[][] matrix_new = new int[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix_new[j][n-i-1]=matrix[i][j];
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=matrix_new[i][j];
			}
		}

	}
}

//tc:o(n*n) n 是 matrix 的边长
//sc:o(1)
//先水平翻转，再对角线翻转
class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// 水平翻转
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < n; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = temp;
			}
		}
		// 主对角线翻转
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}