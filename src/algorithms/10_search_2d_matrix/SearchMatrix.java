class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null) return false;

		int row = matrix.length;
		int col = matrix[0].length;

		int start = 0;
		int end = row * col - 1;

		while(start<=end){
			int mid = start+(end-start)/2;

			int mid_element = matrix[mid/col][mid%col];

			if(mid_element==target) return true;
			else if(mid_element>target) end = mid -1;
			else start = mid+1;
		}
		return false;
	}
}