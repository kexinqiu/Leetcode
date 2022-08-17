//一层一层遍历，最上面一层，最右边一层，最下面一层，最左边一层，order: right -> down -> left -> up
//每次我们traverse了一层，都要相应更改边界，直到不符合边界条件，说明已经遍历结束，不能再继续
//tc:o(m*n)
//sc:o(1) 不包含输出数组
class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();

		//edge case
		if(matrix.length==0) return res;

		int rowStart = 0;
		int rowEnd = matrix.length-1;
		int colStart = 0;
		int colEnd = matrix[0].length-1;

		while(rowStart<=rowEnd && colStart<=colEnd){
			//traverse right
			for(int i=colStart;i<=colEnd;i++){
				res.add(matrix[rowStart][i]);
			}
			//重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
			if(++rowStart>rowEnd) break;

			//traverse down
			for(int i=rowStart;i<=rowEnd;i++){
				res.add(matrix[i][colEnd]);
			}
			//重新设定右边界
			if(--colEnd<colStart) break;


			//traverse left
			for(int i=colEnd;i>=colStart;i--){
				res.add(matrix[rowEnd][i]);
			}
			//重新设定下边界
			if(--rowEnd<rowStart) break;

			//traverse up
			for(int i=rowEnd;i>=rowStart;i--){
				res.add(matrix[i][colStart]);
			}
			//重新设定左边界
			if(++colStart>colEnd) break;
		}
		return res;
	}
}